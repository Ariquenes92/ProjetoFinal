package br.edu.cesmac.si.nolweb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista")
    private Long idLista;
    @NotNull
    private String nome;
    @NotEmpty
    private String datacriacao;
    private int numeroDeIntegrantes;
    @NotEmpty
    private String localCompra;
    @NotEmpty
    private String dataCompra;

    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario comprador;
    @NotEmpty
    private String localEntrega;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "lista_usuario",
            joinColumns = @JoinColumn(name = "id_lista"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "lista")
    private List<Remedio> remedios;

    @OneToMany(mappedBy = "lista")
    private List<Produto> produtos;

    //construtor
    public Lista (){}

    //gets e sets

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Remedio> getRemedios() {
        return remedios;
    }

    public void setRemedios(List<Remedio> remedios) {
        this.remedios = remedios;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(String datacriacao) {
        this.datacriacao = datacriacao;
    }

    public int getNumeroDeIntegrantes() {
        return numeroDeIntegrantes;
    }

    public void setNumeroDeIntegrantes(int numeroDeIntegrantes) {
        this.numeroDeIntegrantes = numeroDeIntegrantes;
    }

    public String getLocalCompra() {
        return localCompra;
    }

    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public String getLocalEntrega() {
        return localEntrega;
    }

    public void setLocalEntrega(String localEntrega) {
        this.localEntrega = localEntrega;
    }
}
