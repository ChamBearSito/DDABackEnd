package com.ob.ob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ob.ob.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
