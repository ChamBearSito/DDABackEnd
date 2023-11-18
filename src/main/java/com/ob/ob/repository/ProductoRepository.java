package com.ob.ob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ob.ob.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    @Query(value="SELECT * FROM producto p WHERE p.stock>:cant",nativeQuery = true) 
    List<Producto> findByStock(@Param("cant") int cant);
}
