package aula02;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        System.out.print("Digite um frase: ");
        String frase = sc.nextLine();
        
        int numDigits = countDigits(frase);
        System.out.println("O número de números da string: " + numDigits);

        int numSpaces = countSpaces(frase);
        System.out.println("O número de espaços da string: " + numSpaces);

        boolean allLowerCase = isAllLowerCase(frase);
        System.out.println("A string só contém minúsculas: " + allLowerCase);

        String espaços = replace(frase);
        System.out.println("A string com todas as ocorrências de vários espaços seguidos substituídas por um único espaço: " + espaços);
        
        boolean palindromo = isPalindromo(frase);
        System.out.println("A frase é um palíndromo: " + palindromo);

        sc.close();
    }
    
    public static int countDigits(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }
    
    public static int countSpaces(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                count++;
            }   
        }
        return count;
    }

    public static boolean isAllLowerCase(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isLowerCase(c) && c!= ' '){
                return false;
            }
        }
        return true;
    }

    public static String replace(String s) {
        return s.replaceAll("\\s+", " ");
    }

    public static boolean isPalindromo(String s) {
        String cleanedString = s.replaceAll("\\s+", "").toLowerCase();
        int lenght = cleanedString.length();
        for (int i = 0; i < lenght/2; i++) {
            if (cleanedString.charAt(i) != cleanedString.charAt(lenght-1-i)) {
                return false;
            }
        }
        return true;
    }
}
