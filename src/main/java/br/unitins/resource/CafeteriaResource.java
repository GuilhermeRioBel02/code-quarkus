package br.unitins.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import br.unitins.model.Cafeteria;
import br.unitins.repository.CafeteriaRepository;



@Path("/cafeteria")
public class CafeteriaResource {
   
@Inject
private CafeteriaRepository repository;

    // Insere informações no Banco.

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Cafeteria coffeeAdd(Cafeteria cafeteria) {
        cafeteria.persist();
        return cafeteria;
    }
    
    // Busca todos os Objetos dentro de uma Lista.

    @GET
    @Path("/todas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cafeteria> getCoffee() {
        return Cafeteria.findAll().list();
    }

    // Atualizando parcialmente o Objeto.

    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Cafeteria updateParcial(@PathParam("id")Long id, Cafeteria cafeteria) {
        Cafeteria attCafeteria = Cafeteria.findById(id);
        attCafeteria.setTipoBebida(cafeteria.getTipoBebida());
        attCafeteria.setTipoSalgado(cafeteria.getTipoSalgado());
        return attCafeteria;
    }

    // Busca o id específico.

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cafeteria cafeteriaId(@PathParam("id")Long id) {
        return Cafeteria.findById(id);
     }

     // Deleta Objeto do id informado.

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
     public Cafeteria cafeteriaDel(@PathParam("id")Long id, Cafeteria cafeteria) {
        Cafeteria del = Cafeteria.findById(id);
        del.delete();
        return del;
     }

      // Conta todos os objetos.

    @GET
    @Path("/count")
    public long count(){
        return repository.count();
    }

    // Buscar por tipo de Bebida.
    
    @GET
    @Path("/search/{tipoBebida}")
    public Cafeteria search(@PathParam("tipoBebida") String tipoBebida){
        return repository.findByName(tipoBebida);
    }

    // DELETE por tipo de bebida.

    @DELETE
    @Path("/{tipoBebida}")
    @Transactional
    public Cafeteria delet(@PathParam("tipoBebida") String tipoBebida) {
        Cafeteria cafeteriaDel = repository.findByName(tipoBebida);
        repository.delete(cafeteriaDel);
        return cafeteriaDel;
    }

}