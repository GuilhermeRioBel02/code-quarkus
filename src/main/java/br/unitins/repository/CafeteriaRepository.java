package br.unitins.repository;


import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Cafeteria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CafeteriaRepository implements PanacheRepository<Cafeteria> {

    public Cafeteria findByName(String tipoBebida) {
        if (tipoBebida == null)
            return null;
        return find("UPPER(tipoBebida) LIKE ?1", "%" + tipoBebida.toUpperCase() + "%").firstResult();    
    }
}
