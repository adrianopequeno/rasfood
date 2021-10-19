package br.com.rasmoo.restaurante.util;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.dao.ClienteDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.entity.Cliente;
import br.com.rasmoo.restaurante.entity.Endereco;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {

    private CargaDeDadosUtil() {
    }

    public static void cadastroCategorias(EntityManager entityManager) {
        Categoria entrada = new Categoria("Entradas");
        Categoria salada = new Categoria("Saladas");
        Categoria principal = new Categoria("Principal");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrar(entrada);
        entityManager.flush();
        categoriaDao.cadastrar(salada);
        entityManager.flush();
        categoriaDao.cadastrar(principal);
        entityManager.flush();
        entityManager.clear();
    }

    public static void cadastrarProdutosCardapio(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.consultarTodos();
        Cardapio moqueca = new Cardapio("Moqueca", "Peixe branco, banana da terra, arroz e faroza", true, BigDecimal.valueOf(95.00), categorias.get(2));
        Cardapio spaquetti = new Cardapio("Spaquetti", "Macarrao ao molho", true, BigDecimal.valueOf(55.00), categorias.get(2));
        Cardapio bife = new Cardapio("Bife", "Carne vermelha com cebola branca", true, BigDecimal.valueOf(125.00), categorias.get(2));
        Cardapio cordeiro = new Cardapio("Cordeiro", "Carne de bode assada com farinha", true, BigDecimal.valueOf(85.00), categorias.get(2));
        Cardapio scappeta = new Cardapio("Scappeta", "Carne de bode assada com farinha", true, BigDecimal.valueOf(200.00), categorias.get(0));
        Cardapio caesar = new Cardapio("Caesar", "Carne de bode assada com farinha", true, BigDecimal.valueOf(40.00), categorias.get(2));
        Cardapio chevre = new Cardapio("Chevre", "Carne de bode assada com farinha", true, BigDecimal.valueOf(55.00), categorias.get(1));

        cardapioDao.cadastrar(moqueca);
        cardapioDao.cadastrar(spaquetti);
        cardapioDao.cadastrar(bife);
        cardapioDao.cadastrar(cordeiro);
        cardapioDao.cadastrar(scappeta);
        cardapioDao.cadastrar(caesar);
        cardapioDao.cadastrar(chevre);
        entityManager.flush();
        entityManager.clear();

    }

}
