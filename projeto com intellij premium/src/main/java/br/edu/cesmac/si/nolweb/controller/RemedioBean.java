package br.edu.cesmac.si.nolweb.controller;

import br.edu.cesmac.si.nolweb.domain.Remedio;
import br.edu.cesmac.si.nolweb.service.RemedioService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class RemedioBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Remedio remedio;
    private List<Remedio> remedios;
    private boolean operacaoConsultar = false;
    private boolean operacaoCadastrar = false;
    private boolean operacaoAlterar = false;
    @Inject
    private RemedioService remedioService;
    public RemedioBean() {
        this.remedio = new Remedio();
        remedios = new ArrayList<>();
        inicializarOperacoes();
        operacaoConsultar = true;
    }
    public List<Remedio> getRemedios() {
        if (this.remedios == null || this.remedios.size() == 0) {
            this.remedios = this.remedioService.listarTodos();
        }
        return this.remedios;
    }
    public String salvar() {
        this.remedioService.salvar(remedio);
        return "consultar?faces-redirect=true";
    }
    public Remedio getRemedio() {
        return remedio;
    }
    public void setRemedio(Remedio remedio) {
        this.remedio = remedio;
    }
    public void setRemedios(List<Remedio> remedios) {
        this.remedios = remedios;
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
    public void preAlterar(Remedio remedio) {
        this.remedio = remedio;
        inicializarOperacoes();
        this.operacaoAlterar = true;
    }
    public void preCadastrar() {
        this.remedio = new Remedio();
        inicializarOperacoes();
        this.operacaoCadastrar = true;
    }
    public void remover(Remedio remedio) {
        this.remedioService.remover(remedio);
        this.remedios = this.remedioService.listarTodos();
        this.operacaoConsultar = true;
    }
    public void alterar() {
        this.remedioService.salvar(this.remedio);
        this.limparEntidade();
        inicializarOperacoes();
        this.remedios = this.remedioService.listarTodos();
        this.operacaoConsultar = true;
    }
    public void cadastrar() {
        this.remedioService.salvar(this.remedio);
        this.limparEntidade();
        inicializarOperacoes();
        this.operacaoConsultar = true;
    }
    public void limparEntidade() {
        this.remedio = new Remedio();
    }
}