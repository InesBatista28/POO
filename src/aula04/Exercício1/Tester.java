package aula04.Exercício1;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Figura> figuras = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n1. Criar Círculo");
            System.out.println("2. Criar Retângulo");
            System.out.println("3. Criar Triângulo");
            System.out.println("4. Listar Figuras");
            System.out.println("5. Comparar Figuras");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Raio: ");
                        double r = sc.nextDouble();
                        figuras.add(new Círculo(r));
                        break;
                    case 2:
                        System.out.print("Comprimento: ");
                        double comp = sc.nextDouble();
                        System.out.print("Altura: ");
                        double alt = sc.nextDouble();
                        figuras.add(new Retângulo(comp, alt));
                        break;
                    case 3:
                        System.out.print("Lado 1: ");
                        double l1 = sc.nextDouble();
                        System.out.print("Lado 2: ");
                        double l2 = sc.nextDouble();
                        System.out.print("Lado 3: ");
                        double l3 = sc.nextDouble();
                        figuras.add(new Triângulo(l1, l2, l3));
                        break;
                    case 4:
                        if (figuras.isEmpty()) {
                            System.out.println("Nenhuma figura criada.");
                        } else {
                            for (Figura f : figuras) {
                                System.out.printf("Figura: %s | Área: %.2f | Perímetro: %.2f\n",
                                f.toString(), f.calcularArea(), f.calcularPerimetro());
                            }
                        }
                        break;

                    case 5:
                        for (int i = 0; i < figuras.size(); i++) {
                            for (int j = i + 1; j < figuras.size(); j++) {
                                Figura f1 = figuras.get(i);
                                Figura f2 = figuras.get(j);
                                if (f1.getClass() == f2.getClass()) {
                                    System.out.printf("Figura %d e Figura %d são %s.\n", 
                                        i + 1, j + 1, f1.equals(f2) ? "iguais" : "diferentes");
                                }
                            }
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);

        sc.close();
    }
}

