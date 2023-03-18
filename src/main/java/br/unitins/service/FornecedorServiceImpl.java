package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.unitins.dto.FornecedorDTO;
import br.unitins.dto.FornecedorResponseDTO;
import br.unitins.model.Fornecedor;
import br.unitins.repository.FornecedorRepository;
import br.unitins.repository.CafeteriaRepository;

@ApplicationScoped
public class FornecedorServiceImpl implements FornecedorService {

    @Inject
    FornecedorRepository fornecedorRepository;

    @Inject
    CafeteriaRepository cafeteriaRepository;

    @Inject
    Validator validator;

    @Override
    public List<FornecedorResponseDTO> getAll() {
        List<Fornecedor> list = fornecedorRepository.listAll();
        return list.stream().map(FornecedorResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public FornecedorResponseDTO findById(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);
        if(fornecedor == null)
            throw new NotFoundException("Cafeteria não encontrada.");
        return new FornecedorResponseDTO(fornecedor);
    }

    @Override
    @Transactional
    public FornecedorResponseDTO create(FornecedorDTO fornecedorDTO) {
        Set<ConstraintViolation<FornecedorDTO>> violations = validator.validate(fornecedorDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setSalgado(fornecedorDTO.getSalgado());
        fornecedor.setPacoteCafe(fornecedorDTO.getPacoteCafe());
        fornecedor.setCafeteria(cafeteriaRepository.findById(fornecedorDTO.getIdCafeteria()));
        fornecedorRepository.persist(fornecedor);

        return new FornecedorResponseDTO(fornecedor);
    }

    @Override
    @Transactional
    public FornecedorResponseDTO update(Long id, FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);

        fornecedor.setSalgado(fornecedorDTO.getSalgado());
        fornecedor.setSalgado(fornecedorDTO.getPacoteCafe());
        fornecedor.setCafeteria(cafeteriaRepository.findById(fornecedorDTO.getIdCafeteria()));

        return new FornecedorResponseDTO(fornecedor);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }

    @Override
    public List<FornecedorResponseDTO> findByNome(String salgado) {
        List<Fornecedor> list = fornecedorRepository.findByNameList(salgado);
        return list.stream().map(FornecedorResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return fornecedorRepository.count();
    }
    
}