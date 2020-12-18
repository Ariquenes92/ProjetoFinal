package br.edu.cesmac.si.nolweb.controller;

import br.edu.cesmac.si.nolweb.domain.Lista;
import br.edu.cesmac.si.nolweb.service.ListaService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class ListaBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Lista lista;
    private List<Lista> listas;
    private boolean operacaoConsultar = false;
    private boolean operacaoCadastrar = false;
    private boolean operacaoAlterar = false;
    @Inject
    private ListaService listaService;
    public ListaBean() {
        this.lista = new Lista();
        listas = new ArrayList<>();
        inicializarOperacoes();
        operacaoConsultar = true;
    }
    public List<Lista> getListas() {
        if (this.listas == null || this.listas.size() == 0) {
            this.listas = this.listaService.listarTodos();
        }
        return this.listas;
    }
    public String salvar() {
        this.listaService.salvar(lista);
        return "consultar?faces-redirect=true";
    }
    public Lista getLista() {
        return lista;
    }
    public void setLista(Lista lista) {
        this.lista = lista;
    }
    public void setListas(List<Lista> listas) {
        this.listas = listas;
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
    public void preAlterar(Lista lista) {
        this.lista = lista;
        inicializarOperacoes();
        this.operacaoAlterar = true;
    }
    public void preCadastrar() {
        this.lista = new Lista();
        inicializarOperacoes();
        this.operacaoCadastrar = true;
    }
    public void remover(Lista lista) {
        this.listaService.remover(lista);
        this.listas = this.listaService.listarTodos();
        this.operacaoConsultar = true;
    }
    public void alterar() {
        this.listaService.salvar(this.lista);
        this.limparEntidade();
        inicializarOperacoes();
        this.listas = this.listaService.listarTodos();
        this.operacaoConsultar = true;
    }
    public void cadastrar() {
        this.listaService.salvar(this.lista);
        this.limparEntidade();
        inicializarOperacoes();
        this.operacaoConsultar = true;
    }
    public void limparEntidade() {
        this.lista = new Lista();
    }
}