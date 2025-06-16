//Inês Batista 124877

package TestePráticoFinal.src.TestePrático;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;

public class ConcertManager {
    private List<Concert> concerts;
    private IConcertCostCalculator profitCalculator;

    public ConcertManager() {
        this.concerts = new ArrayList<>();
        this.profitCalculator = new IConcertCostCalculator() {
            @Override
            public double calculateConcertCost(Concert c) {
                double lucroBase = 1500.0;
                double lucro = lucroBase * c.getDuracao();
                String local = c.getLocal().toLowerCase();
                if (!local.contains("Portugal")) {
                    lucro *= 2;
                }
                if (!local.contains("Portugal") && !local.contains("Espanha")) {
                    lucro -= 800;
                }
                return lucro;
            }
        };
    }

    public void addConcert(Concert concert) {
        concerts.add(concert);
    }

    public void removeConcert(int id) {
        concerts.removeIf(concert -> concert.getId() == id);
    }

    public Concert getConcert(int id) {
        for (Concert concert : concerts) {
            if (concert.getId() == id) {
                return concert;
            }
        }
        return null;
    }

    public double calculateConcertCost(int id) {
        Concert concert = getConcert(id);
        if (concert != null) {
            return profitCalculator.calculateConcertCost(concert);
        }
        return -1; 
    }

    public void printAllConcerts() {
        for (Concert concert : concerts) {
            System.out.println(concert);
        }
    }

    public void sortConcertsByCost() {
        Collections.sort(concerts, new Comparator<Concert>() {
            @Override
            public int compare(Concert c1, Concert c2) {
                double cost1 = profitCalculator.calculateConcertCost(c1);
                double cost2 = profitCalculator.calculateConcertCost(c2);
                return Double.compare(cost2, cost1);
            }
        });

        Map<Integer, List<Concert>> concertsByMonth = new TreeMap<>();
        for (Concert concert : concerts) {
            int month = concert.getDataHora().getMonthValue();
            concertsByMonth.computeIfAbsent(month, k -> new ArrayList<>()).add(concert);
        }

        for (Map.Entry<Integer, List<Concert>> entry : concertsByMonth.entrySet()) {
            System.out.println("Mês: " + entry.getKey());
            for (Concert concert : entry.getValue()) {
                System.out.println(concert);
            }
        }
    }

    public void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine(); 
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    String dateTimeStr = parts[3].trim();
                    if (dateTimeStr.startsWith("T")) {
                        dateTimeStr = dateTimeStr.substring(1);
                    }
                    Concert c = new Concert(
                    Integer.parseInt(parts[0]),
                    Double.parseDouble(parts[1]),
                    parts[2],
                    LocalDateTime.parse(dateTimeStr.replace(" ", "T"))
                    );
                addConcert(c);
                }
            }
            } catch (IOException e) {
                System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
            }
    }

    public void writeFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Concert c : concerts) {
                writer.println(c.toString());
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever o ficheiro: " + e.getMessage());
        }
    }
}
