package com.stratio.comfandi.service;

import java.util.List;

import com.stratio.comfandi.entity.HorizontChartEntity;
import com.stratio.comfandi.repository.HorizontChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorizontChartService {

  @Autowired
  private HorizontChartRepository horizontChartRepository;

  public List<HorizontChartEntity> obtenergHorizontChart(String anio) {
    return horizontChartRepository.findByAnio(anio);
  }
}
