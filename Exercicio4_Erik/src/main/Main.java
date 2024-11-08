package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import calculadora.Calculadora;
import model.Cliente;
import model.Pedido;
import model.Produto;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Cliente cliente = new Cliente();
		
		System.out.println("Olá, seja bem vindo ao programa de pedido de venda!");
		System.out.println("Digite seu nome: ");
		cliente.setNome(scanner.nextLine());
		
		System.out.println("Digite seu endereço: ");
		cliente.setEndereco(scanner.nextLine());
		
		Pedido pedido = new Pedido(cliente);
		
		while(true) {
			System.out.println("Digite o nome do produto ('exit' para finalizar): ");
			String nomeProduto = scanner.nextLine();
			
			if(nomeProduto.equals("exit")) {
				break;
			}
			
			System.out.println("Digite o valor do produto: ");
			float valorProduto;
			try {
				valorProduto = scanner.nextFloat();
			}catch(InputMismatchException e) {
				System.out.println("\n########## ERRO ##########");
				System.out.println("O valor digitado não corresponde ao formato esperado!");
				System.out.println("Dica: Digite o valor do produto utilizando ',' e não '.' para as casas decimais.");
				System.out.println("Tente novamente.");
				System.out.println("########## ##########\n");
				scanner.nextLine(); //limpa o buffer de leitura
				continue;
			}
			
			Produto produto = new Produto(nomeProduto, valorProduto);
			pedido.addItensToListAndUpdateValorTotal(produto);
			
			scanner.nextLine(); //limpa o buffer de leitura
		}
		
		//para calcular a data de hoje
		LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        pedido.setDate(today.format(formatter));
		
		System.out.println("Digite o número de parcelas: ");
		pedido.setQuantParcelas(scanner.nextInt());
		Calculadora calculadora = new Calculadora();
		pedido.setValorParcelas(calculadora.calcularValorParcelas(pedido.getValorTotal(), pedido.getQuantParcelas()));        
        
		
		System.out.println("===== Recibo do pedido =====");
		System.out.println("O código do pedido é: " +pedido.getCodigo());
		System.out.println("A data de hoje é: " +pedido.getDate());
		System.out.println("Seu nome é: " +pedido.getCliente().getNome());
		System.out.println("Seu endereço é: " +pedido.getCliente().getEndereco());
		System.out.println("Seu pedido foi:");
		for(Produto p : pedido.getProdutos()) {
			System.out.println("\nProduto: " +p.getNome()+ " R$" +p.getValor());
		}
		
		System.out.println("\nNúmero de parcelas: " +pedido.getQuantParcelas());
		for(int i=1; i<=pedido.getQuantParcelas(); i++) {
			System.out.println("Parcela " + i + ": " + pedido.getValorParcelas());
		}
		
		System.out.println("\nValor total do pedido R$" +pedido.getValorTotal());
	}

}
