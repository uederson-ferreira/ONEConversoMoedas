import org.json.JSONObject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        String base = "";
        String target = "";
        while (true) {
            System.out.println("Bem Vindo ao Conversor de Moedas!\n");
            System.out.print(
                    """
                            ***********************************************
                            
                            Converter:
                            1) Dólar (USD) =>> Real (BRL)
                            2) Real (BRL) =>> Dólar (USD)
                            3) Peso Argentino (ARS) =>> Real (BRL)
                            4) Real (BRL) =>> Peso Argentino (ARS)
                            5) Yuan (CNY) =>> Real (BRL)
                            6) Real (BRL) =>> Yuan (CNY)
                            7) Digitar o código da moeda;
                            8) Sair
                            
                            ***********************************************
                            
                            Entre a Moeda Base (Ex: BRL):
                            """);
            escolha = scanner.nextInt();
            if (escolha == 1) {
                base = "USD";
                target = "BRL";
            }
            if (escolha == 2) {
                base = "BRL";
                target = "USD";
            }
            if (escolha == 3) {
                base = "ARS";
                target = "BRL";
            }
            if (escolha == 4) {
                base = "BRL";
                target = "ARS";
            }
            if (escolha == 5) {
                base = "CNY";
                target = "BRL";
            }
            if (escolha == 6) {
                base = "BRL";
                target = "CNY";
            }
            if (escolha == 7) {
                scanner = new Scanner(System.in);
                System.out.print("Entre a Moeda Base (Ex: BRL): ");
                base = scanner.nextLine().toUpperCase();
                JSONObject rates = CurrencyConverter.getRates(base);
                if (rates != null) {
                    System.out.println("Moedas disponiveis para conversão: " + rates.keySet());
                    System.out.print("Para qual moeda você deseja converter: ");
                    target = scanner.nextLine().toUpperCase();

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
                System.out.println("Digite 1 para voltar ou 8 para sair: ");
                scanner.nextInt();
                continue;
            }
        if (escolha == 8){
           break;
        }
            JSONObject rates = CurrencyConverter.getRates(base);
            if (rates != null) {
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
            System.out.println("Digite 1 para voltar ou 8 para sair: ");
            scanner.nextInt();
        }
    }
}
