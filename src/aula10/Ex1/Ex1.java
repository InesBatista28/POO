package aula10.Ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Ex1 {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>(); //Chave é uma palavra e o valor é um int 
        String filename = "C:\\Users\\iness\\OneDrive\\Ambiente de Trabalho\\Engenharia Informática\\1ºAno\\2ºSemestre\\POO\\src\\aula10\\Ex1\\major.txt"; //caminho do ficheiro a ler

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) { // Read the file 
            String line;
            while ((line = br.readLine()) != null) {
                String[] palavras = line.split("\\s+");
                for (int i = 0; i < palavras.length - 1; i++) {  //percorre as palavras até à penúltima já que está a analisar pares de palavras
                    if (palavras[i].length() >= 3) {  //só considera palavras com 3 ou mais letras
                        String palavra1 = palavras[i].replaceAll("[.,:;'‘’;?!\\-*{}=+&/()\\[\\]”“\"']", "");
                        String palavra2Raw = palavras[i+1];

                        String palavra2;
                        if (isSeparador(palavra2Raw)) {
                            palavra2 = "separador";
                        } else {
                            palavra2 = palavra2Raw.replaceAll("[.,:;'‘’;?!\\-*{}=+&/()\\[\\]”“\"']", "");
                        }


                        if (isSeparador(palavra2)) {
                            palavra2 = "separador";  //considera o separador 
                        }

                        if (map.containsKey(palavra1)) {  //palavra1 lida já existente 
                            HashMap<String, Integer> innerMap = map.get(palavra1);
                            if (innerMap.containsKey(palavra2)) {  //atualização do contador
                                innerMap.put(palavra2, innerMap.get(palavra2) + 1);  //palavra2 já existente no mapa
                            } else {
                                innerMap.put(palavra2, 1);  //palavra2 não existe no mapa
                            }

                        } else {  //palavra1 ainda não existe no mapa
                            HashMap<String, Integer> innerMap = new HashMap<>();
                            innerMap.put(palavra2, 1);  //adiciona a palavra2
                            map.put(palavra1, innerMap);
                        }
                    } 

                }
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        for (String palavra1 : map.keySet()) {
            System.out.print(palavra1 + "={");
            HashMap<String, Integer> innerMap = map.get(palavra1);
            int count = 0;
            int size = innerMap.size();
            for (String palavra2 : innerMap.keySet()) {
                System.out.print(palavra2 + "=" + innerMap.get(palavra2));
                count++;
                if (count < size) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        }
    }

    public static boolean isSeparador(String word) {
        if(word.matches("\\w*[\\t\\n.,:'‘’;?!\\-*{}=+&/()\\[\\]”“\"']\\w*")) {
            return true;
        }
        else {
            return false;
        }
    }
}
