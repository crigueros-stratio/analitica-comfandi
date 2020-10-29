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
@Table(name = "credisubsidio_mora_por_anio", schema = "public")
public class MoraCredisubsidioEntity {

  @Id
  @Column(name = "obligacion_con_mora")
  private String obligacionConMora;

  @Id
  @Column(name = "anio_mora")
  private Integer anioMora;

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

  public Long getTotalCreditos() {
    return totalCreditos;
  }

  public void setTotalCreditos(Long totalCreditos) {
    this.totalCreditos = totalCreditos;
  }

}
