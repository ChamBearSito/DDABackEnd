package com.ob.ob.services.Venta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.ob.entity.Venta;
import com.ob.ob.repository.VentaRepository;
import com.ob.ob.utils.AppException;

import jakarta.transaction.Transactional;

@Service
public class VentaSevImpl implements VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    @Transactional
    public Venta save(Venta vent) throws AppException {

        try {
            ventaRepository.save(vent);
            return vent;
        } catch (Exception e) {
            throw new AppException("hubo un error al realizar la Venta");
        }
    }

    @Override
    @Transactional
    public Venta update(Venta vent) throws AppException {
        try {
            if (ventaRepository.existsById(vent.getId())) {
                return ventaRepository.save(vent);

            } else
                throw new AppException("No existe Venta Con ese ID");

        } catch (Exception e) {
            throw new AppException("hubo un error al Modificar la Venta");
        }

    }

    @Override
    @Transactional
    public List<Venta> getAll() {
        return ventaRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Venta> getAventa(int id) throws AppException {
        try {
            if (ventaRepository.existsById(id)) {

                return ventaRepository.findById(id);
            } else
                throw new AppException("No existe Venta Con ese ID");

        } catch (Exception e) {
            throw new AppException("hubo un error al realizar la Venta");
        }

    }

    @Override
    @Transactional
    public String delete(int id) throws AppException {
        try {
            if (ventaRepository.existsById(id)) {

                ventaRepository.deleteById(id);
                return "Se ha eliminado!";
            } else {
                return "Venta con ese Id no fue encontrada";
            }
        } catch (Exception e) {
            throw new AppException("hubo un error al eliminar la Venta");
        }
    }
}
