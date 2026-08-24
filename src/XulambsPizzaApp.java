import java.util.LinkedList;
import java.util.List;

public class XulambsPizzaApp{
    private List<Pizza> pizzas;

    private void cabeçalho(){
        IO.println("\n==== XULAMBS PIZZA v0.1 ====");
        IO.println("===============================");
    }

    private int menuPrincipal(){
        cabeçalho();
        IO.println("1 - Comprar Pizzas\n");
        IO.println("2 - Mostrar Pizzas\n");
        IO.println("0 - Finalizar\n");
        
        return Integer.parseInt(IO.readln("Digite sua opção: "));
    }


    private void comprarPizza() {
        cabeçalho();
        IO.println("Comprando pizza: ");
        int adicionais = escolherIngredientes();
        Pizza novaPizza = new Pizza(adicionais);
        mostrarNota(novaPizza);
        pizzas.add(novaPizza);
    }

    private int escolherIngredientes(){
        return Integer.parseInt(IO.readln("Escreva a quantidade de ingredientes: "));
    }

    private void mostrarNota(Pizza novaPizza){
        IO.println("####################");
        IO.println(novaPizza.gerarCupom());
        IO.println("####################");
    }

    private void mostrarPizzas(){
        cabeçalho();
        for (Pizza pizza : pizzas) {
            mostrarNota(pizza);
            IO.println();
        }
    }
    void main(){
        int opcao;
        pizzas = new LinkedList<>();
        do {
            opcao = menuPrincipal();
            switch(opcao) {
            case 1 -> comprarPizza();
            case 2 -> mostrarPizzas();
            case 0 -> IO.println("Encerrando!!");
            default -> IO.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}





