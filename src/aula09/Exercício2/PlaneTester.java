package aula09.Exercício2;
import java.util.Scanner;

public class PlaneTester {
    public static void main(String[] args) {
        PlaneManager manager = new PlaneManager();
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n===== Menu da Frota de Aviões =====");
            System.out.println("1. Adicionar avião comercial");
            System.out.println("2. Adicionar avião militar");
            System.out.println("3. Remover avião");
            System.out.println("4. Procurar avião");
            System.out.println("5. Imprimir todos os aviões");
            System.out.println("6. Imprimir aviões comerciais");
            System.out.println("7. Imprimir aviões militares");
            System.out.println("8. Avião mais rápido");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            option = sc.nextInt();
            sc.nextLine();  // Limpar o buffer depois do nextInt()

            switch (option) {
                case 1 -> {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Fabricante: ");
                    String fabricante = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Max passageiros: ");
                    int passageiros = sc.nextInt();
                    System.out.print("Velocidade max: ");
                    int vel = sc.nextInt();
                    System.out.print("Tripulantes: ");
                    int tripulantes = sc.nextInt();
                    sc.nextLine(); // Limpar buffer depois dos ints
                    manager.addPlane(new CommercialPlane(id, fabricante, modelo, ano, passageiros, vel, tripulantes));
                }
                case 2 -> {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Fabricante: ");
                    String fabricante = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Max passageiros: ");
                    int passageiros = sc.nextInt();
                    System.out.print("Velocidade max: ");
                    int vel = sc.nextInt();
                    System.out.print("Munições: ");
                    int municoes = sc.nextInt();
                    sc.nextLine(); // Limpar buffer depois dos ints
                    manager.addPlane(new MilitaryPlane(id, fabricante, modelo, ano, passageiros, vel, municoes));
                }
                case 3 -> {
                    System.out.print("ID do avião a remover: ");
                    String id = sc.nextLine();
                    manager.removePlane(id);
                }
                case 4 -> {
                    System.out.print("ID do avião: ");
                    String id = sc.nextLine();
                    Plane p = manager.searchPlane(id);
                    System.out.println(p != null ? p : "Avião não encontrado.");
                }
                case 5 -> manager.printAllPlanes();
                case 6 -> {
                    System.out.println("Aviões Comerciais:");
                    manager.getCommercialPlanes().forEach(System.out::println);
                }
                case 7 -> {
                    System.out.println("Aviões Militares:");
                    manager.getMilitaryPlanes().forEach(System.out::println);
                }
                case 8 -> {
                    Plane fast = manager.getFastestPlane();
                    if (fast != null) {
                        System.out.println("Avião mais rápido:");
                        System.out.println(fast);
                    } else {
                        System.out.println("Nenhum avião na frota.");
                    }
                }
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 0);

        sc.close();
    }
}
