package model;

import java.util.ArrayList;

public class Pedido {
	private static int cont=1;
	private int codigo;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private Cliente cliente;
	private int quantParcelas;
	private float valorParcelas;
	private float valorTotal;
	private String date;

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		this.codigo = cont;
		cont++;
	}
	
	public int getCodigo() {
		return this.codigo;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	
	public void addItensToListAndUpdateValorTotal(Produto produto) {
		produtos.add(produto);
		this.valorTotal += produto.getValor();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getQuantParcelas() {
		return quantParcelas;
	}
	public void setQuantParcelas(int quantParcelas) {
		this.quantParcelas = quantParcelas;
	}
	public float getValorParcelas() {
		return valorParcelas;
	}
	public void setValorParcelas(float valorParcelas) {
		this.valorParcelas = valorParcelas;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
