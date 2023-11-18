package com.ob.ob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ob.ob.entity.Cliente;
import com.ob.ob.entity.Producto;
import com.ob.ob.entity.Regular;
import com.ob.ob.entity.VIP;
import com.ob.ob.entity.Venta;
import com.ob.ob.entity.Venta.ProductoVenta;
import com.ob.ob.services.Cliente.ClienteService;
import com.ob.ob.services.Producto.ProductoService;
import com.ob.ob.services.Venta.VentaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;
    @Autowired
    private ProductoService prodService;
    @Autowired
    private ClienteService clientService;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Venta venta) {
        Venta trueVenta=devolverStock("agregar",venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(trueVenta));
    }

    @GetMapping
    public ResponseEntity<?> traerTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(ventaService.getAll());
    }

    @DeleteMapping
    public ResponseEntity<?> eliminar(@RequestParam int id) {
        Optional<Venta> laVenta = ventaService.getAventa(id);
        Venta venta = laVenta.orElse(null);

        if (laVenta != null) {
            devolverStock("eliminar", venta);
        }

        return ResponseEntity.status(HttpStatus.OK).body(ventaService.delete(id));
    }

    private Venta devolverStock(String action, Venta venta){
        List<ProductoVenta> laLista=new ArrayList<>();
        for (ProductoVenta prod : venta.getLista()) {
            Producto product = prod.getProducto();
            product.setStock(action=="agregar"?product.getStock() - prod.getCantidad():product.getStock() + prod.getCantidad());
            prodService.update(product);
            if(action=="agregar"){
                prod.setProducto(product);
                laLista.add(prod);
            }
        }
        if(action=="agregar"){
            venta.setLista(laLista);
        }
        
        Cliente cli = venta.getCli();

        Optional<Regular> elCli = clientService.getAregular(cli.getId());
        Regular reg = elCli.orElse(null);
        if (reg != null) {
            reg.setContadorCompras(action=="agregar"?reg.getContadorCompras() + 1:reg.getContadorCompras() - 1);
            clientService.update(reg);
            if(action=="agregar"){
                venta.setCli(reg);
            }
        }

        Optional<VIP> theCLI = clientService.getAvip(cli.getId());
        VIP vip = theCLI.orElse(null);
        if (vip != null) {
            vip.setContadorCompras(action=="agregar"?vip.getContadorCompras() + 1:vip.getContadorCompras() - 1);
            clientService.updateVIP(vip);
            if(action=="agregar"){
                venta.setCli(vip);
            }
        }

        return venta;
    }
}
