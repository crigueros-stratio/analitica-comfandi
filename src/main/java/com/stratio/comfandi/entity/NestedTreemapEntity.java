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
@IdClass(NestedTreemapPK.class)
@Table(name = "credito_rotativo_datamrk_treemap", schema = "public")
public class NestedTreemapEntity {

  @Id
  @Column(name = "code")
  public String code;

  @Id
  @Column(name = "parent")
  public String parent;

  @Id
  @Column(name = "name")
  public String name;

  @Id
  @Column(name = "year")
  public String year;

  @Id
  @Column(name = "value")
  public Long value;

  @Column(name = "obligacion_con_mora")
  public String obligacionConMora;

}
