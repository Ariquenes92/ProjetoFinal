package br.edu.cesmac.si.nolweb.service;
import br.edu.cesmac.si.nolweb.domain.Usuario;
import br.edu.cesmac.si.nolweb.repository.UsuarioRepositoryJPA;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UsuarioService {
    @Inject
    UsuarioRepositoryJPA usuarioRepositoryJPA;
    public List<Usuario> listarTodos() {
        return this.usuarioRepositoryJPA.listarTodos();
    }
    public void salvar(Usuario usuario) {
        this.usuarioRepositoryJPA.salvar(usuario);
    }
    public void remover(Usuario usuario) {
        this.usuarioRepositoryJPA.remover(usuario);
    }
}