package com.examenfinal.sucondofeliz.services;

import com.examenfinal.sucondofeliz.entities.Condominio;
import com.examenfinal.sucondofeliz.repositories.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.tags.EditorAwareTag;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class CondominioService {
    @Autowired
    CondominioRepository CondominioRepo;

    /*Registro de condominio: nombre, dirección, cedula juritica de la asociación, representante de los
    condóminos, cantidad de unidades y cuota condominal. (5pts)*/
    public Condominio createCondominio(
            String nombre,
            String direccion,
            String representante,
            String amenidades,
            int cedulaJuritica,
            int cantidadUnidades,
            int cuotaCondominal) {

        Condominio Condominio = new Condominio();
        Condominio.setNombre(nombre);
        Condominio.setDireccion(direccion);
        Condominio.setRepresentante(representante);
        Condominio.setAmenidades(amenidades);
        Condominio.setCedulaJuritica(cedulaJuritica);
        Condominio.setCantidadUnidades(cantidadUnidades);
        Condominio.setCuotaCondominal(cuotaCondominal);
        return this.CondominioRepo.save(Condominio);

    }

    /*Listar Condominios (10 pts)
    o El listado de condominios debe permitir ver todos o solo los activos o solo los inactivos*/
    public List<Condominio> getAllCondominiosActivos(String estado, int count) {

        return this.CondominioRepo.findAll().stream().filter(
                c -> c.getEstado() == "activo"
        ).limit(count).collect(
                Collectors.toList());
    }

    public List<Condominio> getAllCondominiosInactivos(String estado, int count) {
        return this.CondominioRepo.findAll().stream().filter(
                c -> c.getEstado() == "ex-condomino"
        ).limit(count).collect(
                Collectors.toList());
    }
    public List<Condominio> getAllCondominios(int count) {
        return this.CondominioRepo.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<Condominio> getCondominio(int id) {
        return this.CondominioRepo.findById(id);
    }

    /*Modificar datos de condominio (solo los activos) (10 pts)
    o Debe conservarse un registro histórico de la cuota condominal*/

    public void updateCondominio(Condominio condominio) {
        Optional<Condominio> condo = getCondominio(condominio.getId());
        if(condo.get().getEstado() != "ex-condomino"){
            condominio.setNombre(condo.get().getNombre());
            condominio.setDireccion(condo.get().getDireccion());
            condominio.setRepresentante(condo.get().getRepresentante());
            condominio.setCedulaJuritica(condo.get().getCedulaJuritica());
            condominio.setCantidadUnidades(condo.get().getCantidadUnidades());
            CondominioRepo.save(condominio);
        }
    }

    /*Desactivar un condominio (es decir, guardar los datos de un condominio pero ya no se podrá
    hacer operaciones sobre él pues no está activo). (5pts)*/

    public void updateCondominioEstado(int id) {
        Condominio condo = getCondominio(id).get();
        condo.setEstado();
        CondominioRepo.save(condo);
    }

    /*Registrar amenidades de un condominio (5pts)*/
    public void updateAmenidades(Condominio condominio) {
        Optional<Condominio> condo = getCondominio(condominio.getId());
        if(condo.get().getEstado() != "ex-condomino"){
            condominio.setAmenidades(condo.get().getAmenidades());
            CondominioRepo.save(condominio);
        }
    }

    //Listar los históricos de la cuota condominal. (10 pts)
    public List<Integer> getAllCondominiosCuota( int count) {
        return this.CondominioRepo.findAll().stream().limit(count).map(
                condominio -> condominio.getCuotaCondominal()
        ).collect(Collectors.toList());
    }

    //Dado un condominio (activo o inactivo) listar las amenidades. (5pts)

    public String getAmenidades(int id) {
        return this.CondominioRepo.findById(id).get().getAmenidades();
    }
}
