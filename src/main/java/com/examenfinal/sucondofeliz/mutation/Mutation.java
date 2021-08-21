package com.examenfinal.sucondofeliz.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.examenfinal.sucondofeliz.entities.Condominio;
import com.examenfinal.sucondofeliz.services.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private CondominioService CondominioService;

    public Condominio createCondominio(String nombre,
                                       String direccion,
                                       String representante,
                                       String amenidades,
                                       int cedulaJuritica,
                                       int cantidadUnidades,
                                       int cuotaCondominal) {
        return this.CondominioService.createCondominio(
                nombre,
                direccion,
                representante,
                amenidades,
                cedulaJuritica,
                cantidadUnidades,
                cuotaCondominal);
    }

    public void updateCondominio(Condominio condominio) {
       this.CondominioService.updateCondominio(condominio);
    }

    public void updateAmenidades(Condominio condominio) {
        this.CondominioService.updateAmenidades(condominio);
    }
}
