package br.edu.cesmac.si.nolweb.repository;
import br.edu.cesmac.si.nolweb.domain.Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class UsuarioRepositoryJPA implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;
    public UsuarioRepositoryJPA () {}
    public UsuarioRepositoryJPA (EntityManager manager) {
        this.manager = manager ;
    }
    public void salvar(Usuario usuario) {
        manager.getTransaction().begin() ;
        manager.merge(usuario) ;
        manager.getTransaction().commit() ;
    }
    public List<Usuario> listarTodos () {
        CriteriaQuery<Usuario> query = manager.getCriteriaBuilder().createQuery(Usuario. class);
        query.select(query.from(Usuario. class));
        List<Usuario> lista = manager.createQuery(query).getResultList() ;
        return lista;
    }
    public void remover(Usuario usuario) {
        usuario = manager.merge(usuario) ;
        manager.getTransaction().begin() ;
        manager.remove(usuario) ;
        manager.getTransaction().commit() ;
    }
}