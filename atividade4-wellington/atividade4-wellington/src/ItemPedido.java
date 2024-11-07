class ItemPedido {
    private String produto;
    private double valor;

    public ItemPedido(String produto, double valor) {

        this.produto = produto;
        this.valor = valor;

    }

    public double getValor() {

        return valor;
    }

    @Override
    public String toString() {

        return "PRODUTO do Cliente: " + produto + ", Valores: R$ " + valor;

    }
}