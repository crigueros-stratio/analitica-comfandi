package com.stratio.comfandi.entity;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

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
@IdClass(GeoJsonPK.class)
@Table(name = "credito_rotativo_datamark_geojson", schema = "public")
public class GeoJsonEntity {

  @Id
  @Column(name = "anio")
  public String anio;

  @Id
  @Column(name = "centro_de_costo")
  public Integer centroDecCosto;

  @Id
  @Column(name = "seccion")
  public Integer seccion;

  @Id
  @Column(name = "total_unidades")
  public Long totalUnidades;

  @Id
  @Column(name = "descripcion_seccion")
  public String descripcionSeccion;

  @Id
  @Column(name = "ciudad")
  public String ciudad;

  @Id
  @Column(name = "direccion")
  public String direccion;

  @Id
  @Column(name = "cx")
  public String cx;

  @Id
  @Column(name = "cy")
  public String cy;

  @Id
  @Column(name = "punto_de_venta")
  public String puntoDeVenta;

  @Id
  @Column(name = "formato")
  public String formato;

  @Column(name = "obligacion_con_mora")
  public String obligacionConMora;
}
