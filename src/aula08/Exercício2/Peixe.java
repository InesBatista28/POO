package aula08.Exercício2;
import java.util.Objects;

public class Peixe implements Alimento {
    private String tipo; // FRESCO ou CONGELADO
    private double proteinas, calorias, peso;

    public Peixe(String tipo, double proteinas, double calorias, double peso) {
        this.tipo = tipo;
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }

    public double getProteinas() { return (proteinas * peso) / 100.0; }
    public double getCalorias() { return (calorias * peso) / 100.0; }
    public double getPeso() { return peso; }
    public boolean isVegetariano() { return false; }

    public String toString() {
        return "Peixe " + tipo.toUpperCase() +
               ", Proteinas " + proteinas +
               ", calorias " + calorias +
               ", Peso " + peso;
    }

    public int hashCode() { return Objects.hash(tipo, proteinas, calorias, peso); }
    public boolean equals(Object o) {
        if (!(o instanceof Peixe p)) return false;
        return tipo.equals(p.tipo) &&
               proteinas == p.proteinas &&
               calorias == p.calorias &&
               peso == p.peso;
    }
}
