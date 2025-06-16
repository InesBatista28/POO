package aula10.Ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnergyUsageReport {
    private List<Customer> customers;
    
    public EnergyUsageReport() {
        this.customers = new ArrayList<>();
    }

    public void load() {
        String filename = "C:\\Users\\iness\\OneDrive\\Ambiente de Trabalho\\Engenharia Informática\\1ºAno\\2ºSemestre\\POO\\src\\aula10\\Ex3\\clients.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line; 
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                List<Double> usage = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    usage.add(Double.parseDouble(parts[i]));
                }
                System.out.println("ID: " + id);
                System.out.println("Usage: " + usage);

                Customer customer = new Customer(id, usage, "Desconhecido");
                this.customers.add(customer);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
        System.out.println("Customer added: " + customer.getCustomerId());
    }

    public void removeCustomer(int customerId) {
        for (Customer customer : this.customers) {
            if (customer.getCustomerId() == customerId) {
                this.customers.remove(customer);
                break;
            }
        }
        System.out.println("Customer removed: " + customerId);
    }

    public Customer getCustomer(int customerId) {
        for (Customer customer : this.customers) {
            if (customer.getCustomerId() == customerId) {
                System.out.println("Customer got: " + customer.getCustomerId());
                return customer;
            }
        }
        return null;
    }

    public double calculateTotalUsage(int customerId) {
        for (Customer customer : this.customers) {
            if (customer.getCustomerId() == customerId) {
                double total = 0.0;
                for (Double usage : customer.getMeterReadings()) {
                    total += usage;
                }
                return total;
            }
        }
        return 0.0;
    }

    public void generateReport(String filename) {
        for (Customer customer : this.customers) {
            System.out.println("ID: " + customer.getCustomerId());
            System.out.println("Usage: " + customer.getMeterReadings());
            System.out.println("Total: " + calculateTotalUsage(customer.getCustomerId()));
        }
    }
}
