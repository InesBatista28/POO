package aula05.Exercício2;
import java.util.Scanner;

public class CalendarTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalendarYMD calendar = null;

        int option;
        do {
            System.out.println("\nCalendar operations:");
            System.out.println("1 - create new calendar");
            System.out.println("2 - print calendar month");
            System.out.println("3 - print calendar");
            System.out.println("0 - exit");
            System.out.print("Option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    System.out.print("First weekday of year (1=Sun ... 7=Sat): ");
                    int wd = sc.nextInt();
                    calendar = new CalendarYMD(year, wd);
                    System.out.println("Calendar created.");
                    break;

                case 2:
                    if (calendar != null) {
                        System.out.print("Month (1-12): ");
                        int m = sc.nextInt();
                        System.out.println(calendar.printMonth(m));
                    } else {
                        System.out.println("No calendar created.");
                    }
                    break;

                case 3:
                    if (calendar != null) {
                        System.out.println(calendar);
                    } else {
                        System.out.println("No calendar created.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 0);

        sc.close();
    }
}
