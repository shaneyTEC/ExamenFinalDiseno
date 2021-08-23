package com.cenfotec.deporte.repo;

import com.cenfotec.deporte.entities.CuotaCondominal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuotaCondominalRepository extends JpaRepository<CuotaCondominal, Long> {
    public List<CuotaCondominal> findByCondominio(long ID);
    public List<CuotaCondominal> findById(long ID);
}
