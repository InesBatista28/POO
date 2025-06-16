package aula02.TP_codigo;

public class Square {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
           int result = getSquare(i);
           System.out.println("Square of " + i + " is : " + result);
        }
    }
    private static int getSquare(int x) {
        return x * x;
    }
}


