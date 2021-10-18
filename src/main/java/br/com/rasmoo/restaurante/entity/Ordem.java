package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordens")
public class Ordem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @ManyToOne
    private Cliente cliente;

    public Ordem() {
    }

    public Ordem(BigDecimal valorTotal, LocalDateTime dataDeCriacao, Cliente cliente) {
        this.valorTotal = valorTotal;
        this.dataDeCriacao = dataDeCriacao;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataDeCriacao=" + dataDeCriacao +
                ", cliente=" + cliente +
                '}';
    }
}
