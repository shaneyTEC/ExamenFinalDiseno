package com.cenfotec.deporte.repo;

import com.cenfotec.deporte.entities.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CondominioRepository extends JpaRepository<Condominio, Long> {
    public List<Condominio> findByIdContaining(Long id);
    public List<Condominio> findByEstado(Boolean estado);
}
