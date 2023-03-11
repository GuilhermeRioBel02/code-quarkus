package br.unitins.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.dto.FornecedorDTO;
import br.unitins.dto.FornecedorResponseDTO;
import br.unitins.model.Fornecedor;
import br.unitins.repository.FornecedorRepository;
import br.unitins.repository.CafeteriaRepository;

@Path("/fornecedor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FornecedorResource {
    
    @Inject
    private FornecedorRepository fornecedorRepository;
    
    @Inject
    private CafeteriaRepository CafeteriaRepository;

    //Insere
    @POST
    @Transactional
    public FornecedorResponseDTO insert(FornecedorDTO dto){
        Fornecedor entity = new Fornecedor();
        entity.setSalgado(dto.getSalgado());
        entity.setPacoteCafe(dto.getPacoteCafe());
        entity.setCafeteria(CafeteriaRepository.findById(dto.getIdCafeteria()));

        fornecedorRepository.persist(entity);
        
        return new FornecedorResponseDTO(entity);

    }

    //Lista de carros
    @GET
    public List<FornecedorResponseDTO> getAll() {
    
        return fornecedorRepository.findAll()
        .stream()
        .map(fornecedor -> new FornecedorResponseDTO(fornecedor))
        .collect(Collectors.toList());
    }


    //Buscar por nome
    @GET
    @Path("/search/{modelo}")
    public List<Fornecedor> searchFornecedorNAME(@PathParam("salgado") String salgado){
        return fornecedorRepository.findByNameList(salgado);
    }

    //Busca por ID
    @GET
    @Path("/{id}")
    public Fornecedor searchFornecedorId(@PathParam("id") Long id){
        return fornecedorRepository.findById(id);
    }

    //Atualiza
    @PUT
    @Path("/{id}")
    @Transactional
    public Fornecedor updateFornecedor(@PathParam("id") Long id, FornecedorDTO fornecedor){
        Fornecedor entity = fornecedorRepository.findById(id);
        entity.setPacoteCafe(fornecedor.getPacoteCafe());
        return entity;
    }

    //Deletar um obj por ID
    @DELETE
    @Path("/{id}")
    @Transactional
    public Fornecedor deletarFornecedor(@PathParam("id") Long id){
        Fornecedor entity = fornecedorRepository.findById(id);
        fornecedorRepository.delete(entity);
        return entity;
    }

}