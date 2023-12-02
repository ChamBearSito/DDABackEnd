package com.ob.ob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ob.ob.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("SELECT COUNT(v) > 0 FROM Venta v WHERE v.cli.id = :clienteId")
    boolean existsByClienteId(@Param("clienteId") int clienteId);
}
