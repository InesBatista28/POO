package aula06.Exercício2;
import aula06.Exercício1.Pessoa;
import aula05.Exercício1.DateYMD;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager gestor = new ContactManager();

        int opcao;
        do {
            System.out.println("\n==== MENU DE CONTACTOS ====");
            System.out.println("1. Inserir contacto");
            System.out.println("2. Alterar contacto");
            System.out.println("3. Apagar contacto");
            System.out.println("4. Procurar contacto");
            System.out.println("5. Listar contactos");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> {
                    Pessoa pessoa = criarPessoa(sc);

                    List<Contacto> encontrados = gestor.procurarPorNomeOuNumero(pessoa.getNome());
                    if (!encontrados.isEmpty()) {
                        System.out.println("Já existe uma pessoa com esse nome:");
                        encontrados.forEach(System.out::println);
                        System.out.print("Deseja continuar e criar novo contacto? (s/n): ");
                        if (!sc.nextLine().equalsIgnoreCase("s")) {
                            break;
                        }
                    }

                    String telefone = lerTelefoneOpcional(sc);
                    String email = lerEmailOpcional(sc);

                    try {
                        Contacto contacto = new Contacto(pessoa, telefone, email);
                        gestor.inserirContacto(contacto);
                        System.out.println("Contacto inserido com sucesso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Nome ou número do contacto a alterar: ");
                    String termo = sc.nextLine();
                    List<Contacto> lista = gestor.procurarPorNomeOuNumero(termo);
                    if (lista.isEmpty()) {
                        System.out.println("Contacto não encontrado.");
                    } else if (lista.size() == 1) {
                        alterarContacto(sc, lista.get(0));
                    } else {
                        lista.forEach(System.out::println);
                        System.out.print("Digite o ID do contacto a alterar: ");
                        int id = Integer.parseInt(sc.nextLine());
                        Contacto c = gestor.procurarPorId(id);
                        if (c != null) alterarContacto(sc, c);
                        else System.out.println("ID inválido.");
                    }
                }
                case 3 -> {
                    System.out.print("Nome ou número do contacto a apagar: ");
                    String termo = sc.nextLine();
                    List<Contacto> lista = gestor.procurarPorNomeOuNumero(termo);
                    if (lista.isEmpty()) {
                        System.out.println("Contacto não encontrado.");
                    } else if (lista.size() == 1) {
                        gestor.apagarContacto(lista.get(0).getId());
                        System.out.println("Contacto removido.");
                    } else {
                        lista.forEach(System.out::println);
                        System.out.print("Digite o ID do contacto a remover: ");
                        int id = Integer.parseInt(sc.nextLine());
                        if (gestor.apagarContacto(id)) System.out.println("Contacto removido.");
                        else System.out.println("ID inválido.");
                    }
                }
                case 4 -> {
                    System.out.print("Nome ou número do contacto a procurar: ");
                    String termo = sc.nextLine();
                    List<Contacto> lista = gestor.procurarPorNomeOuNumero(termo);
                    if (lista.isEmpty()) System.out.println("Nenhum contacto encontrado.");
                    else lista.forEach(System.out::println);
                }
                case 5 -> {
                    List<Contacto> todos = gestor.listarContactos();
                    if (todos.isEmpty()) System.out.println("Nenhum contacto registado.");
                    else todos.forEach(System.out::println);
                }
                case 0 -> System.out.println("A sair...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        sc.close();
    }

    // Método auxiliar para criar Pessoa
    public static Pessoa criarPessoa(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Número de CC: ");
        int cc = Integer.parseInt(sc.nextLine());

        System.out.print("Data de nascimento (dia mês ano): ");
        int dia = sc.nextInt();
        int mes = sc.nextInt();
        int ano = sc.nextInt();
        sc.nextLine(); // limpar buffer

        return new Pessoa(nome, cc, new DateYMD(dia, mes, ano));
    }

    // Leitura e validação de telefone (pode ser vazio)
    public static String lerTelefoneOpcional(Scanner sc) {
        System.out.print("Número de telemóvel (opcional): ");
        String tel = sc.nextLine().trim();
        if (!tel.isEmpty() && !tel.matches("9\\d{8}")) {
            System.out.println("Número inválido. Deve ter 9 dígitos e começar por 9.");
            return lerTelefoneOpcional(sc); // tentar de novo
        }
        return tel;
    }

    // Leitura e validação de email (pode ser vazio)
    public static String lerEmailOpcional(Scanner sc) {
        System.out.print("Email (opcional): ");
        String email = sc.nextLine().trim();
        if (!email.isEmpty() &&
            (!email.contains("@") || !email.matches(".*\\.(pt|com|org|net|edu)$"))) {
            System.out.println("Email inválido.");
            return lerEmailOpcional(sc); // tentar de novo
        }
        return email;
    }

    // Alterar contacto
    public static void alterarContacto(Scanner sc, Contacto contacto) {
        System.out.println("Contacto atual: " + contacto);
        String novoTel = lerTelefoneOpcional(sc);
        String novoEmail = lerEmailOpcional(sc);
        try {
            contacto.setTelefone(novoTel);
            contacto.setEmail(novoEmail);
            System.out.println("Contacto atualizado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }
}
