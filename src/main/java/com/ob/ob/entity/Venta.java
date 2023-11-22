package com.ob.ob.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_venta_id")
    private List<Venta.ProductoVenta> lista;

    @Entity
    @Table(name = "ProductoVenta")
    public static class ProductoVenta {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "producto_id")
        private Producto producto;

        @Column(nullable = false)
        private int cantidad;

        // region GETTERS Y SETTERS

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
        // endregion

        public ProductoVenta(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }

        public ProductoVenta() {
        }
    }

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false)
    private double total; // Nuevo campo

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cli;

    // region GETS AND SETS
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Venta.ProductoVenta> getLista() {
        return this.lista;
    }

    public void setLista(List<Venta.ProductoVenta> lista) {
        this.lista = lista;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCli() {
        return this.cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }
    // endregion

    public Venta(List<Venta.ProductoVenta> lista, String fecha, Cliente cli, double total) {
        this.lista = lista;
        this.fecha = fecha;
        this.cli = cli;
        this.total = total;
    }

    public Venta() {
        // lista=new List<>();
    }

}
