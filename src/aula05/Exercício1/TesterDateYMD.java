package aula05.Exercício1;

import java.util.Scanner;

public class TesterDateYMD {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        DateYMD date = null;

        int option;
        do {
            System.out.println("\nDate operations:");
            System.out.println("1 - create new date");
            System.out.println("2 - show current date");
            System.out.println("3 - increment date");
            System.out.println("4 - decrement date");
            System.out.println("0 - exit");
            System.out.print("Option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Insira o dia: ");
                    int day = sc.nextInt();
                    System.out.println("Insira o mês (1-12): ");
                    int month = sc.nextInt();
                    System.out.println("Insira o ano: ");
                    int year = sc.nextInt();

                    try {
                        date = new DateYMD(day, month, year);
                        System.out.print("Data criada com sucesso");
                    } catch (IllegalArgumentException e) {
                        System.out.print("Data inválida");
                    }
                    break;
                case 2:
                    if(date != null) {
                        System.out.println("Current Date " + date);
                    } else {
                        System.out.println("Não existe qualquer data criada");
                    }
                    break;
                case 3:
                    if(date != null) {
                        date.increment();
                        System.out.println("Data incrementada: " + date);
                    } else {
                        System.out.println("Não existe qualquer data criada");
                    }
                    break;
                case 4:
                    if (date != null) {
                        date.decrement();
                        System.out.println("Data decrementada " + date);
                    } else {
                        System.out.println("Não há qualquer data criada");
                    }
                    break;
                case 0: 
                    break;
                default:
                    System.out.print("Opção Inválida");
                    break;
            }
        } while (option != 0);

        sc.close();
    }
}
