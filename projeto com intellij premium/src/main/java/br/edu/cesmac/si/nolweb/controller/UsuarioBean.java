package br.edu.cesmac.si.nolweb.controller;

import br.edu.cesmac.si.nolweb.domain.Usuario;
import br.edu.cesmac.si.nolweb.service.UsuarioService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private List<Usuario> usuarios;
    private boolean operacaoConsultar = false;
    private boolean operacaoCadastrar = false;
    private boolean operacaoAlterar = false;
    @Inject
    private UsuarioService usuarioService;
    public UsuarioBean() {
        this.usuario = new Usuario();
        usuarios = new ArrayList<>();
        inicializarOperacoes();
        operacaoConsultar = true;
    }
    public List<Usuario> getUsuarios() {
        if (this.usuarios == null || this.usuarios.size() == 0) {
            this.usuarios = this.usuarioService.listarTodos();
        }
        return this.usuarios;
    }
    public String salvar() {
        this.usuarioService.salvar(usuario);
        return "consultar?faces-redirect=true";
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setEditoria(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setEditorias(List<Usuario> usuarios) {
        this.usuarios = usuarios;
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
    public void preAlterar(Usuario usuario) {
        this.usuario = usuario;
        inicializarOperacoes();
        this.operacaoAlterar = true;
    }
    public void preCadastrar() {
        this.usuario = new Usuario();
        inicializarOperacoes();
        this.operacaoCadastrar = true;
    }
    public void remover(Usuario usuario) {
        this.usuarioService.remover(usuario);
        this.usuarios = this.usuarioService.listarTodos();
        this.operacaoConsultar = true;
    }
    public void alterar() {
        this.usuarioService.salvar(this.usuario);
        this.limparEntidade();
        inicializarOperacoes();
        this.usuarios = this.usuarioService.listarTodos();
        this.operacaoConsultar = true;
    }
    public void cadastrar() {
        this.usuarioService.salvar(this.usuario);
        this.limparEntidade();
        inicializarOperacoes();
        this.operacaoConsultar = true;
    }
    public void limparEntidade() {
        this.usuario = new Usuario();
    }
}