package aula08.Exercício2;
import java.util.Objects;

public class Legume implements Alimento {
    private String nome;
    private double proteinas, calorias, peso;

    public Legume(String nome, double proteinas, double calorias, double peso) {
        this.nome = nome;
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }

    public double getProteinas() { return (proteinas * peso) / 100.0; }
    public double getCalorias() { return (calorias * peso) / 100.0; }
    public double getPeso() { return peso; }
    public boolean isVegetariano() { return true; }

    public String toString() {
        return "Legume " + nome +
               ", Proteinas " + proteinas +
               ", calorias " + calorias +
               ", Peso " + peso;
    }

    public int hashCode() { return Objects.hash(nome, proteinas, calorias, peso); }
    public boolean equals(Object o) {
        if (!(o instanceof Legume l)) return false;
        return nome.equals(l.nome) &&
               proteinas == l.proteinas &&
               calorias == l.calorias &&
               peso == l.peso;
    }
}

