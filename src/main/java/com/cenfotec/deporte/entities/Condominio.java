package com.cenfotec.deporte.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //atributos
    private String nombre;
    private String direccion;
    private String representante;
    private Boolean estado;
    private int cantidadUnidades;
    private int cedulaJuritica;

    //constructor
    public Condominio() {
    }

    public Condominio(long id, String nombre, String direccion, String representante, int cantidadUnidades, int cedulaJuritica) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.representante = representante;
        this.cantidadUnidades = cantidadUnidades;
        this.cedulaJuritica = cedulaJuritica;
        this.estado = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public int getCedulaJuritica() {
        return cedulaJuritica;
    }

    public void setCedulaJuritica(int cedulaJuritica) {
        this.cedulaJuritica = cedulaJuritica;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "condominio")
    private Set<Amenidad> amenidades;

    public Set<Amenidad> getamenidades() {
        return amenidades;
    }

    public void setamenidades(Amenidad amenidad) {
        this.amenidades.add(amenidad);
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "condominio")
    private Set<CuotaCondominal> cuotaCondominal;

    public Set<CuotaCondominal> getCuotaCondominal() {
        return cuotaCondominal;
    }

    public void setcuotaCondominal(CuotaCondominal cuotaCondominal) {
        this.cuotaCondominal.add(cuotaCondominal);
    }


}
