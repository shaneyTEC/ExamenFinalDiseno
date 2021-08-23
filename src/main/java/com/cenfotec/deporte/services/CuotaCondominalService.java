package com.cenfotec.deporte.services;

import com.cenfotec.deporte.entities.CuotaCondominal;

import java.util.List;
import java.util.Optional;

public interface CuotaCondominalService {
    public void save(CuotaCondominal cuotaCondominal);
    public Optional<CuotaCondominal> get(Long id);
    public List<CuotaCondominal> getAll();
    public List<CuotaCondominal> findByCondominio(long ID);
    public List<CuotaCondominal> findById(long ID);
}
