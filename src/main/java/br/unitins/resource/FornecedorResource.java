package br.unitins.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unitins.dto.FornecedorDTO;
import br.unitins.dto.FornecedorResponseDTO;
import br.unitins.service.FornecedorService;

@Path("/fornecedor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FornecedorResource {
    
    @Inject
    private FornecedorService fornecedorService;
    
    // Inserir.

    @POST
    @Transactional
    public Response insert(@Valid FornecedorDTO dto){
        FornecedorResponseDTO fornecedor = fornecedorService.create(dto);
        return Response.status(Status.CREATED).entity(fornecedor).build();

    }

    // Lista do fornecedor.

    @GET
    public List<FornecedorResponseDTO> getAll() {
        return fornecedorService.getAll();
    }


    // Buscar por salgado.

    @GET
    @Path("/search/{salgado}")
    public List<FornecedorResponseDTO> searchFornecedorNAME(@PathParam("salgado") String salgado){
        return fornecedorService.findByNome(salgado);
    }

    // Busca por ID.

    @GET
    @Path("/{id}")
    public FornecedorResponseDTO searchFornecedorID(@PathParam("id") Long id){
        return fornecedorService.findById(id);
    }

    // Atualizar.

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateFornecedor(@Valid @PathParam("id") Long id, FornecedorDTO dto){
        FornecedorResponseDTO fornecedor = fornecedorService.update(id, dto);
        return Response.status(Status.NO_CONTENT).entity(fornecedor).build();
    }

    // Deletar um objeto por ID.

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarFornecedor(@Valid @PathParam("id") Long id){
        fornecedorService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


    @GET
    @Path("Count")
    public long count() {
        return fornecedorService.count();
    }

}