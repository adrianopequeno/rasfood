package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cliente;
import br.com.rasmoo.restaurante.entity.Ordem;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDao {

    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Ordem cliente) {
        this.entityManager.persist(cliente);
    }

    public Ordem consultarPorId(final Integer id) {
        return this.entityManager.find(Ordem.class, id);
    }

    public List<Ordem> consultarTodos() {
        String jsql = "SELECT c FROM Ordem c";

        return this.entityManager.createQuery(jsql, Ordem.class).getResultList();
    }

    public void atualizar(final Ordem ordem) {
        this.entityManager.merge(ordem);
    }

    public void excluir(final Ordem ordem) {
        this.entityManager.remove(ordem);
    }
}
