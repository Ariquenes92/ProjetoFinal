package br.edu.cesmac.si.nolweb.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class OlaMundoController implements Serializable {

    private String saudacao;
    private String nome;
    private String textoSaudacao;

    public String getSaudacao() {
        return saudacao;
    }

    public void setSaudacao(String saudacao) {
        this.saudacao = saudacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTextoSaudacao() {
        return textoSaudacao;
    }

    public void setTextoSaudacao(String textoSaudacao) {
        this.textoSaudacao = textoSaudacao;
    }

    public void saudar(){
        this.textoSaudacao = "";
        this.textoSaudacao = this.saudacao + ", " + this.nome;
    }
}
