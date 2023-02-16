package br.unitins.resource;

import br.unitins.model.Cafeteria;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/cafeteria")
public class CafeteriaResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Cafeteria coffeeAdd(Cafeteria cafeteria) {
        cafeteria.persist();
        return cafeteria;
    }
    @GET
    @Path("/todas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cafeteria> getCoffee() {
        return Cafeteria.findAll().list();
    } 
}

