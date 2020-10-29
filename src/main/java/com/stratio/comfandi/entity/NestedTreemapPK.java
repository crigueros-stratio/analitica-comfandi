package com.stratio.comfandi.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class NestedTreemapPK implements Serializable {

  public NestedTreemapPK(){}

  public String code;
  public String parent;
  public String name;
  public String year;
  public Long value;

}