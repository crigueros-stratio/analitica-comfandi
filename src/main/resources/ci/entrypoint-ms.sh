#!/bin/bash

set -e

## VAULT LOGIN =====================================================

    DOCKER_LOG_LEVEL=${DOCKER_LOG_LEVEL:-DEBUG}
    eval LOG_LEVEL_${DOCKER_LOG_LEVEL}
    B_LOG --stdout true # enable logging over stdout

    declare -a VAULT_HOSTS
    IFS_OLD=$IFS
    IFS=',' read -r -a VAULT_HOSTS <<< "$VAULT_HOST"

    declare -a MARATHON_ARRAY
    OLD_IFS=$IFS
    IFS='/' read -r -a MARATHON_ARRAY <<< "$MARATHON_APP_ID"
    IFS=$OLD_IFS

    INFO "Trying to login in Vault"
    # Approle login from role_id, secret_id
    if [ "xxx$VAULT_TOKEN" == "xxx" ];
    then
       INFO "Login in vault..."
       login
       if [[ ${code} -ne 0 ]];
       then
           ERROR "  - Something went wrong log in in vault. Exiting..."
           return ${code}
       fi
    fi
    INFO "  - Logged!"

## CONFIGURE SERVICE NAME ====================================================

    MARATHON_SERVICE_NAME=${MARATHON_ARRAY[-1]}
    INFO "OK: Getting marathon service name: ${MARATHON_SERVICE_NAME}"
    MARATHON_SERVICE_NAME=$(echo $MARATHON_SERVICE_NAME | sed -E 's/(.*)-\d*$/\1/')
    export SPRING_APPLICATION_NAME=${MARATHON_SERVICE_NAME}

    SERVICE_NAME_UNDERSCORE=${VAULT_PATH//[.-\/]/_}
    SERVICE_NAME_UPPERCASE=${SERVICE_NAME_UNDERSCORE^^}
    SERVICE_NAME_CERT=${SERVICE_NAME_UNDERSCORE^^}
    INFO "OK: Getting Service Name cert: ${SERVICE_NAME_CERT}"

    SERVICE_NAME_UPPERCASE=${SERVICE_NAME_UPPERCASE:1:${#SERVICE_NAME_UNDERSCORE}}
    INFO "OK: Getting Service Name uppercase: ${SERVICE_NAME_UPPERCASE}"
    INFO "OK: Getting vault path: ${VAULT_PATH}"
    INFO "OK: Getting marathon service name: ${MARATHON_SERVICE_NAME}"

    RESOURCES_PATH=/etc/stratio
    export PORT0=${PORT0:-"8080"}

## SERVER CERTIFICATES===============================================

    INFO "Getting ca-bundle"
    getCAbundle "${RESOURCES_PATH}" "PEM" \
    && INFO "OK: Getting ca-bundle pem" \
    || INFO "Error: Getting ca-bundle pem"

    getCAbundle "${RESOURCES_PATH}" "JKS" \
    && echo "OK: Getting ca-bundle jks"   \
    ||  echo "Error: Getting ca-bundle jks"

    ${JAVA_HOME}/bin/keytool -noprompt -import -storepass changeit -file ${RESOURCES_PATH}/ca-bundle.pem -alias ${MARATHON_SERVICE_NAME} -keystore ${JAVA_HOME}/lib/security/cacerts

    INFO "Getting service certificate"
    getCert "userland" \
       "${VAULT_PATH}" \
       "${MARATHON_SERVICE_NAME}" \
        "JKS" \
        "${RESOURCES_PATH}" \
    && INFO "OK: Getting ${MARATHON_SERVICE_NAME} certificate jks"   \
    || (ERROR  "Could not retrieve ${MARATHON_SERVICE_NAME} certificate jks" && exit 1)

    getCert "userland" \
                "/${d}${VAULT_PATH}" \
                "${d}${MARATHON_SERVICE_NAME}" \
                "PEM" \
                "${d}${RESOURCES_PATH}" \
    && INFO "OK: Getting ${MARATHON_SERVICE_NAME} certificate pem"   \
    || (ERROR  "Could not retrieve ${MARATHON_SERVICE_NAME} certificate pem" && exit 1)

    export SSL_KEYSTORE_LOCATION="${RESOURCES_PATH}"/${MARATHON_SERVICE_NAME}.jks

    #Setup tenant_normalized for access kms_utils
    export TENANT_NORM=${SERVICE_NAME_CERT//-/_}
    INFO "OK: Getting Tenant norm: ${TENANT_NORM}"

    CERTIFICATE_KEYSTORE_PASSWORD_VARIABLE=${TENANT_NORM}_KEYSTORE_PASS

    export SSL_KEYSTORE_PASSWORD=${!CERTIFICATE_KEYSTORE_PASSWORD_VARIABLE}
    export SSL_KEYPASSWORD=${!CERTIFICATE_KEYSTORE_PASSWORD_VARIABLE}

    ${JAVA_HOME}/bin/keytool -cacerts -storepasswd -storepass changeit -new ${DEFAULT_KEYSTORE_PASS}

## POSTGRES DB =======================================================

    INFO "Postgres connection config start"
    INFO "OK: User ${d}${MARATHON_SERVICE_NAME}"
    export SPRING_DATASOURCE_USERNAME="${d}${MARATHON_SERVICE_NAME}"
    export POSTGRES_CERT="${d}${RESOURCES_PATH}/${d}${MARATHON_SERVICE_NAME}.pem"
    export POSTGRES_KEY="${d}${RESOURCES_PATH}/key.pkcs8"
    export CA_BUNDLE_PEM="${d}${RESOURCES_PATH}/ca-bundle.pem"
    INFO "  - Posgres certificate path ${d}${POSTGRES_CERT}"
    INFO "  - Retreiving service certificate [PEM] from url: /${d}${MARATHON_SERVICE_NAME} "
    INFO "  - [${d}${RESOURCES_PATH}/${d}${MARATHON_SERVICE_NAME}] directory:"

    openssl pkcs8 -topk8 -inform pem -in ${d}${RESOURCES_PATH}/${d}${MARATHON_SERVICE_NAME}.key -outform der -nocrypt -out ${d}${POSTGRES_KEY}

    INFO "  - [${d}${RESOURCES_PATH}] directory:"
    ls ${d}${RESOURCES_PATH}
    export SPRING_DATASOURCE_URL="${d}${POSTGRES_URL}?prepareThreshold=0&ssl=true&sslmode=verify-full&sslcert=${d}${POSTGRES_CERT}&sslrootcert=${d}${CA_BUNDLE_PEM}&sslkey=${d}${POSTGRES_KEY}"
    INFO "  - SPRING_DATASOURCE_URL:  "
    INFO "  - ${d}${SPRING_DATASOURCE_URL}"


## RUN JAVA APP ===================================================

    JAVA_ARGS="--server.port=${PORT0}"
    HEAP_PERCENTAGE=${HEAP_PERCENTAGE:-"80"}
    JAVA_TOOL_OPTIONS=${JAVA_TOOL_OPTIONS:-"-XX:+UseG1GC -XX:MaxRAMPercentage=${HEAP_PERCENTAGE} -XshowSettings:vm"}
    JAVA_CMD="java ${JAVA_TOOL_OPTIONS} -jar /data/app.jar ${JAVA_ARGS}"
    INFO ${JAVA_CMD}
    INFO
    INFO "Starting Spring Boot Service !"
    INFO
    ${JAVA_CMD}
