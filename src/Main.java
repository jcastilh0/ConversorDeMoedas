import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String opcao = "";

        /*Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();*/
        do {
            exibirMenu();
            opcao = lerOpcao(leitura);

            if (!opcao.equals("7") && !opcao.equalsIgnoreCase("sair")) {
                executarConversao(opcao, leitura);
            }
        } while (!opcao.equals("7") && desejaContinuar(leitura));

        leitura.close();
        System.out.println("Programa finalizado. Obrigado por usar o conversor!");

    }

    public static void exibirMenu() {
        System.out.println("**************************************************************");
        System.out.println("Seja bem vindo ao conversor de moeda\n");

        System.out.println("1 - Real -->> Dolar");
        System.out.println("2 - Dolar -->> Real");
        System.out.println("3 - Real -->> Euro");
        System.out.println("4 - Euro -->> Real");
        System.out.println("5 - Euro -->> Dolar");
        System.out.println("6 - Dolar -->> Euro");
        System.out.println("7 - Sair\n");
    }

    public static String lerOpcao(Scanner scanner) {
        System.out.print("Selecione uma opção válida: ");
        return scanner.nextLine();
    }

    public static boolean desejaContinuar(Scanner scanner) {
        System.out.print("\nDeseja fazer outra conversão? (sim/sair): ");
        String resposta = scanner.nextLine();
        return !resposta.equalsIgnoreCase("sair");
    }

    public static void executarConversao(String opcao, Scanner scanner) {
        ConversaoDeValor conversao = new ConversaoDeValor();
        double valor;
        switch (opcao) {
            case "1":
                System.out.print("Digite o valor em Reais: ");
                valor = scanner.nextDouble();
                scanner.nextLine(); // limpa buffer
                System.out.println(conversao.converter("BRL", "USD", valor));
                break;

            case "2":
                System.out.print("Digite o valor em Dólares: ");
                valor = scanner.nextDouble();
                scanner.nextLine();
                System.out.println(conversao.converter("USD", "BRL", valor));
                break;
            case "3":
                System.out.print("Digite o valor em Reais: ");
                valor = scanner.nextDouble();
                scanner.nextLine();
                System.out.println(conversao.converter("BRL", "EUR", valor));
                break;
            case "4":
                System.out.print("Digite o valor em Euros: ");
                valor = scanner.nextDouble();
                scanner.nextLine();
                System.out.println(conversao.converter("EUR", "BRL", valor));
                break;
            case "5":
                System.out.print("Digite o valor em Euros: ");
                valor = scanner.nextDouble();
                scanner.nextLine();
                System.out.println(conversao.converter("EUR", "USD", valor));
                break;
            case "6":
                System.out.print("Digite o valor em Dólares: ");
                valor = scanner.nextDouble();
                scanner.nextLine();
                System.out.println(conversao.converter("USD", "EUR", valor));
                break;
            default:
                System.out.println("Opção invalida");
        }
    }
}
