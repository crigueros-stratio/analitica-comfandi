package com.stratio.comfandi.repository;

import com.stratio.comfandi.entity.ObligMoraCategoriasEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObligMoraCategoriasRepository extends CrudRepository<ObligMoraCategoriasEntity, String> {}

