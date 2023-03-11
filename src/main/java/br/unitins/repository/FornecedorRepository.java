package br.unitins.repository;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor> {

    public List<Fornecedor> findByNameList(String salgado){
        if (salgado == null)
            return null;
        return find("UPPER(salgado) LIKE ?1 ", "%" + salgado.toUpperCase() + "%").list();
    }
}