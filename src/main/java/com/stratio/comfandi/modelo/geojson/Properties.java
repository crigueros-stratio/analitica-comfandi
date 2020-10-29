package com.stratio.comfandi.modelo.geojson;

public class Properties {
  private Integer seccion;
  private Integer centroDeCosto;
  private String  anio;
  private Long totalUnidades;

  public Properties(Integer seccion,Integer centroDeCosto, String anio, Long totalUnidades) {
    this.seccion = seccion;
    this.centroDeCosto = centroDeCosto;
    this.anio = anio;
    this.totalUnidades = totalUnidades;
  }

  public Integer getSeccion() {
    return seccion;
  }

  public Integer getCentroDeCosto() {
    return centroDeCosto;
  }

  public String  getAnio() {
    return anio;
  }

  public Long  getTotalUnidades() {
    return totalUnidades;
  }
}