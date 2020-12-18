package br.edu.cesmac.si.nolweb.repository;
import br.edu.cesmac.si.nolweb.domain.Produto;
import br.edu.cesmac.si.nolweb.domain.Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class ProdutoRepositoryJPA implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;
    public ProdutoRepositoryJPA () {}
    public ProdutoRepositoryJPA (EntityManager manager) {
        this.manager = manager ;
    }
    public void salvar(Produto produto) {
        manager.getTransaction().begin() ;
        manager.merge(produto) ;
        manager.getTransaction().commit() ;
    }
    public List<Produto> listarTodos () {
        CriteriaQuery<Produto> query = manager.getCriteriaBuilder().createQuery(Produto. class);
        query.select(query.from(Produto. class));
        List<Produto> lista = manager.createQuery(query).getResultList() ;
        return lista;
    }
    public void remover(Produto produto) {
        produto = manager.merge(produto) ;
        manager.getTransaction().begin() ;
        manager.remove(produto) ;
        manager.getTransaction().commit() ;
    }
}