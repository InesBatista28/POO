package aula03;
import java.util.Scanner;

//Ler número inteiro positivo e devolver soma de todos os números primos até ao valor indicado 

public class SomaPrimos {
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        int numero;
        int sum = 0;

        do{
            System.out.print("Número inteiro positivo: ");
            numero = sc.nextInt();  //O número inserido pelo teclado passa a ser o int numero pelo sc 
        } while (numero < 0);  //Verificação de que o número inserido é positivo (válido)

        for (int i = numero; i>0; i--) {  //Contagem decrescente para percorrer todos os núemros inteiros até ao 0, começando no int inserido 
            if(isPrime(i)) sum += i;  //Verifica se é primo pelo método, se true adicona o valor do mesmo à sum
        }

        System.out.println("Soma dos números primos: " + sum);
        sc.close();
    }

    //Método para verificar se o número da contagem é decrescente
    private static boolean isPrime(int numero) {
        if (numero < 2) return false; //0 e 1 não são primos

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false; //Se for divisível, não é primo
        }

        return true;
    } 
}

    