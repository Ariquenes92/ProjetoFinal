package br.edu.cesmac.si.nolweb.service;


import br.edu.cesmac.si.nolweb.domain.Lista;
import br.edu.cesmac.si.nolweb.repository.ListaRepositoryJPA;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ListaService {
    @Inject
    ListaRepositoryJPA listaRepositoryJPA;
    public List<Lista> listarTodos() {
        return this.listaRepositoryJPA.listarTodos();
    }
    public void salvar(Lista lista) {
        this.listaRepositoryJPA.salvar(lista);
    }
    public void remover(Lista lista) {
        this.listaRepositoryJPA.remover(lista);
    }
}