//Programa que representa a distância entre dois pontos

package aula02;
import java.util.Scanner;

public class Ex2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Introduza as coordenadas do ponto p1");
        System.out.print("x1: ");
        double x1 = sc.nextDouble();
        System.out.print("y1: ");
        double y1 = sc.nextDouble();
        System.out.println("Introduza as coordenadas do ponto p2");
        System.out.print("x2: ");
        double x2 = sc.nextDouble();
        System.out.print("y2: ");
        double y2 = sc.nextDouble();
        double distancia = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
        System.out.println("A distância entre os pontos p1 e p2 é: " + distancia);
        sc.close();
     }
}
