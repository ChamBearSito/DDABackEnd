package com.ob.ob.services.Venta;

import java.util.List;
import java.util.Optional;

import com.ob.ob.entity.Venta;

public interface VentaService {
    public Venta save(Venta venta);

    public List<Venta> getAll();

    public Optional<Venta> getAventa(int id);

    public String delete(int id);
    // public Venta update(Venta venta);
}
