//Inês Batista 124877

package MT2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TransactionManager {
    private Map <Integer, Transaction> transacoes;
    private ITransactionCostCalculator calculator;

    public TransactionManager() {
        transacoes = new HashMap<>();
        calculator = new StandardTransactionCostCalculator();
    }


    public void addTransaction(Transaction t) {
        transacoes.put(t.getId(), t);
    }

    public boolean removeTransaction(int id) {
        return transacoes.remove(id) != null;
    }

    public Transaction getTransaction(int id) {
        return transacoes.get(id);
    }

    public double calculateTransactionCost(int id) {
        Transaction t = transacoes.get(id);
        if (t == null) {
            return -1;
        }
        return calculator.calculateTransactionCost(t);
    }

    public void printAllTransactions() {
        if (transacoes.isEmpty()) {
            System.out.print("Não existem transações disponiveis;");
        }
        for (Transaction t : transacoes.values()) {
            System.out.println(t);
        }
    }

    public void sortTransactionsByCost() {
        List<Transaction> lista = new ArrayList<>(transacoes.values());


        lista.sort(Comparator.comparing((Transaction t) -> t.getDataHora().getDayOfWeek())
                .thenComparing((Transaction t) -> -calculateTransactionCost(t.getId())));

        for (Transaction t : lista) {
            System.out.printf("%s ; Custo: %.2f\n", t, calculateTransactionCost(t.getId()));
        }
    }















    public void readFile(String filename) {        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean primeiraLinha = true;
            while ((line = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                if (line.trim().isEmpty()) {
                }
                String[] parts = line.split(";");
                if (parts.length < 4) {
                    System.out.println("Linha mal formatada: " + line);
                    continue;
                }
            int id = Integer.parseInt(parts[0].trim());
            double horas = Double.parseDouble(parts[1].trim());
            String descricao = parts[2].trim();
            String dataHoraStr = parts[3].trim();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, formatter);
            Transaction t = new Transaction(id, descricao, dataHora, horas);
            this.addTransaction(t);
        }
    } catch (IOException e) {
        System.out.print("Erro ao ler o ficheiro: " + e.getMessage());
    }
    }






    public void writeFile(String fich) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fich))) {
            for (Transaction t : transacoes.values()) {
                double custo = calculator.calculateTransactionCost(t);
                String linha = String.format("%d; %.1f; %s; %s; %.2f",
                        t.getId(),
                        t.getHorasTrabalho(),
                        t.getDescricao(),
                        t.getDataHora().format(formatter),
                        custo);
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever para o ficheiro: " + e.getMessage());
        }
    }
}
