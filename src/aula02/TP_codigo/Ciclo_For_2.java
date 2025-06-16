package aula02.TP_codigo;

public class Ciclo_For_2 {
    public static void main(String[] args){
        int[] tb = new int[10];   //Associação de uma nova variável
        for (int i = 0 ; i < tb.length ; i++) 
            tb[i] = i * 2;   //até o i ter comprimento maior que o tb (10), multiplica-se por dois
        for (int i = 0 ; i < tb.length ; i++)
            System.out.print(tb[i] + ", ");  //adição de uma vírgula no fim do número
    }
}


