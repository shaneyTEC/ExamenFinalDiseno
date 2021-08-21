package com.examenfinal.sucondofeliz.query;

import com.examenfinal.sucondofeliz.entities.Condominio;
import com.examenfinal.sucondofeliz.services.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CondominioQuery {
    @Autowired
    private CondominioService CondominioService;

    public List<Condominio> getCondominios(int count) {
        return this.CondominioService.getAllCondominios(count);
    }

    public Optional<Condominio> getCondominio(int id) {
        return this.CondominioService.getCondominio(id);
    }

    public List<Condominio> getAllCondominiosActivos(String estado, int count) {
        return this.CondominioService.getAllCondominiosActivos(estado, count);
    }

    public List<Condominio> getAllCondominiosInactivos(String estado, int count) {
        return this.CondominioService.getAllCondominiosInactivos(estado, count);
    }

    public List<Integer> getAllCondominiosCuota( int count) {
        return this.CondominioService.getAllCondominiosCuota(count);
    }

    //Dado un condominio (activo o inactivo) listar las amenidades. (5pts)

    public String getAmenidades(int id) {
        return this.CondominioService.getAmenidades(id);
    }
}
