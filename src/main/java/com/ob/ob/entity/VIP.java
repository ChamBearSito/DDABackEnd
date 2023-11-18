package com.ob.ob.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="VIP")
@PrimaryKeyJoinColumn(name="idCliente")
public class VIP extends Cliente{
    @Column
    private String fechaMembresia;

    //region GETS AND SETS
    public String getFechaMembresia() {
        return this.fechaMembresia;
    }

    public void setFechaMembresia(String fechaMembresia) {
        this.fechaMembresia = fechaMembresia;
    }
    //endregion GETS AND SETS

    public VIP(String fechaMembresia) {
        this.fechaMembresia = fechaMembresia;
    }

    public VIP() {
    }
}
