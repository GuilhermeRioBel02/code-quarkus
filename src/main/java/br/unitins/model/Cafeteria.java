package br.unitins.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Cafeteria extends PanacheEntity {
    private String tipoBebida;
    private String tipoSalgado;
    private String tipoSobremesa;
    private String tipoOmelete;
    private String tipoPacoteCafe;

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