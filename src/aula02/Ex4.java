package aula02;
import java.util.Scanner;

public class Ex4 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Introduza o primeiro valor: ");
        double primeiro = sc.nextInt();
        double soma = primeiro;
        double max = primeiro;
        double min = primeiro;
        int total = 1;

        while (true) {
            System.out.print("Introduza o próximo valor (para terminar introduzir priemiro valor): ");
            double valor = sc.nextInt();
            if (valor == primeiro) {
                break;
            }

            soma += valor;
            total++;

            if (valor > max) {
                max = valor;
            }

            if (valor < min) {
                min = valor;
            }
        }

        double media = soma / total;
        System.out.println("O valor da média dos valores introduzidos é: " + media);
        System.out.println("O valor máximo é: " + max);    
        System.out.println("O valor mínimo é: " + min);
        sc.close();
    }
}
