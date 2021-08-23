package com.cenfotec.deporte.repo;

import com.cenfotec.deporte.entities.Amenidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmenidadRepository extends JpaRepository<Amenidad, Long> {
    public List<Amenidad> findByCondominio(long ID);
    public List<Amenidad> findById(long ID);
}
