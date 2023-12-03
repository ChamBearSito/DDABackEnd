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

import com.ob.ob.entity.Regular;
import com.ob.ob.entity.VIP;
import com.ob.ob.services.Cliente.ClienteService;
import com.ob.ob.utils.AppException;

@RestController
@RequestMapping("/clients")
public class ClienteController {
    @Autowired
    private ClienteService cliService;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Regular cli) {
        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(cliService.save(cli));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    @PostMapping("/vip")
    public ResponseEntity<?> guardarVIP(@RequestBody VIP cli) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cliService.saveVIP(cli));

        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    @GetMapping
    public ResponseEntity<?> traerTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(cliService.getAll());
    }

    @GetMapping("/vip")
    public ResponseEntity<?> traerTodosVIP() {
        return ResponseEntity.status(HttpStatus.OK).body(cliService.getAllVIP());
    }

    @GetMapping("/regular")
    public ResponseEntity<?> traerTodosRegular() {
        return ResponseEntity.status(HttpStatus.OK).body(cliService.getAllRegular());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerUno(@PathVariable int id) throws AppException {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(cliService.getAclient(id));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Regular cli) throws AppException {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(cliService.update(cli));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }

    @PutMapping("/vip")
    public ResponseEntity<?> actualizar(@RequestBody VIP cli) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cliService.updateVIP(cli));

        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }

    }

    @DeleteMapping("/eliminarCliente")
    public ResponseEntity<?> eliminar(@RequestParam int id) {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(cliService.delete(id));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del sistema.");
        }
    }
}
