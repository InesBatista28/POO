package aula05.Exercício3;
import aula05.Exercício1.*;

public class Property {
    private static int nextId = 1000;

    private final int id;
    private int rooms;
    private String location;
    private int price;
    private boolean available;
    private DateYMD startDate;
    private DateYMD endDate;

    public Property(String location, int rooms, int price) {
        this.id = nextId++;
        this.location = location;
        this.rooms = rooms;
        this.price = price;
        this.available = true;
        this.startDate = null;
        this.endDate = null;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void sell() {
        if (available) {
            available = false;
            System.out.println("Imóvel " + id + " vendido.");
        } else {
            System.out.println("Imóvel " + id + " não está disponível.");
        }
    }

    public void setAuction(DateYMD start, int duration) {
        if (!available) {
            System.out.println("Imóvel " + id + " não está disponível.");
            return;
        }
        this.startDate = start;
        // Simples incremento do dia como se todos os meses tivessem dias suficientes (não é realista, mas suficiente para o exercício)
        this.endDate = new DateYMD(start.getDay() + duration - 1, start.getMonth(), start.getYear()); // ✅
    }

    public String toString() {
        String s = String.format("Imóvel: %d; quartos: %d; localidade: %s; preço: %d; disponível: %s",
            id, rooms, location, price, available ? "sim" : "não");

        if (startDate != null && endDate != null) {
            s += String.format("; leilão %s : %s", startDate, endDate);
        }

        return s;
    }
}
