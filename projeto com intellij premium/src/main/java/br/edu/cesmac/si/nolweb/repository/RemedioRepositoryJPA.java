package br.edu.cesmac.si.nolweb.repository;
import br.edu.cesmac.si.nolweb.domain.Remedio;
import br.edu.cesmac.si.nolweb.domain.Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class RemedioRepositoryJPA implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;
    public RemedioRepositoryJPA () {}
    public RemedioRepositoryJPA (EntityManager manager) {
        this.manager = manager ;
    }
    public void salvar(Remedio remedio) {
        manager.getTransaction().begin() ;
        manager.merge(remedio) ;
        manager.getTransaction().commit() ;
    }
    public List<Remedio> listarTodos () {
        CriteriaQuery<Remedio> query = manager.getCriteriaBuilder().createQuery(Remedio. class);
        query.select(query.from(Remedio. class));
        List<Remedio> lista = manager.createQuery(query).getResultList() ;
        return lista;
    }
    public void remover(Remedio remedio) {
        remedio = manager.merge(remedio) ;
        manager.getTransaction().begin() ;
        manager.remove(remedio) ;
        manager.getTransaction().commit() ;
    }
}