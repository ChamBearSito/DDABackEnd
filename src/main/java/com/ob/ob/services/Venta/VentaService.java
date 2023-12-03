package com.ob.ob.services.Venta;

import java.util.List;
import java.util.Optional;

import com.ob.ob.entity.Venta;
import com.ob.ob.utils.AppException;

public interface VentaService {
    public Venta save(Venta venta) throws AppException;

    public List<Venta> getAll();

    public Optional<Venta> getAventa(int id) throws AppException;

    public String delete(int id) throws AppException;

    public Venta update(Venta venta) throws AppException;
}
