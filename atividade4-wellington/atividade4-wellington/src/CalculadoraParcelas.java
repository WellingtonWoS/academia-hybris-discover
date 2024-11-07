import java.util.List;
import java.util.Scanner;


public class CalculadoraParcelas {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Entrada do pedido
        System.out.print("DATA: ");
        String data = scan.nextLine();

        System.out.print("CLIENTE: ");
        String nomeCliente = scan.nextLine();

        System.out.print("ENDEREÇO: ");
        String endereco = scan.nextLine();

        System.out.print("Quantidade de Parcelas: ");
        int numParcelas = scan.nextInt();
        scan.nextLine(); // Consumir nova linha

        PedidoVenda pedido = new PedidoVenda(data, nomeCliente, endereco, numParcelas);

        // Entrada dos itens
        while (true) {

            System.out.print("Informe o Nome do Produto (ou DIGITE 'exit' para sair do programa ): ");
            String nomeProduto = scan.nextLine();
            
            if (nomeProduto.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("VALOR do Produto: ");
            double valorProduto = scan.nextDouble();
            scan.nextLine(); // Consumir nova linha

            ItemPedido item = new ItemPedido(nomeProduto, valorProduto);
            pedido.adicionarItem(item);
        }

        // Exibir recibo do pedido
        List<String> recibo = pedido.gerarRecibo();
        for (String linha : recibo) {
            System.out.println(linha);
        }

        scan.close();
    }
}
