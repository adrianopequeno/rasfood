package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cliente;
import br.com.rasmoo.restaurante.entity.Endereco;
import br.com.rasmoo.restaurante.vo.ClienteVo;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDao {

    private EntityManager entityManager;

    public EnderecoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Endereco endereco) {
        this.entityManager.persist(endereco);
    }

    public Endereco consultarPorId(final Integer id) {
        return this.entityManager.find(Endereco.class, id);
    }

    public List<Endereco> consultarTodos() {
        String jsql = "SELECT c FROM Endereco c";

        return this.entityManager.createQuery(jsql, Endereco.class).getResultList();
    }

    public List<ClienteVo> consultarClientes(final String estado, final String cidade, final String rua) {
        String jsql = "SELECT new br.com.rasmoo.restaurante.vo.ClienteVo(e.cliente.cpf, e.cliente.nome)" +
                "FROM Endereco e WHERE UPPER(e.estado) = UPPER(:estado) AND " +
                "UPPER(e.cidade) = UPPER(:cidade) AND " +
                "UPPER(e.rua) = UPPER(:rua)";
        return this.entityManager.createQuery(jsql, ClienteVo.class).setParameter("estado", estado)
                .setParameter("cidade", cidade).setParameter("rua", rua).getResultList();
    }

    public void atualizar(final Endereco endereco) {
        this.entityManager.merge(endereco);
    }

    public void excluir(final Endereco endereco) {
        this.entityManager.remove(endereco);
    }
}
