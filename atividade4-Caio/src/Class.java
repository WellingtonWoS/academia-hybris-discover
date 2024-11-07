import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Obtendo a data de hoje formatada
        String orderDate = LocalDate.now().format(dateFormatter);

        System.out.println("Olá, seja bem-vindo ao programa de pedido de venda!");

        System.out.print("Digite o seu nome: ");
        String name = sc.nextLine();

        System.out.print("Digite o seu endereço: ");
        String address = sc.nextLine();

        String productName;
        int qtdOrder = 0;
        double totalPrice = 0.0;

        List<String> products = new ArrayList<>();
        List<Double> prices = new ArrayList<>();

        do {
            System.out.printf("Digite o nome do produto " + (qtdOrder + 1) + " (ou digite 'exit' para sair): ");
            productName = sc.nextLine();

            if (productName.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Digite o valor do produto " + (qtdOrder + 1) + ": ");
            double price = sc.nextDouble();
            sc.nextLine();

            products.add(productName);
            prices.add(price);
            totalPrice += price;
            qtdOrder++;
        } while (true);

        System.out.println("Em quantas parcelas você deseja pagar? ");
        System.out.print("Digite um número entre 1 até 3: ");
        int installment = sc.nextInt();
        double installmentValue = totalPrice / installment;

        System.out.println("\n====== Recibo do Pedido de Venda ======");
        System.out.println("Código do Pedido: 1");
        System.out.println("A data de hoje é: " + orderDate);
        System.out.println("Seu nome é: " + name);
        System.out.println("Seu endereço é: " + address);

        System.out.println("Seu pedido foi: ");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("\n%d. %s - R$ %.2f%n", i + 1, products.get(i), prices.get(i));
        }

        System.out.println("\nNúmero de Parcelas: " + installment);

        for (int i = 1; i <= installment; i++) {
            System.out.println("Parcela " + i + ": R$ " + String.format("%.2f", installmentValue));
        }

        System.out.println("\nValor total do pedido R$" + String.format("%.2f", totalPrice));

        sc.close();
    }
}