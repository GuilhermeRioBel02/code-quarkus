package br.unitins.dto;


public class FornecedorDTO {
    
    private String salgado;
    private String pacoteCafe;
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