package com.cenfotec.deporte.services;

import com.cenfotec.deporte.entities.Amenidad;
import com.cenfotec.deporte.repo.AmenidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmenidadServiceImpl implements AmenidadService {

    @Autowired
    AmenidadRepository repo;

    @Override
    public void save(Amenidad amenidad) {
        repo.save(amenidad);
    }

    @Override
    public Optional<Amenidad> getAmenidad(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Amenidad> getAllAmenidades() {
        return repo.findAll();
    }

    @Override
    public List<Amenidad> findByCondominio(long ID) {
        return null;
    }

    @Override
    public List<Amenidad> findById(long ID) {
        return null;
    }
}
