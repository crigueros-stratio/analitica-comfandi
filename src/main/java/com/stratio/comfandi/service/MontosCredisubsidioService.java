package com.stratio.comfandi.service;

import java.util.ArrayList;
import java.util.List;

import com.stratio.comfandi.entity.MontosCredisubsidioEntity;
import com.stratio.comfandi.repository.MontosCredisubsidioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MontosCredisubsidioService {

  @Autowired
  private MontosCredisubsidioRepository montosCredisubsidioRepository;

  public List<MontosCredisubsidioEntity> obtenerMontosCredisubsidio() {
    List<MontosCredisubsidioEntity> result = new ArrayList<MontosCredisubsidioEntity>();
    montosCredisubsidioRepository.findAll().forEach(result::add);
    return result;
  }
}
