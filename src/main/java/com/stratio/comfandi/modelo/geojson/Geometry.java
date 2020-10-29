package com.stratio.comfandi.modelo.geojson;

public abstract class Geometry {

  private String type;

  public Geometry(String type) {
    this.type = type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}