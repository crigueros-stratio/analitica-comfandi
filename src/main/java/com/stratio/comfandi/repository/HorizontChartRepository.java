package com.stratio.comfandi.repository;

import java.util.List;

import com.stratio.comfandi.entity.HorizontChartEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HorizontChartRepository extends CrudRepository<HorizontChartEntity, String> {

  /* QUERY UTILIZADO POR SPARTA PARA GENERAR EL DATAMARK */
  String query = "select "
      + "t1.anio, "
      + "t1.week, "
      + "t1.centro_de_costo, "
      + "t2.punto_de_venta, "
      + "t1.seccion, "
      + "t1.descripcion_seccion, "
      + "sum(t1.valor_por_unidades) total "
      + "from comprasconcreditorotativoresult t1 "
      + "left join ( "
      + "    select distinct * from coordenadas_super_y_droguerias where (cod_punto, tipo) IN "
      + "    (select cod_punto,MAX(tipo) from coordenadas_super_y_droguerias group by cod_punto) "
      + ") t2 on CAST ( t1.centro_de_costo AS text) = t2.cod_punto "
      + "where t1.anio = :anio "
      + "group by t1.week, t1.anio, t1.centro_de_costo, t1.seccion, t1.descripcion_seccion, t2.punto_de_venta";
  @Query(value = query, nativeQuery = true)
  List<HorizontChartEntity> getHorizontChartByYear(@Param("anio") String anio);

  List<HorizontChartEntity> findByAnio(String anio);

}
