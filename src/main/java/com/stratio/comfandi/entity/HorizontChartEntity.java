package com.stratio.comfandi.entity;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@IdClass(HorizontChartPK.class)
@Table(name = "credito_rotativo_datamark_horizontchart", schema = "public")
public class HorizontChartEntity {

  @Id
  @Column(name = "anio")
  public String anio;

  @Id
  @Column(name = "week")
  public Integer week;

  @Id
  @Column(name = "centro_de_costo")
  public Integer centroDeCosto;

  @Id
  @Column(name = "punto_de_venta")
  public String puntoDeVenta;

  @Id
  @Column(name = "seccion")
  public Integer seccion;

  @Id
  @Column(name = "descripcion_seccion")
  public String descripcionSeccion;

  @Id
  @Column(name = "total")
  public Long total;
}
