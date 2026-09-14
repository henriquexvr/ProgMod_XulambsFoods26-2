import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.security.Permissions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    Pedido pedido;
    Pizza pizzaVazia;

    @BeforeEach
    public void setUp(){
        //Arrange
        pedido = new Pedido();
        pizzaVazia = new Pizza();
        pedido.adicionarPizza(pizzaVazia);
    }

    @Test
    public void calculaValorPedidoCorretamente(){
        //Act    
        double valor = pedido.precoAPagar();

        //Assert
        assertEquals(29d, valor, 0.01);
    }

    @Test
    public void calculaPrecoPedidioComVariasPizzas(){
        //Arrange
        Pizza pizzaComIngrediente = new Pizza(3);

        //Act
        pedido.adicionarPizza(pizzaComIngrediente);
        double valor = pedido.precoAPagar();

        //Assert
        assertEquals(73d, valor, 0.01);
    }

    @Test
    public void adicionaVariasPizzasCorretamente(){
        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
        //Assert
        assertEquals(2, quantidade);
    }

    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Arrange
        pedido.fecharPedido();

        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
    
        //Assert
        assertEquals(1, quantidade);
    }

    @Test
    public void geraRelatorioCorreto(){
        //Act
        String cupom = pedido.relatorio();
        //Assert
        assertTrue(
            cupom.contains("29,00") &&
            cupom.contains("1 pizza") &&
            cupom.contains("aberto")
        );
    }
}