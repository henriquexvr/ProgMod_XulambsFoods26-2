public class PedidoLocal extends Pedido{
    private static double TAXA_SERVIÇO = 0.1;

    private double taxaServico(){
        return super.valorPizzas() * TAXA_SERVIÇO;
    }

    @Override
    public double precoAPagar() {
        return valorPizzas() + taxaServico();
    }

    @Override 
    public String toString(){
        StringBuilder cupom = new StringBuilder(cabecalho());
        cupom.append("PEDIDO LOCAL\n");
        cupom.append(detalhesPedido()+"\n");
        
        cupom.append(String.format("SERVIÇO: R$ %.2f\n", 
                            precoAPagar()));
        cupom.append(String.format("VALOR: R$ %.2f", 
                            precoAPagar()));

        return cupom.toString();
    }
}
