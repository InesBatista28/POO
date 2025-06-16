package aula10.Ex4;

import java.io.*;
import java.util.*;

public class Aeroporto {

    public static void main(String[] args) {
        Map<String, String> companhias = lerCompanhias("C:\\Users\\iness\\OneDrive\\Ambiente de Trabalho\\Engenharia Informática\\1ºAno\\2ºSemestre\\POO\\src\\aula10\\Ex4\\companhias.txt");
        List<Voo> voos = lerVoos("C:\\Users\\iness\\OneDrive\\Ambiente de Trabalho\\Engenharia Informática\\1ºAno\\2ºSemestre\\POO\\src\\aula10\\Ex4\\voos.txt", companhias);

        // a) Mostrar tabela no ecrã
        System.out.printf("%-5s %-8s %-25s %-20s %-6s %s\n",
                "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");

        for (Voo voo : voos) {
            System.out.println(voo);
        }

        // b) Guardar em ficheiro
        guardarTabela(voos, "Infopublico.txt");

        // c) Mostrar atraso médio por companhia
        mostrarAtrasoMedioPorCompanhia(voos);

        // d) Guardar total de voos por cidade
        guardarVoosPorOrigem(voos, "cidades.txt");
    }

    public static Map<String, String> lerCompanhias(String nomeFicheiro) {
    Map<String, String> map = new HashMap<>();
    try (Scanner sc = new Scanner(new File(nomeFicheiro))) {
        if (sc.hasNextLine()) sc.nextLine(); // Ignora a linha do cabeçalho
        while (sc.hasNextLine()) {
            String[] partes = sc.nextLine().split("\t");
            if (partes.length == 2) {
                map.put(partes[0], partes[1]);
            }
        }
    } catch (IOException e) {
        System.out.println("Erro a ler companhias: " + e.getMessage());
    }
    return map;
}

    public static List<Voo> lerVoos(String ficheiro, Map<String, String> companhias) {
        List<Voo> lista = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(ficheiro))) {
            if (sc.hasNextLine()) sc.nextLine(); // Ignora a linha do cabeçalho
            while (sc.hasNextLine()) {
                String[] partes = sc.nextLine().split("\t");
                String hora = partes[0];
                String codigo = partes[1];
                String origem = partes[2];
                String atraso = (partes.length == 4) ? partes[3] : null;

                String sigla = codigo.replaceAll("[^A-Z]", "");
                String nomeCompanhia = companhias.getOrDefault(sigla, sigla);

                Voo v = new Voo(hora, codigo, nomeCompanhia, origem, atraso);
                lista.add(v);
            }
        } catch (IOException e) {
            System.out.println("Erro a ler voos: " + e.getMessage());
        }
        return lista;
    }

    public static void guardarTabela(List<Voo> voos, String nomeFicheiro) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeFicheiro))) {
            pw.printf("%-5s %-8s %-25s %-20s %-6s %s\n", "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");
            for (Voo voo : voos) {
                pw.println(voo.toString());
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever para ficheiro: " + e.getMessage());
        }
    }

    public static void mostrarAtrasoMedioPorCompanhia(List<Voo> voos) {
        Map<String, Integer> totalMinutos = new HashMap<>();
        Map<String, Integer> contagens = new HashMap<>();

        for (Voo voo : voos) {
            if (voo.temAtraso()) {
                int atrasoMin = voo.getAtrasoMinutos();
                totalMinutos.put(voo.getCompanhia(),
                        totalMinutos.getOrDefault(voo.getCompanhia(), 0) + atrasoMin);
                contagens.put(voo.getCompanhia(),
                        contagens.getOrDefault(voo.getCompanhia(), 0) + 1);
            }
        }

        List<Map.Entry<String, Double>> lista = new ArrayList<>();
        for (String companhia : totalMinutos.keySet()) {
            double media = (double) totalMinutos.get(companhia) / contagens.get(companhia);
            lista.add(Map.entry(companhia, media));
        }

        lista.sort(Comparator.comparingDouble(Map.Entry::getValue));

        System.out.printf("\n%-25s %s\n", "Companhia", "Atraso médio (min)");
        for (Map.Entry<String, Double> entry : lista) {
            System.out.printf("%-25s %.1f\n", entry.getKey(), entry.getValue());
        }
    }

    public static void guardarVoosPorOrigem(List<Voo> voos, String nomeFicheiro) {
        Map<String, Integer> contagem = new HashMap<>();
        for (Voo voo : voos) {
            contagem.put(voo.getOrigem(), contagem.getOrDefault(voo.getOrigem(), 0) + 1);
        }

        List<Map.Entry<String, Integer>> lista = new ArrayList<>(contagem.entrySet());
        lista.sort((a, b) -> b.getValue() - a.getValue());

        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeFicheiro))) {
            pw.printf("%-20s %s\n", "Origem", "Voos");
            for (Map.Entry<String, Integer> entry : lista) {
                pw.printf("%-20s %d\n", entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever cidades.txt: " + e.getMessage());
        }
    }
}
