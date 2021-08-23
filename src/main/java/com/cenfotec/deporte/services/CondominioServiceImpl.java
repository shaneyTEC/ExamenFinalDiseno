package com.cenfotec.deporte.services;

import com.cenfotec.deporte.entities.Condominio;
import com.cenfotec.deporte.repo.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondominioServiceImpl implements CondominioService {

    @Autowired
    CondominioRepository repo;

    @Override
    public void save(Condominio condominio) {
        repo.save(condominio);
    }

    @Override
    public Optional<Condominio> getCondominio(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Condominio> getAllCondominiosActivos() {
        return repo.findByEstado(true);
    }

    @Override
    public List<Condominio> getAllCondominiosInactivos() {
        return repo.findByEstado(false);
    }

    @Override
    public List<Condominio> getAll() {
        return repo.findAll();
    }

    @Override
    public void updateAmenidades(long id, String amenidades) {

    }

    @Override
    public void updateCondominioEstado(long id) {

    }

    @Override
    public Condominio createCondominio(String nombre, String direccion, String representante, String amenidades, int cedulaJuritica, int cantidadUnidades, int cuotaCondominal) {
        return null;
    }

    @Override
    public void updateCondominio(long id, String nombre, String direccion, String representante, String amenidades, int cedulaJuritica, int cantidadUnidades, int cuotaCondominal) {

    }
}
