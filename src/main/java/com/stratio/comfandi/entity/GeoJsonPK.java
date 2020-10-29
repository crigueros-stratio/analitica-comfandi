package com.stratio.comfandi.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class GeoJsonPK implements Serializable {

  public GeoJsonPK(){}

  public String anio;
  public Integer centroDecCosto;
  public Integer seccion;
  public Long totalUnidades;
  public String descripcionSeccion;
  public String ciudad;
  public String direccion;
  public String cx;
  public String cy;
  public String puntoDeVenta;
  public String formato;

}