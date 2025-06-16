package MT1.Parte1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parte1 {
    // -----------------------------------------------------
    //          !!! Não alterar este código !!!
    // -----------------------------------------------------
    private static int v1;
    private static List<Integer> v2 = new ArrayList<>();
    private static String v3;
    private static List<String> v4 = new ArrayList<>();
    // -----------------------------------------------------

    // -----------------------------------------------------------
    // >> Pode acrescentar novos métodos aqui (não é obrigatório)
    // -----------------------------------------------------------

    // pex., public static void ler(SOURCE) {}

    // -----------------------------------------------------------

    public static void lerTeclado() {
        Scanner sc = new Scanner(System.in);
    
        v1 = Integer.parseInt(sc.nextLine());  //Ler número inteiro
    
        String[] numeros = sc.nextLine().split(" ");  //Lê os números como strings e separa por espaço
        for (String num : numeros) {  //Loop que percorre todos os elementos do array
            v2.add(Integer.parseInt(num));  //Converte o num selecionado num int e adiciona-o à listav2
        }
    
        v3 = sc.nextLine();  //Ler string
    
        String[] palavras = sc.nextLine().split(" ");  //Separar palavras por espaços 
            for (String palavra : palavras) {
                v4.add(palavra);
        }
    
        sc.close();
    }

    
    public static void lerFicheiro() {
        try {
            File ficheiro = new File("C:/Users/iness/OneDrive/Ambiente de Trabalho/inputs.txt");
            Scanner sc = new Scanner(ficheiro);
    
            v1 = Integer.parseInt(sc.nextLine());
    
            String[] numeros = sc.nextLine().split(" ");
            for (String num : numeros) {
                v2.add(Integer.parseInt(num));
            }
    
            v3 = sc.nextLine();
    
            String[] palavras = sc.nextLine().split(" ");
            for (String palavra : palavras) {
                v4.add(palavra);
            }
    
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado.");
        }
    }
    
    public static void imprimir() {
        System.out.println(v1);
        for (int num : v2) {   
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(v3);
        for (String palavra : v4) {   
            System.out.print(palavra + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // -----------------------------------------------------------------
        // !!! Não imprimir texto a pedir determinado input, ler direto !!!
        // -----------------------------------------------------------------

        // pode editar livremente este código
        //lerTeclado();
        lerFicheiro();
        imprimir();
    }
}
