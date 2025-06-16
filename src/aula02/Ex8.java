package aula02;
import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Criamos um scanner para todo o programa
        int numero = lerInteiroComValidacao(sc, 1, 10);
        System.out.println("Número válido inserido: " + numero);
        sc.close();  // Fechamos o scanner apenas no fim do programa
    }

    public static int lerInteiroComValidacao(Scanner sc, int min, int max) {
        int valor;
        while (true) {
            System.out.print("Insira um número entre " + min + " e " + max + ": ");
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                sc.nextLine();  // Limpar o buffer após o nextInt (importante!)
                
                if (valor >= min && valor <= max) {
                    return valor;  // Valor válido
                } else {
                    System.out.println("Erro: O número deve estar entre " + min + " e " + max + ".");
                }
            } else {
                System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
                sc.nextLine();  // Limpar buffer em caso de input inválido
            }
        }
    }
}
