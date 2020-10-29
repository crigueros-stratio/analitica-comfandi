package com.stratio.comfandi.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class HorizontChartPK implements Serializable {

  public HorizontChartPK(){}

  public String anio;
  public Integer week;
  public Integer centroDeCosto;
  public String puntoDeVenta;
  public Integer seccion;
  public String descripcionSeccion;
  public Long total;

}