package br.edu.cesmac.si.nolweb.service;

import br.edu.cesmac.si.nolweb.domain.Remedio;
import br.edu.cesmac.si.nolweb.repository.RemedioRepositoryJPA;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class RemedioService {
    @Inject
    RemedioRepositoryJPA remedioRepositoryJPA;
    public List<Remedio> listarTodos() {
        return this.remedioRepositoryJPA.listarTodos();
    }
    public void salvar(Remedio remedio) {
        this.remedioRepositoryJPA.salvar(remedio);
    }
    public void remover(Remedio remedio) {
        this.remedioRepositoryJPA.remover(remedio);
    }
}