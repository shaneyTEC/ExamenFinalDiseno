package com.cenfotec.deporte.entities;

import javax.persistence.*;

@Entity
public class CuotaCondominal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int monto;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Condominio condominio;

    //constructor

    public CuotaCondominal() {
    }

    public CuotaCondominal(long id, int monto, Condominio condominio) {
        this.id = id;
        this.monto = monto;
        this.condominio = condominio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}
