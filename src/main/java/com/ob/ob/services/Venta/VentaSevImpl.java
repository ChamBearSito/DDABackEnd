package com.ob.ob.services.Venta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.ob.entity.Venta;
import com.ob.ob.repository.VentaRepository;

import jakarta.transaction.Transactional;

@Service
public class VentaSevImpl implements VentaService{
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    @Transactional
    public Venta save(Venta vent){
        return ventaRepository.save(vent);
    }

    @Override
    @Transactional
    public List<Venta> getAll(){
        return ventaRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Venta> getAventa(int id){
        return ventaRepository.findById(id);
    }

    @Override
    @Transactional
    public String delete(int id){
        ventaRepository.deleteById(id);
        return "Se ha eliminado!";
    }
}
