package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.ClienteDao;
import br.com.rasmoo.restaurante.dao.EnderecoDao;
import br.com.rasmoo.restaurante.dao.OrdemDao;
import br.com.rasmoo.restaurante.entity.Cliente;
import br.com.rasmoo.restaurante.entity.Endereco;
import br.com.rasmoo.restaurante.entity.Ordem;
import br.com.rasmoo.restaurante.entity.OrdensCardapio;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();

        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastroCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Endereco endereco = new Endereco("5553333", "Sao Vicente, 42", "Estacao", "Sao Paulo", "SP");
        Cliente felipe = new Cliente("01010201021", "Felipe");
        felipe.addEndereco(endereco);

        Ordem ordem = new Ordem(felipe);
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(1), 2));
        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(2), 3));
        clienteDao.cadastrar(felipe);
        ordemDao.cadastrar(ordem);
        System.out.println(ordem);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
