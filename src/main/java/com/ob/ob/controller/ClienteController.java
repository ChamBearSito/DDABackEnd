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

@RestController
@RequestMapping("/clients")
public class ClienteController {
    @Autowired
    private ClienteService cliService;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Regular cli) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cliService.save(cli));
    }

    @PostMapping("/vip")
    public ResponseEntity<?> guardarVIP(@RequestBody VIP cli) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cliService.saveVIP(cli));
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
    public ResponseEntity<?> traerUno(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(cliService.getAclient(id));
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Regular cli) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cliService.update(cli));
    }

    @PutMapping("/vip")
    public ResponseEntity<?> actualizar(@RequestBody VIP cli) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cliService.updateVIP(cli));
    }

    @DeleteMapping("/eliminarCliente")
    public ResponseEntity<?> eliminar(@RequestParam int id) {
        return ResponseEntity.status(HttpStatus.OK).body(cliService.delete(id));
    }
}
