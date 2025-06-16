package aula03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcularMedia {
    static class NotaAluno {  //Cada aluno tem associado a si nome, notaT e notaP 
        String nome;
        double notaT;
        double notaP;

        public NotaAluno(String nome, double notaT, double notaP) {
            //Construtor da classe (inicializar atributos)
            this.nome = nome;
            this.notaT = notaT;
            this.notaP = notaP;
        }
    }

    public static void main(String[] args) {
        List<NotaAluno> turma = new ArrayList<>();  //Craiação da lista para armazenar 

        try {
            File file = new File("C:\\Users\\iness\\OneDrive\\Ambiente de Trabalho\\Engenharia Informática\\1ºAno\\2ºSemestre\\POO\\src\\aula03\\notas.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String linha = sc.nextLine().trim();

                if (linha.isEmpty()) continue;

                // Usar separador por espaço(s)
                String[] dados = linha.split("\\s+");  //Todos os dados são armazenados 

                if (dados.length != 3) {
                    System.out.println("Linha inválida (ignorada): " + linha);
                    continue;
                }

                try {
                    String nome = dados[0];
                    double notaT = Double.parseDouble(dados[1]);
                    double notaP = Double.parseDouble(dados[2]);

                    turma.add(new NotaAluno(nome, notaT, notaP));
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao converter notas na linha: " + linha);
                }
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Ficheiro 'notas.txt' não encontrado.");
            return;
        }

        // Exibe os resultados
        System.out.println("\n   Nome       NotaT  NotaP  Pauta");
        for (NotaAluno aluno : turma) {
            int pauta = notaFinal(aluno.notaT, aluno.notaP);
            System.out.printf("%-10s %6.1f %6.1f %6d\n", aluno.nome, aluno.notaT, aluno.notaP, pauta);
        }

        // Lista de alunos aprovados
        System.out.println("\nAlunos aprovados:");
        for (NotaAluno aluno : turma) {
            int pauta = notaFinal(aluno.notaT, aluno.notaP);
            if (pauta != 66) {
                System.out.println(aluno.nome);
            }
        }
    }

    private static int notaFinal(double notaT, double notaP) {
        if (notaT < 7.0 || notaP < 7.0) {
            return 66; // Reprovado por nota mínima
        } else {
            double notaFinal = 0.4 * notaT + 0.6 * notaP;
            return (int) Math.round(notaFinal); // Arredondado à unidade
        }
    }
}
