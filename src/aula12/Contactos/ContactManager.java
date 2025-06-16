package aula12.Contactos;

import java.io.*;
import java.util.*;

public class ContactManager {
    private Map<Integer, Contact> contacts = new HashMap<>();
    private Set<String> contactKeys = new HashSet<>(); //implica que não se repetem keys
    private double totalMinutes = 0;
    private int totalEmails = 0;

    private IContactCostCalculator calculator = new StandardCostCalculator();

    public void addContact(Contact c) {
        String key = c.getName() + "|" + c.getEmail();
        if (!contactKeys.contains(key)) {
            contacts.put(c.getId(), c);
            contactKeys.add(key);
        } else {
            System.out.println("Contacto duplicado: " + c.getName());
        }
    }

    public void removeContact(int id) {
        Contact removed = contacts.remove(id);
        if (removed != null) {
            contactKeys.remove(removed.getName() + "|" + removed.getEmail());
        }
    }

    public Contact getContact(int id) {
        return contacts.get(id);
    }

    public void sendEmail(int id) {
        if (contacts.containsKey(id)) {
            totalEmails++;
            System.out.println("Email enviado para: " + contacts.get(id).getName());
        } else {
            System.out.println("Contacto não encontrado!");
        }
    }

    public void call(int id, double minutes) {
        if (contacts.containsKey(id)) {
            totalMinutes += minutes;
            System.out.println("Chamada para: " + contacts.get(id).getName() + " durante " + minutes + " minutos.");
        } else {
            System.out.println("Contacto não encontrado!");
        }
    }

    public double calculateContactCost() {
        double cost = 0;
        cost += calculator.calculateCost(totalMinutes, IContactCostCalculator.ContactType.CELLNUMBER);
        cost += calculator.calculateCost(totalEmails, IContactCostCalculator.ContactType.EMAIL);
        return cost;
    }

    public void printAllContacts() {
        contacts.values().stream()
                .sorted(Comparator.comparing(Contact::getId))
                .forEach(System.out::println);
    }

    public void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    Contact c = new Contact(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
                    addContact(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
    }

    public void writeFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Contact c : contacts.values()) {
                writer.println(c.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever o ficheiro: " + e.getMessage());
        }
    }
}
