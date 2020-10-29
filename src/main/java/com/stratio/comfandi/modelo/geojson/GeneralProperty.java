package com.stratio.comfandi.modelo.geojson;

import java.io.Serializable;
import java.util.HashMap;

public class GeneralProperty {

  private HashMap<String,Serializable> centroDeCosto = new HashMap<>();
  private HashMap<String,String> anio = new HashMap<>();
  private HashMap<String,String> totalUnidades = new HashMap<>();
  private HashMap<String,Serializable> seccion = new HashMap<>();

  public GeneralProperty(HashMap<String,Serializable> seccion, HashMap<String,String> anio,
                         HashMap<String,Serializable> centroDeCosto,  HashMap<String,String> totalUnidades) {
    this.seccion = seccion;
    this.anio = anio;
    this.centroDeCosto = centroDeCosto;
    this.totalUnidades = totalUnidades;
  }

  public GeneralProperty() {
    HashMap<String,Serializable> centroDeCostoDetail = new HashMap<>();

    centroDeCostoDetail.put("510","SAN NICOLAS");
    centroDeCostoDetail.put("511","ALAMEDA");
    centroDeCostoDetail.put("514","TERMINAL");
    centroDeCostoDetail.put("515","GUADALUPE");
    centroDeCostoDetail.put("517","LA MERCED");
    centroDeCostoDetail.put("520","TORRES  DE COMFANDI");
    centroDeCostoDetail.put("521","CIUDADELA");
    centroDeCostoDetail.put("527","CALIPSO");
    centroDeCostoDetail.put("528","CL.15 YUMBO");
    centroDeCostoDetail.put("529","CANDELARIA");
    centroDeCostoDetail.put("535","EL PRADO");
    centroDeCostoDetail.put("536","JAMUNDI");
    centroDeCostoDetail.put("542","BUGA  ASILO");
    centroDeCostoDetail.put("544","DROGUERIA IMBANACO III");
    centroDeCostoDetail.put("546","SAN FERNANDO");
    centroDeCostoDetail.put("547","SANTA ROSA");
    centroDeCostoDetail.put("548","AVENIDA ESTACION");
    centroDeCostoDetail.put("549","BUGA CENTRO");
    centroDeCostoDetail.put("550","IMBANACO PRINCIPAL");
    centroDeCostoDetail.put("556","BUGA PRINCIPAL");
    centroDeCostoDetail.put("557","BUGA PARQUE CABAL");
    centroDeCostoDetail.put("559","FARALLONES");
    centroDeCostoDetail.put("560","VALLE DEL LILI");
    centroDeCostoDetail.put("563","MORICHAL");
    centroDeCostoDetail.put("571","CLINICA DE LOS REMEDIOS");
    centroDeCostoDetail.put("573","AVENIDA SEXTA");
    centroDeCostoDetail.put("574","UNICO");
    centroDeCostoDetail.put("575","CHAPINERO");
    centroDeCostoDetail.put("577","SAN NICOLÁS - CARTAGO");
    centroDeCostoDetail.put("578","CIUDAD JARDIN");
    centroDeCostoDetail.put("579","RAPITIENDA SANTA LUCÍA");
    centroDeCostoDetail.put("608","UNICENTRO");
    centroDeCostoDetail.put("620","CARTAGO PRINCIPAL");
    centroDeCostoDetail.put("623","CARTAGO CLINICA");
    centroDeCostoDetail.put("641","DESEPAZ");
    centroDeCostoDetail.put("646","LA FLORA");
    centroDeCostoDetail.put("647","SANTA TERESITA");
    centroDeCostoDetail.put("648","EL INGENIO");
    centroDeCostoDetail.put("652","SUPER INTER SILOE");
    centroDeCostoDetail.put("654","SUPER INTER MELENDEZ");
    centroDeCostoDetail.put("663","SURTIFAMILIAR ALAMEDA");
    centroDeCostoDetail.put("664","TEQUENDAMA II");
    centroDeCostoDetail.put("672","PROVEEDURÍA ESTACIÓN PALMIRA");
    centroDeCostoDetail.put("703","SUPER INTER YUMBO");
    centroDeCostoDetail.put("704","SUPER INTER PASARELA");
    centroDeCostoDetail.put("712","SUPER INTER CENTRO");
    centroDeCostoDetail.put("715","CAÑAVERALEJO");
    centroDeCostoDetail.put("716","IMBANACO CALLE QUINTA");
    centroDeCostoDetail.put("717","LA MARTINA");
    centroDeCostoDetail.put("718","BAHIA BUENAVENTURA");
    centroDeCostoDetail.put("719","AVENTURA PLAZA");
    centroDeCostoDetail.put("720","CAÑAS GORDAS");
    centroDeCostoDetail.put("721","PALMIRA EXPRESS");
    centroDeCostoDetail.put("722","BUENOS AIRES");
    centroDeCostoDetail.put("723","REY DAVID");
    centroDeCostoDetail.put("724","CENTENARIO");
    centroDeCostoDetail.put("727","SAN JOAQUIN");
    centroDeCostoDetail.put("728","BUGA ESTACIÓN");
    centroDeCostoDetail.put("730","PASOANCHO");
    centroDeCostoDetail.put("731","LOS PINOS");
    centroDeCostoDetail.put("732","COLON");
    centroDeCostoDetail.put("733","AEROPUERTO");
    centroDeCostoDetail.put("734","CALLEJON DE LAS CHUCHAS");
    centroDeCostoDetail.put("735","PALMETTO PLAZA");
    centroDeCostoDetail.put("736","BRISAS");
    centroDeCostoDetail.put("737","PLAZA 70");
    centroDeCostoDetail.put("738","CIUDAD JARDIN II");
    centroDeCostoDetail.put("739","MELENDEZ 2");
    centroDeCostoDetail.put("740","ALFAGUARA");
    centroDeCostoDetail.put("741","JAMUNDI");
    centroDeCostoDetail.put("742","CHIPICHAPE");
    centroDeCostoDetail.put("743","VILLANUEVA");
    centroDeCostoDetail.put("744","LIMONAR");
    centroDeCostoDetail.put("745","CALDAS CALLE QUINTA");
    centroDeCostoDetail.put("746","REINA VICTORIA");
    centroDeCostoDetail.put("747","KRIKA LA PORTADA");
    centroDeCostoDetail.put("748","CALLE 26 CENTRO");
    centroDeCostoDetail.put("749","LLANOGRANDE");
    centroDeCostoDetail.put("750","VERSALLES");
    centroDeCostoDetail.put("751","ELECTRO HOGAR COMFANDI");
    centroDeCostoDetail.put("752","CL.QUINTA 3 DE JULIO");
    centroDeCostoDetail.put("753","HOLGUINES");
    centroDeCostoDetail.put("754","AVE.SEXTA GRANADA");
    centroDeCostoDetail.put("755","CERROS PLAZA");
    centroDeCostoDetail.put("756","AVE. SIMON BOLIVAR");
    centroDeCostoDetail.put("757","PASOANCHO SANTO DOMINGO");
    centroDeCostoDetail.put("758","VILLACOLOMBIA");
    centroDeCostoDetail.put("759","CALLE 10 CIUDAD CAPRI");
    centroDeCostoDetail.put("760","JUANAMBU");
    centroDeCostoDetail.put("761","VIPASA");
    centroDeCostoDetail.put("762","LA FLORESTA");
    centroDeCostoDetail.put("763","AVE.6 LA FLORA 2");
    centroDeCostoDetail.put("764","CL 25 EDS CANEY");
    centroDeCostoDetail.put("765","CLINICA DE OCCIDENTE");
    centroDeCostoDetail.put("766","LA ESTACIÓN PALMIRA");
    centroDeCostoDetail.put("768","PEREIRA PLAZA");
    centroDeCostoDetail.put("769","SURTIFAMILIAR CERRITO");
    centroDeCostoDetail.put("770","SURTIFAMILIAR TULUA");
    centroDeCostoDetail.put("771","SURTIFAMILIAR EL CANEY");
    centroDeCostoDetail.put("772","OVAL PEREIRA");
    centroDeCostoDetail.put("773","CRA.2 HOTEL DANN CARLTON");
    centroDeCostoDetail.put("774","CRA.4 HOTEL IMPERIAL");
    centroDeCostoDetail.put("775","EDS VERSALLES");
    centroDeCostoDetail.put("776","SANTA MONICA");
    centroDeCostoDetail.put("777","GRAN AVENIDA PASTO");
    centroDeCostoDetail.put("778","LAS AVENIDAS PASTO");
    centroDeCostoDetail.put("779","HOTEL PLAZA DEL LILI ");
    centroDeCostoDetail.put("780","PINARES PEREIRA");
    centroDeCostoDetail.put("781","CC UNICO PASTO");
    centroDeCostoDetail.put("783","CIUDAD JARDIN 3");
    centroDeCostoDetail.put("787","CC LA ESTACIÓN");
    centroDeCostoDetail.put("788","EDS TEQUENDAMA");
    centroDeCostoDetail.put("802","PRINCIPAL PALMIRA");
    centroDeCostoDetail.put("804","GINEBRA");
    centroDeCostoDetail.put("808","URGENCIAS 24 HORAS");
    centroDeCostoDetail.put("809","PALMA REAL");
    centroDeCostoDetail.put("810","CARRERA 26");
    centroDeCostoDetail.put("832","CLINICA AMIGA");
    centroDeCostoDetail.put("837","PRINCIPAL TULUA ");
    centroDeCostoDetail.put("838","LA VICTORIA");
    centroDeCostoDetail.put("839","BUGALAGRANDE");
    centroDeCostoDetail.put("840","CHIMINANGOS");
    centroDeCostoDetail.put("841","RAPITIENDA 24 HORAS TULUA");
    centroDeCostoDetail.put("864","PROVEEDURIA EL POBLADO");
    centroDeCostoDetail.put("879","CARRERA 35");
    centroDeCostoDetail.put("905","CALIMA - RAPITIENDA DEL VACACIONAL");
    centroDeCostoDetail.put("538","CC Único");
    centroDeCostoDetail.put("785","SUPER MERC JUMBO");
    centroDeCostoDetail.put("784","TIENDA VIRTUAL");

    HashMap<String,Serializable> seccionDetail = new HashMap<>();

    seccionDetail.put("2","ALIMENTOS");
    seccionDetail.put("3", "FRUVER");
    seccionDetail.put("4", "SALSAMENTARIA");
    seccionDetail.put("5","PAPELERIA");
    seccionDetail.put("6","MEDICAMENTOS");
    seccionDetail.put("9","HOGAR Y MISCELANEOS ");
    seccionDetail.put("10", "ELECTRODOMÉSTICOS");
    seccionDetail.put("11","NO ALIMENTOS ");
    seccionDetail.put("12","GRANOS");
    seccionDetail.put("20","PANADERIA");
    seccionDetail.put("21","COMIDAS RAPIDAS");
    seccionDetail.put("22","POLLO PROCESADO");
    seccionDetail.put("23", "PESCADERIA");
    seccionDetail.put("25","CARNE DE RES Y CERDO");
    seccionDetail.put("99","DEPARTAMENTOS");

    this.anio.put("name", "Año");
    this.totalUnidades.put("name", "Total de unidades vendidas");
    this.centroDeCosto.put("name", "Centro de costo");
    this.centroDeCosto.put("lookup", centroDeCostoDetail);
    this.seccion.put("name", "Seccion");
    this.seccion.put("lookup", seccionDetail);
  }

  public HashMap<String,Serializable> getSeccion() {
    return seccion;
  }

  public HashMap<String,String> getAnio() {
    return anio;
  }

  public HashMap<String,Serializable> getCentroDeCosto() {
    return centroDeCosto;
  }

  public HashMap<String,String> getTotalUnidades() {
    return totalUnidades;
  }

}