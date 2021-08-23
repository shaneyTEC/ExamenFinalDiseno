package com.cenfotec.deporte.services;

import com.cenfotec.deporte.entities.Condominio;

import java.util.List;
import java.util.Optional;

public interface CondominioService {
    public void save(Condominio condominio);
    public Optional<Condominio> getCondominio(Long id);
    public List<Condominio> getAllCondominiosActivos();
    public List<Condominio> getAllCondominiosInactivos();
    public List<Condominio> getAll();
    public void updateAmenidades(long id, String amenidades);
    public void updateCondominioEstado(long id);
    public Condominio createCondominio(String nombre,
                                       String direccion,
                                       String representante,
                                       String amenidades,
                                       int cedulaJuritica,
                                       int cantidadUnidades,
                                       int cuotaCondominal);
    public void updateCondominio(
            long id,
            String nombre,
            String direccion,
            String representante,
            String amenidades,
            int cedulaJuritica,
            int cantidadUnidades,
            int cuotaCondominal);
}
