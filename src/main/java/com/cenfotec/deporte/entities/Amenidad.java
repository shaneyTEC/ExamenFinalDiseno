package com.cenfotec.deporte.entities;

import javax.persistence.*;

@Entity
public class Amenidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String detalle;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Condominio condominio;

    //constructor

    public Amenidad() {
    }

    public Amenidad(long id, String detalle, Condominio condominio) {
        this.id = id;
        this.detalle = detalle;
        this.condominio = condominio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}
