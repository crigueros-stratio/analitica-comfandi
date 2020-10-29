package com.stratio.comfandi.modelo.geojson;

import java.util.HashMap;
import java.util.List;

public class FeatureCollection {

  private final String type = "FeatureCollection";
  private List<Feature> features;
  private HashMap<String,GeneralProperty> properties = new HashMap<>();

  public FeatureCollection(List<Feature> features) {
    HashMap<String,GeneralProperty> prop = new HashMap<>();
    prop.put("fields", new GeneralProperty());

    this.features = features;
    this.properties = prop;
  }

  public String getType() {
    return this.type;
  }

  public List<Feature> getFeatures() {
    return features;
  }

  public HashMap<String,GeneralProperty> getProperties() {
    return properties;
  }

}