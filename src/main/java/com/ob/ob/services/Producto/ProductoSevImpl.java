package com.ob.ob.services.Producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ob.ob.entity.Producto;
import com.ob.ob.repository.ProductoRepository;
import com.ob.ob.repository.VentaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.transaction.Transactional;

@Service
public class ProductoSevImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    @Transactional
    public Producto save(Producto prod) {
        return productoRepository.save(prod);
    }

    @Override
    @Transactional
    public Producto update(Producto prod) {
        return productoRepository.save(prod);
    }

    public boolean existsByProductoId(@PathVariable int productoId) {
        return ventaRepository.existsByProductoId(productoId);
    }

    @Override
    @Transactional
    public ResponseEntity<String> delete(int id) {
        if (existsByProductoId(id)) {
            return new ResponseEntity<>("Existen datos en ventas de este producto, no es posible eliminar",
                    HttpStatus.METHOD_NOT_ALLOWED);
        } else {
            productoRepository.deleteById(id);
            return new ResponseEntity<>("Se ha eliminado correctamente", HttpStatus.OK);
        }
    }

    @Override
    @Transactional
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Producto> getAproduct(int id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Producto> getProductsByStock(int cant) {
        return productoRepository.findByStock(cant);
    }
}
