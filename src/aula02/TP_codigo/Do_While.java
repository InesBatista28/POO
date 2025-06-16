package aula02.TP_codigo;

import java.util.Scanner;

public class Do_While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nota;
        do {
            System.out.println("Insira a nota do aluno");
            nota = sc.nextInt();
        } while (nota < 0 || nota > 20);
        sc.close();
    }
}


    
