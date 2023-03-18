package br.unitins.service;

import java.util.List;
import br.unitins.dto.FornecedorDTO;
import br.unitins.dto.FornecedorResponseDTO;

public interface FornecedorService {

    // Recursos básicos.
    
    List<FornecedorResponseDTO> getAll();

    FornecedorResponseDTO findById(Long id);

    FornecedorResponseDTO create(FornecedorDTO fornecedorDTO);

    FornecedorResponseDTO update(Long id, FornecedorDTO cafeteriaDTO);

    void delete(Long id);

    // Recursos extras.

    List<FornecedorResponseDTO> findByNome(String salgado);

    long count();
}