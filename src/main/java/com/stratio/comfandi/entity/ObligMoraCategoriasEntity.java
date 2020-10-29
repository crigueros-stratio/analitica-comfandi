package com.stratio.comfandi.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.IdClass;

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
@IdClass(MoraCredisubsidioPK.class)
@Table(name = "oblig_mora_credisubs_por_categ", schema = "public")
public class ObligMoraCategoriasEntity {

  @Id
  @Column(name = "obligacion_con_mora")
  private String obligacionConMora;

  @Id
  @Column(name = "anio_mora")
  private Integer anioMora;

  @Id
  @Column(name = "categoria")
  private String categoria;

  @Id
  @Column(name = "total_creditos")
  private Long totalCreditos;

  public String getObligacionConMora() {
    return obligacionConMora;
  }

  public void setObligacionConMora(String obligacionConMora) {
    this.obligacionConMora = obligacionConMora;
  }

  public Integer getAnioMora() {
    return anioMora;
  }

  public void setAnioMora(Integer anioMora) {
    this.anioMora = anioMora;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public Long getTotalCreditos() {
    return totalCreditos;
  }

  public void setTotalCreditos(Long totalCreditos) {
    this.totalCreditos = totalCreditos;
  }

}
