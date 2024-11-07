import java.util.ArrayList;
import java.util.List;

class PedidoVenda {

    private static int contadorPedidos = 0;
    private int codigoPedido;
    private String data;
    private String nomeCliente;
    private String endereco;
    private List<ItemPedido> itens;
    private int numParcelas;

    public PedidoVenda(String data, String nomeCliente, String endereco, int numParcelas) {

        this.codigoPedido = ++contadorPedidos;
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.itens = new ArrayList<>();
        this.numParcelas = numParcelas;
    }

    public int getCodigoPedido() {

        return codigoPedido;

    }

    public void adicionarItem(ItemPedido item) {

        itens.add(item);

    }

    public double calcularTotal() {

        return itens.stream().mapToDouble(ItemPedido::getValor).sum();

    }

    public double calcularValorParcela() {

        return calcularTotal() / numParcelas;

    }

    public List<String> gerarRecibo() {

        List<String> recibo = new ArrayList<>();
        recibo.add("CÓDIGO: " + codigoPedido);
        recibo.add("DATA: " + data);
        recibo.add("CLIENTE: " + nomeCliente);
        recibo.add("ENDEREÇO: " + endereco);
        recibo.add("Produto(s) Cadastado(s):");

        for (ItemPedido item : itens) {

            recibo.add(" <---> " + item);

        }

        recibo.add("Número de Parcelas(s): " + numParcelas);
        double valorParcela = calcularValorParcela();

        for (int i = 1; i <= numParcelas; i++) {

            recibo.add("Parcela --> " + i + ": R$ " + String.format("%.2f", valorParcela));

        }

        recibo.add("TOTAL do Pedido: R$ " + String.format("%.2f", calcularTotal()));
        return recibo;

    }
}