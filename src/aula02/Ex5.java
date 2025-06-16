package aula02;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Introduza uma palavra ou frase: ");
        String frase = sc.nextLine();

        String textoMinusculo = frase.toLowerCase();
        System.out.println("Texto em minúsculas: " + textoMinusculo);

        String textoMaiusculo = frase.toUpperCase();
        System.out.println("Texto em maíusculas: " + textoMaiusculo);
        
        char ultimoCaractere = frase.charAt(frase.length() - 1);
        System.out.println("Último caractere: " + ultimoCaractere);

        if (frase.length() >= 3) {
            String tresPrimeiros = frase.substring(0, 3);
            System.out.println("Os 3 primeiros caracteres: " + tresPrimeiros);
        } else {
            System.out.println("A frase tem menos de 3 caracteres.");
        }
        sc.close();
    }
}
