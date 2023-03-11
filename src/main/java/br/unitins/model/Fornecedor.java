package br.unitins.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String salgado;
    private int quantidadeSalgado;
    private int quantidadeOvo;
    private String pacoteCafe;

    @ManyToOne
    @JoinColumn(name = "id_cafeteria")
    private Cafeteria cafeteria;

    
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

    public int getQuantidadeSalgado() {
        return quantidadeSalgado;
    }

    public void setQuantidadeSalgado(int quantidadeSalgado) {
        this.quantidadeSalgado = quantidadeSalgado;
    }

    public int getQuantidadeOvo() {
        return quantidadeOvo;
    }

    public void setQuantidadeOvo(int quantidadeOvo) {
        this.quantidadeOvo = quantidadeOvo;
    }

    public String getPacoteCafe() {
        return pacoteCafe;
    }

    public void setPacoteCafe(String pacoteCafe) {
        this.pacoteCafe = pacoteCafe;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

}
    


