package com.cenfotec.deporte.services;

import com.cenfotec.deporte.entities.CuotaCondominal;
import com.cenfotec.deporte.repo.CuotaCondominalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuotaCondominalServiceImpl implements CuotaCondominalService {

    @Autowired
    CuotaCondominalRepository repo;

    @Override
    public void save(CuotaCondominal cuotaCondominal) {
        repo.save(cuotaCondominal);
    }

    @Override
    public Optional<CuotaCondominal> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<CuotaCondominal> getAll() {
        return repo.findAll();
    }

    @Override
    public List<CuotaCondominal> findByCondominio(long ID) {
        return repo.findByCondominio(ID);
    }

    @Override
    public List<CuotaCondominal> findById(long ID) {
        return repo.findByCondominio(ID);
    }
}
