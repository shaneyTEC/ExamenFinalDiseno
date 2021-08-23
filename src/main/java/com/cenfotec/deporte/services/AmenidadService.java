package com.cenfotec.deporte.services;

import com.cenfotec.deporte.entities.Amenidad;

import java.util.List;
import java.util.Optional;

public interface AmenidadService {
    public void save(Amenidad amenidades);
    public Optional<Amenidad> getAmenidad(Long id);
    public List<Amenidad> getAllAmenidades();
    public List<Amenidad> findByCondominio(long ID);
    public List<Amenidad> findById(long ID);
}
