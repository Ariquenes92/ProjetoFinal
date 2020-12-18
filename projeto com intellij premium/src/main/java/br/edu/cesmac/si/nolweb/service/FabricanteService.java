package br.edu.cesmac.si.nolweb.service;

import br.edu.cesmac.si.nolweb.domain.Fabricante;
import br.edu.cesmac.si.nolweb.repository.FabricanteRepositoryJPA;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FabricanteService {
    @Inject
    FabricanteRepositoryJPA fabricanteRepositoryJPA;
    public List<Fabricante> listarTodos() {
        return this.fabricanteRepositoryJPA.listarTodos();
    }
    public void salvar(Fabricante fabricante) {
        this.fabricanteRepositoryJPA.salvar(fabricante);
    }
    public void remover(Fabricante fabricante) {
        this.fabricanteRepositoryJPA.remover(fabricante);
    }
}