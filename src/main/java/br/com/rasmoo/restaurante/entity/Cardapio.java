package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cardapio")
public class Cardapio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Boolean disponibilidade;
    private BigDecimal valor;

    @ManyToOne
    private Categoria categoria;

    @ManyToMany(mappedBy = "cardapioList")
    private List<Ordem> ordemList;

    @Column(name = "data_de_registro")
    private LocalDate dataDeResgistro = LocalDate.now();

    public Cardapio() {
    }

    public Cardapio(String nome, String descricao, Boolean disponibilidade, BigDecimal valor, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.disponibilidade = disponibilidade;
        this.valor = valor;
        this.categoria = categoria;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataDeResgistro() {
        return dataDeResgistro;
    }

    public void setDataDeResgistro(LocalDate dataDeResgistro) {
        this.dataDeResgistro = dataDeResgistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Cardapio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", disponibilidade=" + disponibilidade +
                ", valor=" + valor +
                ", categoria=" + categoria +
                ", dataDeResgistro=" + dataDeResgistro +
                '}';
    }
}
