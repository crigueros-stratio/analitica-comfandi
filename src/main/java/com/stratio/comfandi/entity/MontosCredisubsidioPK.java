
package com.stratio.comfandi.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MontosCredisubsidioPK implements Serializable {

  public MontosCredisubsidioPK(){}

  public String obligacionConMora;
  public Integer anioMora;
  public String categoriaCredisubsidio;
  public Long totalCreditos;

}
