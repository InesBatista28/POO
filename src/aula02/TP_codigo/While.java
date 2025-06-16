package aula02.TP_codigo;

import java.util.Scanner;

public class While {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nota = -1;
        while((nota>20) || (nota<0)) {
            System.out.println("Insira a nota do aluno");
            nota = sc.nextInt();
        }
        sc.close();
    }
}


