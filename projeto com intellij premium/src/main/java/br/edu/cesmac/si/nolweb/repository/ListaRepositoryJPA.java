package br.edu.cesmac.si.nolweb.repository;

import br.edu.cesmac.si.nolweb.domain.Lista;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class ListaRepositoryJPA implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;
    public ListaRepositoryJPA () {}
    public ListaRepositoryJPA (EntityManager manager) {
        this.manager = manager ;
    }
    public void salvar(Lista lista) {
        manager.getTransaction().begin() ;
        manager.merge(lista) ;
        manager.getTransaction().commit() ;
    }
    public List<Lista> listarTodos () {
        CriteriaQuery<Lista> query = manager.getCriteriaBuilder().createQuery(Lista. class);
        query.select(query.from(Lista. class));
        List<Lista> lista = manager.createQuery(query).getResultList() ;
        return lista;
    }
    public void remover(Lista lista) {
        lista = manager.merge(lista) ;
        manager.getTransaction().begin() ;
        manager.remove(lista) ;
        manager.getTransaction().commit() ;
    }
}