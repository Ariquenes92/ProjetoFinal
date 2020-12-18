package br.edu.cesmac.si.nolweb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Fabricante {
    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fabricante")
    private Long idFabricante;

    @NotEmpty(message = "É Obrigatório informar um nome")
    private String nome;

    @NotEmpty
    private String cnpj;
    private String site;
    private String endereco;

    @OneToMany(mappedBy = "fabricante")
    private List<Produto> produtos;

    @OneToMany(mappedBy = "fabricante")
    private List<Remedio> remedios;

    public Fabricante(){}

    // gets e sets

    public Long getIdFabricante() {
        return idFabricante;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Remedio> getRemedios() {
        return remedios;
    }

    public void setRemedios(List<Remedio> remedios) {
        this.remedios = remedios;
    }

    public void setIdFabricante(Long idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
