package br.edu.cesmac.si.nolweb.domain;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @NotNull
    private String nome;
    @NotNull
    private String login;
    @NotNull
    private String senha;
    @Email
    private String email;
    @NotNull
    private String nascimento;
    @NotNull
    private String cpf;
    private String celular;
    private String facebook;
    @NotEmpty
    private String cep;
    private String endereco;

    @OneToMany(mappedBy = "comprador")
    private List<Lista> listasComprador;

    @ManyToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
    private List<Lista> listas;

    //construtor
    public Usuario(){}


    //gets e sets


    public List<Lista> getListas() {
        return listas;
    }

    public List<Lista> getListasComprador() {
        return listasComprador;
    }

    public void setListasComprador(List<Lista> listasComprador) {
        this.listasComprador = listasComprador;
    }

    public void setListas(List<Lista> listas) {
        this.listas = listas;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
