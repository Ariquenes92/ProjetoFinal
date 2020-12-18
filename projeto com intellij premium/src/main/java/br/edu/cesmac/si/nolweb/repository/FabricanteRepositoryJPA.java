package br.edu.cesmac.si.nolweb.repository;

import br.edu.cesmac.si.nolweb.domain.Fabricante;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class FabricanteRepositoryJPA implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;
    public FabricanteRepositoryJPA () {}
    public FabricanteRepositoryJPA (EntityManager manager) {
        this.manager = manager ;
    }
    public void salvar(Fabricante fabricante) {
        manager.getTransaction().begin() ;
        manager.merge(fabricante) ;
        manager.getTransaction().commit() ;
    }
    public List<Fabricante> listarTodos () {
        CriteriaQuery<Fabricante> query = manager.getCriteriaBuilder().createQuery(Fabricante. class);
        query.select(query.from(Fabricante. class));
        List<Fabricante> lista = manager.createQuery(query).getResultList() ;
        return lista;
    }
    public void remover(Fabricante fabricante) {
        fabricante = manager.merge(fabricante) ;
        manager.getTransaction().begin() ;
        manager.remove(fabricante) ;
        manager.getTransaction().commit() ;
    }
}