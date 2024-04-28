import org.json.JSONObject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem Vindo ao Conversor de Moedas!");
        System.out.print("Entre a Moeda Base (Ex: BRL): ");
        String base = scanner.nextLine().toUpperCase();

        JSONObject rates = CurrencyConverter.getRates(base);
        if (rates != null) {
            System.out.println("Moedas disponiveis para conversão: " + rates.keySet());
            System.out.print("Para qual moeda você deseja converter: ");
            String target = scanner.nextLine().toUpperCase();

            if (rates.has(target)) {
                System.out.print("Qual o valor em " + base + ": ");
                double amount = scanner.nextDouble();
                double rate = rates.getDouble(target);
                double converted = amount * rate;
                System.out.printf("%.2f %s is %.2f %s%n", amount, base, converted, target);
            } else {
                System.out.println("Moeda não Disponivel.");
            }
        } else {
            System.out.println("Falha ao receber dados.");
        }
    }
}
