package aula02;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Insira o número de segundos: ");
        int segundos = sc.nextInt();
        int horas = segundos/3600;
        int minutos = (segundos%3600)/60;
        int segundosRestantes = minutos%60;
        System.out.println("O tempo em HH:MM:SS de " + segundos + " segundos é igual a " + horas + ":" + minutos + ":" + segundosRestantes);
        sc.close();
    }
}


