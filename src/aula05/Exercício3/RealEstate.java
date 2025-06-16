package aula05.Exercício3;
import java.util.*;
import aula05.Exercício1.DateYMD;

public class RealEstate {
    private ArrayList<Property> properties = new ArrayList<>();

    public void newProperty(String location, int rooms, int price) {
        properties.add(new Property(location, rooms, price));
    }

    public void sell(int id) {
        Property p = findProperty(id);
        if (p != null) {
            p.sell();
        } else {
            System.out.println("Imóvel já vendido. Não disponível.");
        }
    }

    private Property findProperty(int id) {
        for (Property p : properties) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void setAuction(int id, DateYMD start, int duration) {
        Property p = findProperty(id);
        if (p != null) {
            p.setAuction(start, duration);
        } else {
            System.out.println("Imóvel " + id + " não existe.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Propriedades:\n");
        for (Property p : properties) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }
}
