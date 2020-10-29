package com.stratio.comfandi.service;

import java.util.List;

import com.stratio.comfandi.entity.NestedTreemapEntity;
import com.stratio.comfandi.repository.NestedTreemapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NestedTreemapService {

  @Autowired
  private NestedTreemapRepository nestedTreemapRepository;

  public List<NestedTreemapEntity> obtenergTreemap(String year, String mora) {
    if (mora.equals("TODOS")) {
      return nestedTreemapRepository.getNestedTreemapTodos(year);
    } else {
      return nestedTreemapRepository.findByYearAndAndObligacionConMora(year, mora);
    }
  }
}
