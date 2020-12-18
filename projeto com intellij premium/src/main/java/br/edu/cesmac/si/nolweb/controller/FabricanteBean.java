package br.edu.cesmac.si.nolweb.controller;

import br.edu.cesmac.si.nolweb.domain.Fabricante;
import br.edu.cesmac.si.nolweb.service.FabricanteService;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class FabricanteBean implements Serializable {
    private List<SelectItem> items;
    private static final long serialVersionUID = 1L;
    private Fabricante fabricante;
    private List<Fabricante> fabricantes;
    private boolean operacaoConsultar = false;
    private boolean operacaoCadastrar = false;
    private boolean operacaoAlterar = false;
    @Inject
    private FabricanteService fabricanteService;
    public FabricanteBean() {
        this.fabricante = new Fabricante();
        fabricantes = new ArrayList<>();
        inicializarOperacoes();
        operacaoConsultar = true;
    }

    public List<Fabricante> getFabricantes() {
        if (this.fabricantes == null || this.fabricantes.size() == 0) {
            this.fabricantes = this.fabricanteService.listarTodos();
        }
        return this.fabricantes;
    }

    public String salvar() {
        this.fabricanteService.salvar(fabricante);
        return "consultar?faces-redirect=true";
    }
    public Fabricante getFabricante() {
        return fabricante;
    }
    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }
    public boolean isOperacaoConsultar() {
        return operacaoConsultar;
    }
    public void setOperacaoConsultar(boolean operacaoConsultar) {
        inicializarOperacoes();
        this.operacaoConsultar = operacaoConsultar;
    }
    public boolean isOperacaoCadastrar() {
        return operacaoCadastrar;
    }
    public void setOperacaoCadastrar(boolean operacaoCadastrar) {
        inicializarOperacoes();
        this.operacaoCadastrar = operacaoCadastrar;
    }
    public boolean isOperacaoAlterar() {
        return operacaoAlterar;
    }
    public void setOperacaoAlterar(boolean operacaoAlterar) {
        inicializarOperacoes();
        this.operacaoAlterar = operacaoAlterar;
    }
    /**
     * Demais métodos
     */
    private void inicializarOperacoes() {
        this.operacaoConsultar = false;
        this.operacaoCadastrar = false;
        this.operacaoAlterar = false;
    }
    public void preAlterar(Fabricante fabricante) {
        this.fabricante = fabricante;
        inicializarOperacoes();
        this.operacaoAlterar = true;
    }
    public void preCadastrar() {
        this.fabricante = new Fabricante();
        inicializarOperacoes();
        this.operacaoCadastrar = true;
    }
    public void remover(Fabricante fabricante) {
        this.fabricanteService.remover(fabricante);
        this.fabricantes = this.fabricanteService.listarTodos();
        this.operacaoConsultar = true;
    }
    public void alterar() {
        this.fabricanteService.salvar(this.fabricante);
        this.limparEntidade();
        inicializarOperacoes();
        this.fabricantes = this.fabricanteService.listarTodos();
        this.operacaoConsultar = true;
    }
    public void cadastrar() {
        this.fabricanteService.salvar(this.fabricante);
        this.limparEntidade();
        inicializarOperacoes();
        this.operacaoConsultar = true;
    }
    public void limparEntidade() {
        this.fabricante = new Fabricante();
    }
}