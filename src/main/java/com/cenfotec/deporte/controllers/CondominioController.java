package com.cenfotec.deporte.controllers;

import com.cenfotec.deporte.entities.Condominio;
import com.cenfotec.deporte.services.AmenidadService;
import com.cenfotec.deporte.services.CondominioService;
import com.cenfotec.deporte.services.CuotaCondominalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
public class CondominioController {
    @Autowired
    CondominioService condominioService;

    @Autowired
    CuotaCondominalService cuotaCondominalService;

    @Autowired
    AmenidadService amenidadService;

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }

    // Insertar Condominio
    @RequestMapping(value = "/insertar",  method = RequestMethod.GET)
    public String insertarPage(Model model) {
        model.addAttribute(new Condominio());
        return "crearCondominio";
    }


    @RequestMapping(value = "/insertar",  method = RequestMethod.POST)
    public String insertarCondominio(Condominio condominio, BindingResult result, Model model) {
        //guardo al condominio
        condominioService.save(condominio);

        // Amenidades
        condominio.getamenidades().forEach(
               amenidadData ->{
                   amenidadData.setCondominio(condominio);
                   amenidadService.save(amenidadData);
               }
        );

        // Cuota Condominal
        condominio.getCuotaCondominal().forEach(
                cuotaCondominalData ->{
                    cuotaCondominalData.setCondominio(condominio);
                    cuotaCondominalService.save(cuotaCondominalData);
                }
        );
        return "index";
    }

    // Enlistar
    @RequestMapping(value = "/listarCondominioActivo",  method = RequestMethod.GET)
    public String listarCondominiosActivos(Model model) {
        model.addAttribute("condominios", condominioService.getAllCondominiosActivos());
        return "listarCondominioActivo";
    }

    @RequestMapping(value = "/listarCondominioInactivo",  method = RequestMethod.GET)
    public String listarCondominiosInactivos(Model model) {
        model.addAttribute("condominios", condominioService.getAllCondominiosInactivos());
        return "listarCondominioInactivo";
    }

    @RequestMapping(value = "/listarCondominio",  method = RequestMethod.GET)
    public String listarCondominios(Model model) {
        model.addAttribute("condominios", condominioService.getAll());
        return "listarCondominio";
    }

    @RequestMapping(value = "/listarCuotaCondominal",  method = RequestMethod.GET)
    public String listarCuotaCondominal(Model model) {
        model.addAttribute("cuotaCondominal", cuotaCondominalService.getAll());
        return "listarCuotaCondominal";
    }

    @RequestMapping(value = "/listarAmenidades",  method = RequestMethod.GET)
    public String listarAmenidad(Model model) {
        model.addAttribute("amenidades", amenidadService.getAllAmenidades());
        return "listarAmenidades";
    }

    @RequestMapping(value = "/verCondominio/{id}",  method = RequestMethod.GET)
    public String verCondominio(Model model, @PathVariable long id) {
        Optional<Condominio> temCondominio =  condominioService.getCondominio(id);
        if(temCondominio.isPresent()){
            model.addAttribute("condominio", temCondominio.get());
            return "verCondominio";
        }
        return "index";
    }

    @RequestMapping(value = "/editarCondominio/{id}", method = RequestMethod.GET)
    public String editar(Model model, @PathVariable long id) {

        Optional<Condominio> condominio = condominioService.getCondominio(id);
        if (condominio.isPresent() && condominio.get().getEstado() == true){
            model.addAttribute("condominio", condominio.get());
            return "editarCondominio";
        }
        return "index";
    }

    @RequestMapping(value = "/editarCondominio/{id}", method = RequestMethod.POST)
    public String guardarCambiosCondominio(Condominio condominio, BindingResult result, Model model, @PathVariable long id) {
        Optional<Condominio> a = condominioService.getCondominio(condominio.getId());

        if(a.get().getEstado() == true){
            condominio.setNombre(a.get().getNombre());
            condominio.setDireccion(a.get().getDireccion());
            condominio.setRepresentante(a.get().getRepresentante());
            condominio.setCedulaJuritica(a.get().getCedulaJuritica());
            condominio.setCantidadUnidades(a.get().getCantidadUnidades());
            condominio.setEstado(a.get().getEstado());

            setCondominioAmenidadesCuotaCondominal(condominio, a);
        }
        return "editarCondominio";
    }

    @RequestMapping(value = "/guardarEstado/{id}", method = RequestMethod.GET)
    public String guardarEstado(Model model, @PathVariable long id) {

        Optional<Condominio> condominio = condominioService.getCondominio(id);
        if (condominio.isPresent() && condominio.get().getEstado() == true){
            model.addAttribute("condominio", condominio.get());
            return "guardarEstado";
        }
        return "index";
    }

    @RequestMapping(value = "/guardarEstado/{id}", method = RequestMethod.POST)
    public String guardarEstado(Condominio condominio, BindingResult result, Model model, @PathVariable long id) {
        Optional<Condominio> a = condominioService.getCondominio(condominio.getId());

        if(a.get().getEstado() == true){
            condominio.setNombre(a.get().getNombre());
            condominio.setDireccion(a.get().getDireccion());
            condominio.setRepresentante(a.get().getRepresentante());
            condominio.setCedulaJuritica(a.get().getCedulaJuritica());
            condominio.setCantidadUnidades(a.get().getCantidadUnidades());
            condominio.setEstado(false);

            setCondominioAmenidadesCuotaCondominal(condominio, a);
        }
        return "guardarEstado";
    }

    private void setCondominioAmenidadesCuotaCondominal(Condominio condominio, Optional<Condominio> a) {
        if (a.get().getamenidades() != condominio.getamenidades()) {
            condominio.getamenidades().forEach(
                    amenidadData ->{
                        amenidadData.setCondominio(condominio);
                        amenidadService.save(amenidadData);
                    }
            );
        }

        if (a.get().getCuotaCondominal() != condominio.getCuotaCondominal()) {
            condominio.getCuotaCondominal().forEach(
                    cuotaCondominalData ->{
                        cuotaCondominalData.setCondominio(condominio);
                        cuotaCondominalService.save(cuotaCondominalData);
                    }
            );
        }

        condominioService.save(condominio);
    }

}
