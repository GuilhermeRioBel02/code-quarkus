package br.unitins.repository;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Cafeteria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CafeteriaRepository implements PanacheRepository<Cafeteria> {

    public Cafeteria findByName(String tipoBebida) {

        return find("tipoBebida", tipoBebida ).firstResult();
    }

    public List<Cafeteria> findByNameList(String tipoBebida) {

        return find("tipoBebida LIKE ?1", "%" + tipoBebida + "%").list();
    }
}