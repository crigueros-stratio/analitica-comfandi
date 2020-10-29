
package com.stratio.comfandi.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ObligMoraCategoriasPK implements Serializable {

  public ObligMoraCategoriasPK(){}

  public String obligacionConMora;
  public Integer anioMora;
  public String categoria;
  public Long totalCreditos;

}
