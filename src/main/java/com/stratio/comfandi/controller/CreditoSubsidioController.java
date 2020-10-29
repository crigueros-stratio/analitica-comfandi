package com.stratio.comfandi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stratio.comfandi.entity.MoraCredisubsidioEntity;
import com.stratio.comfandi.service.MoraCredisubsidioService;
import com.stratio.comfandi.entity.ObligMoraCategoriasEntity;
import com.stratio.comfandi.service.ObligMoraCategoriasService;
import com.stratio.comfandi.entity.MontosCredisubsidioEntity;
import com.stratio.comfandi.service.MontosCredisubsidioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CreditoSubsidioController {

  @Autowired
  private MoraCredisubsidioService moraCredisubsidioService;

  @Autowired
  private ObligMoraCategoriasService obligMoraCategoriasService;

  @Autowired
  private MontosCredisubsidioService montosCredisubsidioService;


  @GetMapping("/moracreditosubsidio")
  ResponseEntity<List<MoraCredisubsidioEntity>> getMoraCredisubsidio() {
    return ResponseEntity.ok().body(moraCredisubsidioService.obtenerMoraCredisubsidio());
  }

  @GetMapping("/moracredisubsidio_front")
  public List<Map<String, Object>> getMoraCredisubsidioFrontend() {
    List<Map<String, Object>> listToReturn = new ArrayList();
    for (MoraCredisubsidioEntity moras: moraCredisubsidioService.obtenerMoraCredisubsidio()) {
      Map<String, Object> data = new HashMap<String, Object>();
      data.put("aniomora", moras.getAnioMora());
      data.put("obligacionconmora", moras.getObligacionConMora());
      data.put("total_creditos", moras.getTotalCreditos());
      listToReturn.add(data);
    }

    return listToReturn;
  }

  @GetMapping("/obligmoracategorias")
  ResponseEntity<List<ObligMoraCategoriasEntity>> getObligMoraCategorias() {
    return ResponseEntity.ok().body(obligMoraCategoriasService.obtenerObligMoraCategorias());
  }

  @CrossOrigin(origins = "http://backend-analytics.sparta.comfandi.marathon.mesos:8080")
  @GetMapping("/montoscredisubsidio")
  ResponseEntity<List<MontosCredisubsidioEntity>> getMontosCredisubsidio() {
    return ResponseEntity.ok().body(montosCredisubsidioService.obtenerMontosCredisubsidio());
  }

  @CrossOrigin(origins = "http://backend-analytics.sparta.comfandi.marathon.mesos:8080", allowedHeaders = "*")
  @GetMapping("/montoscredisubsidio_front")
  public List<Map<String, Object>> getMontosCredisubsidioFrontend() {
    List<Map<String, Object>> listToReturn = new ArrayList();
    for (MontosCredisubsidioEntity monto: montosCredisubsidioService.obtenerMontosCredisubsidio()) {
      Map<String, Object> data = new HashMap<String, Object>();
      data.put("anio_mora", monto.getAnioMora());
      data.put("categoria_credisubsidio", monto.getCategoriaCredisubsidio());
      data.put("obligacion_con_mora", monto.getObligacionConMora());
      data.put("total_creditos", monto.getTotalCreditos());
      listToReturn.add(data);
    }

    return listToReturn;
  }

}
