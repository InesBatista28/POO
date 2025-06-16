package aula03;
import java.util.Scanner;

public class CalendarioMes {
    public static void main(String[] args) {
        int[] data = lerTeclado();
        int mes = data[0];
        int ano = data[1];
        int diaSemanaInicio = data[2];
        int diasNoMes = calcularDias(mes, ano);
        imprimirCalendario(mes, ano, diasNoMes, diaSemanaInicio);
    }

    public static int[] lerTeclado() {  //Método irá retornar um array com o mês,a ano e dia da semana 
        Scanner sc = new Scanner (System.in);
        int mes, ano, diaSemana;
        
        //Validação do mês
        while (true) {
            System.out.print("Insira o mes (1-12): ");
            mes = sc.nextInt();
            if (mes >= 1 || mes <= 12) {
                break;
            }

            System.out.println("Mês Inválido! Insira um mês (1-12): ");
        }

        //Validação do ano
        while (true) {
            System.out.print("Digite o ano (yyyy): ");
            ano = sc.nextInt();
            if (ano >= 0) {
                break;
            }

            System.out.println("Ano inválido! Digite um valor positivo.");
        }

        //Validação dia da semana 
        while (true) {
            System.out.print("Insira um dia da semana (1-7): ");
            diaSemana = sc.nextInt();
            if (diaSemana >= 1 || diaSemana <= 7) {
                break;
            }

            System.out.print("Dia da semana inválido. Insira de novo: ");
        }

        sc.close();
        return new int[] {mes, ano, diaSemana};
    }

    public static int calcularDias(int mes, int ano) {
        if (mes == 2) {
            if (ano%400 == 0 || (ano % 4 == 0 && ano % 100 != 0)) {
                return 29;
            } else {
                return 28;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public static void imprimirCalendario(int mes, int ano, int diasNoMes, int diaSemanaInicio) {
        System.out.printf("\nCalendário para %02d/%04d:\n", mes, ano);
        System.out.println("Seg Ter Qua Qui Sex Sab Dom");

        // Ajustar o dia da semana para o formato do calendário (Segunda = 1, Domingo = 7)
        int diaAtual = 1;
        int diaSemana = diaSemanaInicio;

        // Imprimir espaços em branco até o primeiro dia do mês
        for (int i = 1; i < diaSemana; i++) {
            System.out.print("    ");
        }

        // Imprimir os dias do mês
        while (diaAtual <= diasNoMes) {
            System.out.printf("%3d ", diaAtual);
            diaAtual++;
            diaSemana++;

            // Quebra de linha no final da semana
            if (diaSemana > 7) {
                System.out.println();
                diaSemana = 1;
            }
        }
        System.out.println("\n");
    }
}
