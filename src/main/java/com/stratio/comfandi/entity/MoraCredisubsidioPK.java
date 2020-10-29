
package com.stratio.comfandi.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MoraCredisubsidioPK implements Serializable {

  public MoraCredisubsidioPK(){}

  public String obligacionConMora;
  public Integer anioMora;
  public Long totalCreditos;

}