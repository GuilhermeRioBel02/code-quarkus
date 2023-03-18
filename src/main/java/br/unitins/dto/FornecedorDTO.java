package br.unitins.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FornecedorDTO {

    @NotBlank(message = "O campo salgado deve ser informado.")
    private String salgado;
    
    @NotEmpty(message = "O campo pacoteCafe deve ser informado.")
    private String pacoteCafe;
    
    @NotNull(message = "O campo idCafeteria deve ser informado.")
    private Long idCafeteria;
    
    
    public String getSalgado() {
        return salgado;
    }
    
    public void setSalgado(String salgado) {
        this.salgado = salgado;
    }
    
    public String getPacoteCafe() {
        return pacoteCafe;
    }
    
    public void setPacoteCafe(String pacoteCafe) {
        this.pacoteCafe = pacoteCafe;
    }

    public Long getIdCafeteria() {
        return idCafeteria;
    }

    public void setIdcafeteria(Long idCafeteria) {
        this.idCafeteria = idCafeteria;
    }

}