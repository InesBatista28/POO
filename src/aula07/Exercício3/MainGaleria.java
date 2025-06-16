package aula07.Exercício3;

import java.util.Scanner;

public class MainGaleria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Galeria galeria = new Galeria(100);
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar uma obra");
            System.out.println("2. Listar obras");
            System.out.println("3. Vender uma obra");
            System.out.println("4. Calcular o lucro total");
            System.out.println("5. Sair");
            System.out.print("Opçao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n1. Adicionar uma obra do tipo");
                    System.out.println("1. Quadro");
                    System.out.println("2. Escultura");
                    System.out.println("3. Obra Digital (NFT)");
                    System.out.print("Tipo de produto: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome da obra: ");
                    String nome = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Preço base: ");
                    double preco = sc.nextDouble();
                    sc.nextLine();

                    switch (tipo) {
                        case 1:
                            System.out.print("Tipo de Tinta: ");
                            String tinta = sc.nextLine();
                            System.out.print("Obra emoldurada? (s/n): ");
                            boolean emoldurada = sc.nextLine().equalsIgnoreCase("s");
                            System.out.print("Tamanho da Tela (S/M/L/XL): ");
                            String tamanho = sc.nextLine();
                            galeria.adicionarObra(new Quadro(nome, autor, preco, tinta, emoldurada, tamanho));
                            break;
                        case 2:
                            System.out.print("Material: ");
                            String material = sc.nextLine();
                            System.out.print("Quantos exemplares foram produzidos: ");
                            int exemplares = sc.nextInt();
                            sc.nextLine();
                            galeria.adicionarObra(new Escultura(nome, autor, preco, material, exemplares));
                            break;
                        case 3:
                            System.out.print("Nome da Blockchain: ");
                            String blockchain = sc.nextLine();
                            System.out.print("Endereço do Contrato: ");
                            String contrato = sc.nextLine();
                            galeria.adicionarObra(new ObraDigital(nome, autor, preco, blockchain, contrato));
                            break;
                    }
                    break;

                case 2:
                    galeria.listarObras();
                    break;

                case 3:
                    System.out.print("Identificador da Obra: ");
                    int id = sc.nextInt();
                    System.out.print("Preço de venda: ");
                    double precoVenda = sc.nextDouble();
                    sc.nextLine();
                    galeria.venderObra(id, precoVenda);
                    break;

                case 4:
                    System.out.println("Lucro total: " + galeria.lucroTotal());
                    break;

                case 5:
                    System.out.println("5. Sair");
                    sc.close();
                    break;
            }
        } while (opcao != 5);
    }
}
