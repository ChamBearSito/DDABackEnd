package com.ob.ob.services.Producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.ob.entity.Producto;
import com.ob.ob.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoSevImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional
    public Producto save(Producto prod){
        return productoRepository.save(prod);
    }

    @Override
    @Transactional
    public Producto update(Producto prod){
        return productoRepository.save(prod);
    }

    @Override
    @Transactional
    public String delete(int id){
        productoRepository.deleteById(id);
        return "Se ha eliminado correctamente";
    }

    @Override
    @Transactional
    public List<Producto> getAll(){
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Producto> getAproduct(int id){
        return productoRepository.findById(id);
    }
    @Override
    @Transactional
    public List<Producto> getProductsByStock(int cant){
        return productoRepository.findByStock(cant);
    }
}
