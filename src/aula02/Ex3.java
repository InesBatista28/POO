package aula02;
import java.util.Scanner;

public class Ex3 {
    public static void main  (String[] args) {
        Scanner sc = new Scanner (System.in);
        double A, B;
        do {
            System.out.print("Introduza o valor de A:" );
            A = sc.nextDouble();
        } while(A <= 0);

        do {
            System.out.print("Introduza o valor de B:" );
            B = sc.nextDouble();
        } while(B <= 0);

        double H = Math.sqrt(Math.pow(A,2) + Math.pow(B,2));
        double ang = Math.atan(B/A);

        System.out.println("A hipotenusa é: " + H);
        System.out.println("O ângulo é: " + Math.toDegrees(ang) + " graus");
        sc.close();
    }
}
