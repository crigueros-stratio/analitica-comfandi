package com.stratio.comfandi.repository;

import com.stratio.comfandi.entity.MontosCredisubsidioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MontosCredisubsidioRepository extends CrudRepository<MontosCredisubsidioEntity, String> {}

