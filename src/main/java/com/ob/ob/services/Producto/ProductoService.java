package com.ob.ob.services.Producto;

import java.util.List;
import java.util.Optional;

import com.ob.ob.entity.Producto;
import com.ob.ob.utils.AppException;

import org.springframework.http.ResponseEntity;

public interface ProductoService {
    public Producto save(Producto user) throws AppException;

    public List<Producto> getAll();

    public Optional<Producto> getAproduct(int id) throws AppException;

    public List<Producto> getProductsByStock(int cant);

    public ResponseEntity<String> delete(int id) throws AppException;

    public Producto update(Producto user) throws AppException;
}
