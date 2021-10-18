package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {

        Cardapio risoto = new Cardapio();
        risoto.setId(1);
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponibilidade(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setId(2);
        salmao.setNome("Salmao ao molho de maracuja");
        salmao.setDescricao("Salmao grelhado ao molho de maracuja");
        salmao.setDisponibilidade(true);
        salmao.setValor(BigDecimal.valueOf(60.00));

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        entityManager.flush();
        cardapioDao.cadastrar(salmao);
        entityManager.flush();
        System.out.println("O Prato consultado foi: " + cardapioDao.consultar(2));

        cardapioDao.excluir(risoto);
        System.out.println("O Prato consultado foi: " + cardapioDao.consultar(1));
        //entityManager.getTransaction().commit();
        entityManager.clear();

        salmao.setValor(BigDecimal.valueOf(50.00));
        cardapioDao.atualizar(salmao);
        System.out.println("O Prato atualizado foi: " + cardapioDao.consultar(2));

    }
}
