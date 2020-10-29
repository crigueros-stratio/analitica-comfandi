package com.stratio.comfandi.service;

import java.util.ArrayList;
import java.util.List;

import com.stratio.comfandi.entity.MoraCredisubsidioEntity;
import com.stratio.comfandi.repository.MoraCredisubsidioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MoraCredisubsidioService {

  @Autowired
  private MoraCredisubsidioRepository moraCredisubsidioRepository;

  public List<MoraCredisubsidioEntity> obtenerMoraCredisubsidio() {
    List<MoraCredisubsidioEntity> result = new ArrayList<MoraCredisubsidioEntity>();
    moraCredisubsidioRepository.findAll().forEach(result::add);
    return result;
  }
}