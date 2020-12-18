package br.edu.cesmac.si.nolweb.controller;

import br.edu.cesmac.si.nolweb.domain.Produto;
import br.edu.cesmac.si.nolweb.service.ProdutoService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class ProdutoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Produto produto;
    private List<Produto> produtos;
    private boolean operacaoConsultar = false;
    private boolean operacaoCadastrar = false;
    private boolean operacaoAlterar = false;
    @Inject
    private ProdutoService produtoService;
    public ProdutoBean() {
        this.produto = new Produto();
        produtos = new ArrayList<>();
        inicializarOperacoes();
        operacaoConsultar = true;
    }
    public List<Produto> getProdutos() {
        if (this.produtos == null || this.produtos.size() == 0) {
            this.produtos = this.produtoService.listarTodos();
        }
        return this.produtos;
    }
    public String salvar() {
        this.produtoService.salvar(produto);
        return "consultar?faces-redirect=true";
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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
    public void preAlterar(Produto produto) {
        this.produto = produto;
        inicializarOperacoes();
        this.operacaoAlterar = true;
    }
    public void preCadastrar() {
        this.produto = new Produto();
        inicializarOperacoes();
        this.operacaoCadastrar = true;
    }
    public void remover(Produto produto) {
        this.produtoService.remover(produto);
        this.produtos = this.produtoService.listarTodos();
        this.operacaoConsultar = true;
    }
    public void alterar() {
        this.produtoService.salvar(this.produto);
        this.limparEntidade();
        inicializarOperacoes();
        this.produtos = this.produtoService.listarTodos();
        this.operacaoConsultar = true;
    }
    public void cadastrar() {
        this.produtoService.salvar(this.produto);
        this.limparEntidade();
        inicializarOperacoes();
        this.operacaoConsultar = true;
    }
    public void limparEntidade() {
        this.produto = new Produto();
    }
}