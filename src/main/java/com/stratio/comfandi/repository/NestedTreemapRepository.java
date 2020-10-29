package com.stratio.comfandi.repository;

import java.util.List;

import com.stratio.comfandi.entity.NestedTreemapEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTreemapRepository extends CrudRepository<NestedTreemapEntity, String> {

  String queryByYear = "SELECT * FROM ( "
      + "SELECT concat(c.seccion,'-',c.familia) as code, "
      + "  concat(c.seccion) as parent, "
      + "  c.descripcion_familia as name, "
      + "  c.anio as year, "
      + "  sum(c.valor_por_unidades) as value "
      + "  FROM comprasconcreditorotativoresult c WHERE c.anio= :anio "
      + "  GROUP BY c.seccion, c.descripcion_seccion, c.familia, c.descripcion_familia, c.anio "
      + "UNION ("
      + "  SELECT concat(c.seccion) as code, "
      + "  'general'  as parent, "
      + "  c.descripcion_seccion as name, "
      + "  c.anio as year, "
      + "  sum(c.valor_por_unidades) as value "
      + "  FROM comprasconcreditorotativoresult c WHERE c.anio= :anio "
      + "  GROUP BY c.seccion, c.descripcion_seccion, c.anio )"
      + "UNION ("
      + "  SELECT 'general' as code, "
      + "  ''  as parent, "
      + "  'TODAS LAS VENTAS' as name, "
      + "  c.anio as year, "
      + "  sum(c.valor_por_unidades) as value "
      + "  FROM comprasconcreditorotativoresult c WHERE c.anio= :anio "
      + "  GROUP by c.anio ) ) r where r.year = :anio ";

  String queryTodas = "select code, parent, name, year, sum(value) as value, 'TODOS' as obligacion_con_mora  "
      + "from credito_rotativo_datamrk_treemap where year = :anio "
      + "group by code, parent, name, year ";

  @Query(value = queryByYear, nativeQuery = true)
  List<NestedTreemapEntity> getNestedTreemapByYear(@Param("anio") String anio);

  @Query(value = queryTodas, nativeQuery = true)
  List<NestedTreemapEntity> getNestedTreemapTodos(@Param("anio") String anio);

  List<NestedTreemapEntity> findByYearAndAndObligacionConMora(String year, String mora);

}
