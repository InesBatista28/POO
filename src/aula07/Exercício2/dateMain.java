package aula07.Exercício2;
import java.util.Scanner;

public class dateMain {
    public static void main(String[] args) {
        
        int escolha; 
        Date date = null;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Operações de data: ");
            System.out.println("1 - criar nova data");
            System.out.println("2 - mostra a data atual");
            System.out.println("3 - data de incremento");
            System.out.println("4 - data de decremento");
            System.out.println("0 - exit");
            System.out.print("A tua escolha- ");

            escolha = sc.nextInt();

            switch(escolha){
                case 1:
                    System.out.print("Insira um dia- ");
                    int day = sc.nextInt();

                    System.out.print("Insira um mês- ");
                    int month = sc.nextInt();

                    System.out.print("Insira um ano- ");
                    int year = sc.nextInt();

                    try {
                        date = new DateYMD(day, month, year);
                        System.out.println("Data criada com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Data inválida.");
                    }
                    break;
                case 2:
                    if (date == null) {
                        System.out.println("Data ainda não criada.");
                    } else {
                        System.out.println(date.toString());
                    }
                    break;

                case 3:
                    if (date == null) {
                        System.out.println("Data ainda não criada.");
                    } else {
                        date.incrementDay();
                        System.out.println("Data incrementada com sucesso.");
                    }
                    break;
                case 4:
                    if (date == null) {
                        System.out.println("Data ainda não criada.");
                    } else {
                        date.decrementDay();
                        System.out.println("Data decrementada com sucesso.");
                    }
                    break;
            } 
        }while (escolha != 0);
        sc.close();
    }
}

