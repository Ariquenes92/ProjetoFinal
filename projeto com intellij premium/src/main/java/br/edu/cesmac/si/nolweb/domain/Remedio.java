package br.edu.cesmac.si.nolweb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Remedio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_remedio")
    private Long idRemedio;
    @NotNull
    private String nome;
    private String receita;
    @NotEmpty
    private String validade;
    @NotEmpty
    private String fabricacao;
    @NotNull
    private float valor;
    private int quantidade;

    @ManyToOne (cascade = CascadeType.ALL)
    private Lista lista;

    @ManyToOne (cascade = CascadeType.ALL)
    private Fabricante fabricante;

    //construtor
    public Remedio(){}

    //gets e sets

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Long getIdRemedio() {
        return idRemedio;
    }

    public void setIdRemedio(Long idRemedio) {
        this.idRemedio = idRemedio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(String fabricacao) {
        this.fabricacao = fabricacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
