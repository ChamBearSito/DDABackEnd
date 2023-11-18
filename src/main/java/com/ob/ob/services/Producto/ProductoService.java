package com.ob.ob.services.Producto;

import java.util.List;
import java.util.Optional;

import com.ob.ob.entity.Producto;

public interface ProductoService {
    public Producto save(Producto user);
    public List<Producto> getAll();
    public Optional<Producto> getAproduct(int id);
    public List<Producto> getProductsByStock(int cant);
    public String delete(int id);
    public Producto update(Producto user);
}
