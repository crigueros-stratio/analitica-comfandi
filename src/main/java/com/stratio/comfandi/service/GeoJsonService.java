package com.stratio.comfandi.service;

import java.util.ArrayList;
import java.util.List;

import com.stratio.comfandi.entity.GeoJsonEntity;
import com.stratio.comfandi.modelo.geojson.Feature;
import com.stratio.comfandi.modelo.geojson.FeatureCollection;
import com.stratio.comfandi.modelo.geojson.Point;
import com.stratio.comfandi.modelo.geojson.Properties;
import com.stratio.comfandi.repository.GeoJsonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GeoJsonService {

  @Autowired
  private GeoJsonRepository geoJsonRepository;

  public FeatureCollection obtenergGeoJson(String anio, String mora) {
    if (mora.equals("TODOS")) {
      return crearFeatureCollection(geoJsonRepository.findGeoJsonTodos(anio));
    } else {
      return crearFeatureCollection(geoJsonRepository.findByAnioAndObligacionConMora(anio, mora));
    }

  }

  private FeatureCollection crearFeatureCollection(List<GeoJsonEntity> comprasPorTiendasCR) {

    List<Feature> features = new ArrayList<Feature>();

    comprasPorTiendasCR.stream().forEach(compraPorTienda -> {
      Point point = obtenerPunto(compraPorTienda);
      Properties prop = new Properties(compraPorTienda.seccion, compraPorTienda.centroDecCosto,
              compraPorTienda.anio, compraPorTienda.totalUnidades);
      features.add(new Feature(point, prop));
    });

    return new FeatureCollection(features);
  }

  private Point obtenerPunto(GeoJsonEntity compra) {
    return new Point(
      Double.valueOf(compra.cy.replace(",",".")),
      Double.valueOf(compra.cx.replace(",",".")));
  }

}
