package com.ob.ob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ob.ob.entity.Producto;
import com.ob.ob.services.Producto.ProductoService;
import com.ob.ob.utils.AppException;

@RestController
@RequestMapping("/products")
public class ProductoController {
    @Autowired
    private ProductoService prodService;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Producto prod) throws AppException {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(prodService.save(prod));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    @GetMapping
    public ResponseEntity<?> traerTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(prodService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerUno(@PathVariable int id) throws AppException {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(prodService.getAproduct(id));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    @GetMapping("/cant")
    public ResponseEntity<?> traerPorStock(@RequestParam int cant) {
        return ResponseEntity.status(HttpStatus.OK).body(prodService.getProductsByStock(cant));
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Producto prod) throws AppException {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(prodService.update(prod));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    @DeleteMapping("/eliminarProducto")
    public ResponseEntity<?> eliminar(@RequestParam int id) throws AppException {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(prodService.delete(id));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }
}
