package TestePráticoFinal.src.TestePrático;
import java.time.LocalDateTime;

public class ConcertTester {
    public static void main(String[] args) {
        ConcertManager cm = new ConcertManager();

        // ----------------------------------------------------------
        Concert c1 = new Concert(1, 25.0, "Madrid, Espanha", LocalDateTime.parse("2025-05-27T11:00"));
        Concert c2 = new Concert(2, 35.0, "Oslo, Suecia", LocalDateTime.parse("2025-05-28T05:00"));
        cm.addConcert(c1);
        cm.addConcert(c2);
        // ----------------------------------------------------------

        cm.printAllConcerts();

        // ----------------------------------------------------------
        System.out.println(cm.getConcert(1));
        System.out.println(cm.calculateConcertCost(1));
        System.out.println(cm.getConcert(2));
        System.out.println(cm.calculateConcertCost(2));
        System.out.println(cm.getConcert(30));              // não existe!
        System.out.println(cm.calculateConcertCost(30));    // não existe!
        // ----------------------------------------------------------

        System.out.println("---------------");
        cm.sortConcertsByCost();
        System.out.println("---------------");

        cm.removeConcert(1);
        cm.removeConcert(2);

        // ----------------------------------------------------------
        cm.readFile("C:\\Users\\iness\\OneDrive\\Ambiente de Trabalho\\124877\\src\\TestePrático\\classicpimba.txt");
        cm.printAllConcerts();

        // ----------------------------------------------------------
        System.out.println(cm.getConcert(1));
        System.out.println(cm.calculateConcertCost(1));
        System.out.println(cm.getConcert(2));
        System.out.println(cm.calculateConcertCost(2));
        System.out.println(cm.getConcert(30));
        System.out.println(cm.calculateConcertCost(30));
        // ----------------------------------------------------------

        cm.writeFile("result.txt");

        // ----------------------------------------------------------

        System.out.println("---------------");
        cm.sortConcertsByCost();
        System.out.println("---------------");

        // ----------------------------------------------------------
    }
}
