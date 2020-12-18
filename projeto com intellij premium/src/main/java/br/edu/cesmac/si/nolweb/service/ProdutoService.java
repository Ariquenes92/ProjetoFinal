package br.edu.cesmac.si.nolweb.service;

import br.edu.cesmac.si.nolweb.domain.Produto;
import br.edu.cesmac.si.nolweb.repository.ProdutoRepositoryJPA;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProdutoService {
    @Inject
    ProdutoRepositoryJPA produtoRepositoryJPA;
    public List<Produto> listarTodos() {
        return this.produtoRepositoryJPA.listarTodos();
    }
    public void salvar(Produto produto) {
        this.produtoRepositoryJPA.salvar(produto);
    }
    public void remover(Produto produto) {
        this.produtoRepositoryJPA.remover(produto);
    }
}