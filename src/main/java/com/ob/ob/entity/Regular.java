package com.ob.ob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Regular")
@PrimaryKeyJoinColumn(name="idCliente")
public class Regular extends Cliente {
    public Regular(int id, String nombre, String direccion, String telefono) {
        super(id,nombre,direccion,telefono);
    }

    public Regular() {
    }
}
