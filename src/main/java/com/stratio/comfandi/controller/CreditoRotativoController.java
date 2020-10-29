package com.stratio.comfandi.controller;

import java.util.List;

import com.stratio.comfandi.entity.HorizontChartEntity;
import com.stratio.comfandi.entity.NestedTreemapEntity;
import com.stratio.comfandi.modelo.geojson.FeatureCollection;
import com.stratio.comfandi.service.GeoJsonService;
import com.stratio.comfandi.service.HorizontChartService;
import com.stratio.comfandi.service.NestedTreemapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CreditoRotativoController {

  @Autowired
  private GeoJsonService customerService;

  @Autowired
  private NestedTreemapService nestedTreemapService;

  @Autowired
  private HorizontChartService horizontChartService;

  @GetMapping("/comprasConCreditoRotativoPorTiendas/Geojson")
  ResponseEntity<FeatureCollection> getGeojson(
          @RequestParam(value = "anio") String anio,
          @RequestParam(value = "mora") String mora) {
    return ResponseEntity.ok().body(customerService.obtenergGeoJson(anio, mora));
  }

  @GetMapping("/comprasConCreditoRotativoPorTiendas/HorizontChart")
  ResponseEntity<List<HorizontChartEntity>> getHorizontChart(@RequestParam(value = "anio") String anio) {
    return ResponseEntity.ok().body(horizontChartService.obtenergHorizontChart(anio));
  }

  @GetMapping("/creditoRotativo/NestedTreemap")
  ResponseEntity<List<NestedTreemapEntity>> getTreemap(
          @RequestParam(value = "anio") String anio,
          @RequestParam(value = "mora") String mora) {
    return ResponseEntity.ok().body(nestedTreemapService.obtenergTreemap(anio, mora));
  }

}
