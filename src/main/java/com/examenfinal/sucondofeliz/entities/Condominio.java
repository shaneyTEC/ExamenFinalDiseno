package com.examenfinal.sucondofeliz.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Condominio {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombre;
    private String direccion;
    private int cedulaJuritica;
    private String representante;
    private int cantidadUnidades;
    private String estado;

    private String amenidades;
    private int cuotaCondominal;

    public Condominio() {
    }

    public Condominio(int id, String nombre, String direccion, int cedulaJuritica,
                      String representante, int cantidadUnidades, int cuotaCondominal,
                      String estado,
                      String amenidades) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedulaJuritica = cedulaJuritica;
        this.representante = representante;
        this.cantidadUnidades = cantidadUnidades;
        this.cuotaCondominal = cuotaCondominal;
        this.estado = "activo";
        this.amenidades = amenidades;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getCedulaJuritica() {
        return cedulaJuritica;
    }

    public void setCedulaJuritica(int cedulaJuritica) {
        this.cedulaJuritica = cedulaJuritica;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public int getCuotaCondominal() {
        return cuotaCondominal;
    }

    public void setCuotaCondominal(int cuotaCondominal) {
        this.cuotaCondominal = cuotaCondominal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado() {
        if(this.estado == "activo"){
            this.estado = "ex-condomino";
        } else {
            this.estado = "activo";
        }
    }

    public String getAmenidades() {
        return amenidades;
    }

    public void setAmenidades(String amenidades) {
        this.amenidades = amenidades;
    }
}
