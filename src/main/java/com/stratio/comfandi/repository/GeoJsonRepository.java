package com.stratio.comfandi.repository;

import java.util.List;

import com.stratio.comfandi.entity.GeoJsonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoJsonRepository extends CrudRepository<GeoJsonEntity, String> {

  /* QUERY UTILIZADO POR SPARTA PARA GENERAR EL DATAMARK */
  String query = "select * from ( "
      + "select c.anio, "
      + "c.centro_de_costo, "
      + "c.seccion, "
      + "c.descripcion_seccion,  "
      + "sum(c.total_unidades) total_unidades "
      + "from comprasportiendascreditorotativo c "
      + "group by anio,centro_de_costo, seccion, descripcion_seccion "
      + ") t1 "
      + "inner join ( "
      + "   select distinct cod_punto,ciudad,direccion,cx,cy,punto_de_venta,formato,tipo "
      + "    from coordenadas_super_y_droguerias where (cod_punto, tipo) IN "
      + "    (select cod_punto,MAX(tipo) from coordenadas_super_y_droguerias group by cod_punto) "
      + ") t2 on cast(t1.centro_de_costo AS text) = t2.cod_punto where anio = :anio";

  String queryTodos = "select anio, centro_de_costo, seccion, descripcion_seccion, cod_punto, ciudad, direccion,  "
      + "cx, cy, punto_de_venta,formato,tipo, 'TODOS'as obligacion_con_mora, sum(total_unidades) as total_unidades "
      + "from credito_rotativo_datamark_geojson where anio = :anio "
      + "group by anio, centro_de_costo, seccion, descripcion_seccion, cod_punto, ciudad, direccion, "
      + "cx, cy, punto_de_venta,formato,tipo ";

  @Query(value = query, nativeQuery = true)
  List<GeoJsonEntity> getGeoJson();

  @Query(value = queryTodos, nativeQuery = true)
  List<GeoJsonEntity> findGeoJsonTodos(@Param("anio") String anio);

  List<GeoJsonEntity> findByAnioAndObligacionConMora(String anio, String mora);

}
