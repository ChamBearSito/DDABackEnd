package com.ob.ob.services.Producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ob.ob.entity.Producto;
import com.ob.ob.repository.ProductoRepository;
import com.ob.ob.repository.VentaRepository;
import com.ob.ob.utils.AppException;

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
    public Producto save(Producto prod) throws AppException {
        try {

            return productoRepository.save(prod);
        } catch (Exception e) {
            throw new AppException("hubo un error al Ingresar el Producto");
        }
    }

    @Override
    @Transactional
    public Producto update(Producto prod) throws AppException {
        try {
            if (productoRepository.existsById(prod.getId())) {
                return productoRepository.save(prod);

            } else
                throw new AppException("Producto con ese Id no encontrado");
        } catch (Exception e) {
            throw new AppException("hubo un error al Encontrar el Producto");
        }
    }

    public boolean existsByProductoId(@PathVariable int productoId) {
        return ventaRepository.existsByProductoId(productoId);
    }

    @Override
    @Transactional
    public ResponseEntity<String> delete(int id) throws AppException {
        try {

            if (existsByProductoId(id)) {
                return new ResponseEntity<>("Existen datos en ventas de este producto, no es posible eliminar",
                        HttpStatus.METHOD_NOT_ALLOWED);
            } else {
                productoRepository.deleteById(id);
                return new ResponseEntity<>("Se ha eliminado correctamente", HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new AppException("hubo un error al eliminar el Producto");
        }
    }

    @Override
    @Transactional
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Producto> getAproduct(int id) throws AppException {
        try {
            if (productoRepository.existsById(id)) {

                return productoRepository.findById(id);
            } else
                throw new AppException("Producto con ese Id no encontrado");
        } catch (Exception e) {
            throw new AppException("hubo un error al Encontrar el Producto");
        }
    }

    @Override
    @Transactional
    public List<Producto> getProductsByStock(int cant) {
        return productoRepository.findByStock(cant);
    }
}
