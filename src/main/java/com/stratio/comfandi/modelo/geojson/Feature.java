package com.stratio.comfandi.modelo.geojson;

public class Feature {

  private final String type = "Feature";
  private Geometry geometry;
  private Properties properties;

  public Feature(Geometry geometry, Properties properties) {
    this.geometry = geometry;
    this.properties = properties;
  }

  public String getType() {
    return type;
  }

  public Geometry getGeometry() {
    return geometry;
  }

  public Properties getProperties() {
    return  properties;
  }

}