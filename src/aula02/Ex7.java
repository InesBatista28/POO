package aula02;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Digite um frase: ");
        String frase = sc.nextLine();
        String acronimo = gerarAcronimo(frase);
        System.out.println("Acrónimo: " + acronimo);
        sc.close();
    }

    public static String gerarAcronimo(String frase) {
        StringBuilder acronimo = new StringBuilder();
        String[] palavras = frase.split(" ");

        for (String palavra:palavras) {
            if(palavra.length() >= 3) {
                acronimo.append(palavra.charAt(0));
            }
        }
        return acronimo.toString().toUpperCase();
    }
}

