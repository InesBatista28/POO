package aula08.Exercício2;
import java.util.*;

public class Prato implements Comparable<Prato> {
    protected String nome;
    protected List<Alimento> ingredientes;

    public Prato(String nome) {
        this.nome = nome;
        this.ingredientes = new ArrayList<>();
    }

    public boolean addIngrediente(Alimento a) {
        ingredientes.add(a);
        return true;
    }

    public double getTotalPeso() {
        return ingredientes.stream().mapToDouble(Alimento::getPeso).sum();
    }

    public double getTotalCalorias() {
        return ingredientes.stream().mapToDouble(Alimento::getCalorias).sum();
    }

    public double getTotalProteinas() {
        return ingredientes.stream().mapToDouble(Alimento::getProteinas).sum();
    }

    public String toString() {
        return "Prato '" + nome + "', composto por " + ingredientes.size() + " Ingredientes";
    }

    public int hashCode() { return Objects.hash(nome, ingredientes); }

    public boolean equals(Object o) {
        if (!(o instanceof Prato p)) return false;
        return nome.equals(p.nome) && ingredientes.equals(p.ingredientes);
    }

    public int compareTo(Prato outro) {
        return Double.compare(this.getTotalCalorias(), outro.getTotalCalorias());
    }
}

