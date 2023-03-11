package br.unitins.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Cafeteria extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoBebida;
    private String tipoSalgado;
    private String tipoSobremesa;
    private String tipoOmelete;
    private String tipoPacoteCafe;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTipoBebida() {
        return tipoBebida;
    }
    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public String getTipoSalgado() {
        return tipoSalgado;
    }

    public void setTipoSalgado(String tipoSalgado) {
        this.tipoSalgado = tipoSalgado;
    }

    public String getTipoSobremesa() {
        return tipoSobremesa;
    }

    public void setTipoSobremesa(String tipoSobremesa) {
        this.tipoSobremesa = tipoSobremesa;
    }

    public String getTipoOmelete() {
        return tipoOmelete;
    }

    public void setTipoOmelete(String tipoOmelete) {
        this.tipoOmelete = tipoOmelete;
    }

    public String getTipoPacoteCafe() {
        return tipoPacoteCafe;
    }

    public void setTipoPacoteCafe(String tipoPacoteCafe) {
        this.tipoPacoteCafe = tipoPacoteCafe;
    }

}