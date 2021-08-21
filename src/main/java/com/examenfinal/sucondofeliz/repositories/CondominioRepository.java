package com.examenfinal.sucondofeliz.repositories;

import com.examenfinal.sucondofeliz.entities.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Integer> {
    public List<Condominio> findByidContaining(int id);
}
