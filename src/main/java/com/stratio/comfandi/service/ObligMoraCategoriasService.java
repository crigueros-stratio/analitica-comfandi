package com.stratio.comfandi.service;

import java.util.ArrayList;
import java.util.List;

import com.stratio.comfandi.entity.ObligMoraCategoriasEntity;
import com.stratio.comfandi.repository.ObligMoraCategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ObligMoraCategoriasService {

  @Autowired
  private ObligMoraCategoriasRepository obligMoraCategoriasRepository;

  public List<ObligMoraCategoriasEntity> obtenerObligMoraCategorias() {
    List<ObligMoraCategoriasEntity> result = new ArrayList<ObligMoraCategoriasEntity>();
    obligMoraCategoriasRepository.findAll().forEach(result::add);
    return result;
  }
}
