import java.util.LinkedList;
import java.util.List;

public class XulambsApp {
    private List<Pizza> listaPizzas;

    private void limparTela() {
        IO.print("\033[H\033[2J");
    }

    private void pausa(){
        IO.readln("Digite <ENTER> para continuar");
        limparTela();
    }

    private void cabecalho(){
        limparTela();
        IO.println("XULAMBS PIZZA - v0.2");
        IO.println("=====================");
        IO.println("Pizzas vendidas hoje: " +
                    Pizza.getPizzasVendidas());
    }

    private int exibirMenu() {
        cabecalho();
        IO.println("1 - Abri pedido");
        IO.println("2 - Alterar pedidio");
        IO.println("3 - Relatório de pedido");
        IO.println("4 - Encerrar pedido");
        IO.println("0 - Sair");
        return Integer.parseInt(IO.readln("Digite sua opção: "));
    }



    Pizza comprarPizza(){
        cabecalho();
        int adicionais = 
            Integer.parseInt(IO.readln("Quantos ingredientes? "));
    
        Pizza novaPizza = new Pizza();
        novaPizza.adicionarIngredientes(adicionais);

        mostrarNota(novaPizza);
        return novaPizza;
    }

    void mostrarNota(Pizza pizza){
        IO.println("Pizza comprada:");
        IO.println(pizza.gerarCupom());
        IO.println("=====================");
    }

    void mostrarPizzas(){
        cabecalho();
        for (Pizza pizza : listaPizzas) {
            mostrarNota(pizza);
        }
    }

    void abrirPedido(){
        String querMais = "n";
        Pedido novoPedido = new Pedido();
        do{
            Pizza novaPizza = comprarPizza();
            novoPedido.adicionarPizza(novaPizza);
            querMais = IO.readln("Quer mais pizzas?  ");
        }while(querMais.equals("s"));
    }

    void alterarPedido(){
        cabecalho();
        int idPedidio = Integer.parseInt(IO.readln("Nº do pedido: "));
        String busca = String.format("Pedidio nº %d", idPedidio);
        for(Pedido ped : listaPedidos){
            if(ped.relatorio().contains(busca)){
                //achei
            }
        }
    }

    void main(){
        int opcao;
        listaPizzas = new LinkedList<>();
        do {
            opcao = exibirMenu();
            switch (opcao) {
                case 1 -> abrirPedido();
                case 2 -> alterarPedido();
                case 0 -> IO.println("Encerrando!");
                default -> IO.println("Opção inválida");
            }   
            pausa(); 
        } while (opcao != 0);
    }    
}
