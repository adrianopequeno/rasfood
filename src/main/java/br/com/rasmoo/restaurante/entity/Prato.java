package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pratos")
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Boolean disponibilidade;
    private BigDecimal valor;

    @Column(name = "data_de_registro")
    private LocalDate dataDeResgistro = LocalDate.now();

    public Prato() {
    }

    public Prato(Integer id, String nome, String descricao, Boolean disponibilidade, BigDecimal valor, LocalDate dataDeResgistro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.disponibilidade = disponibilidade;
        this.valor = valor;
        this.dataDeResgistro = dataDeResgistro;
    }

    @Id
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

    @Override
    public String toString() {
        return "Prato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", disponibilidade=" + disponibilidade +
                ", valor=" + valor +
                ", dataDeResgistro=" + dataDeResgistro +
                '}';
    }

}
