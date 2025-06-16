package aula03;

import java.util.Random;
import java.util.Scanner;

//Adivinhar número entre 0 e 100, escolhido aleatoriamente 

public class JogoAltoBaixo {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        Random random = new Random ();
        String continuar = "S";

        while (continuar.equals("S")) {
            int numeroAleatorio = random.nextInt(100) + 1;
            int tentativas = 0;
            int guess = -1;  //Começar o int com um valor inválido
            System.out.println("Tente adivinhar o número escolhido (0-100) ");
            while (guess != numeroAleatorio) {
                System.out.print("Insira a sua guess: ");
                while (!sc.hasNextInt()) {  //O programa segue se tiver sido inserido no teclado um int 
                    System.out.println("Valor inserido é inválido.");
                    sc.next();
                    System.out.println("Nova guess: ");
                }

                guess = sc.nextInt();  //Torna o valor inserido pelo teclado na variável guess
                tentativas ++; 

                if (guess > numeroAleatorio) {
                    System.out.println("Mais baixo");
                } else if (guess < numeroAleatorio) {
                    System.out.println("Mais Alto");
                } else {
                    System.out.println("Certo! O número era " + numeroAleatorio + ". Acertou em " + tentativas + " tentativas.");
                }
            }

            System.out.print("Pretende continuar? Prima (S)im: ");
            continuar = sc.next();  //A veriável continuar assume agora o valor inserido, se diferente de "S", o programa para 
        }

        sc.close();
    }
}
