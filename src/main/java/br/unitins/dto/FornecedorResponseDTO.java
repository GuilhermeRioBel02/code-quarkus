package br.unitins.dto;

import java.util.HashMap;
import java.util.Map;

import br.unitins.model.Fornecedor;

public class FornecedorResponseDTO {
    
    private Long id;
    private String salgado;
    private Map<String, Object> cafeteria;

    public FornecedorResponseDTO(Fornecedor fornecedor) {
        this.id = fornecedor.getId();
        this.salgado = fornecedor.getSalgado();
        this.cafeteria = new HashMap<String, Object>();
        this.cafeteria.put("tipoSalgado", fornecedor.getCafeteria().getTipoSalgado());
        this.cafeteria.put("tipoPacoteCafe", fornecedor.getCafeteria().getTipoPacoteCafe());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalgado() {
        return salgado;
    }

    public void setSalgado(String salgado) {
        this.salgado = salgado;
    }

    public Map<String, Object> getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Map<String, Object> cafeteria) {
        this.cafeteria = cafeteria;
    }
 
}