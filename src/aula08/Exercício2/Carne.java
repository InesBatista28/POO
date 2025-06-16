package aula08.Exercício2;
import java.util.Objects;

public class Carne implements Alimento {
    private String variedade;
    private double proteinas, calorias, peso;

    public Carne(String variedade, double proteinas, double calorias, double peso) {
        this.variedade = variedade;
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }

    public double getProteinas() { return (proteinas * peso) / 100.0; }
    public double getCalorias() { return (calorias * peso) / 100.0; }
    public double getPeso() { return peso; }
    public boolean isVegetariano() { return false; }

    public String toString() {
        return "Carne " + variedade.toUpperCase() +
               ", Proteinas " + proteinas +
               ", calorias " + calorias +
               ", Peso " + peso;
    }

    public int hashCode() { return Objects.hash(variedade, proteinas, calorias, peso); }
    public boolean equals(Object o) {
        if (!(o instanceof Carne c)) return false;
        return variedade.equals(c.variedade) &&
               proteinas == c.proteinas &&
               calorias == c.calorias &&
               peso == c.peso;
    }
}