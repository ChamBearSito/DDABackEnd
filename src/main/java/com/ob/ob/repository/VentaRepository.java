package com.ob.ob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ob.ob.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

    @Query("SELECT COUNT(pv) > 0 FROM Venta v JOIN v.lista pv WHERE pv.producto.id = :productoId")
    boolean existsByProductoId(@Param("productoId") int productoId);
}
