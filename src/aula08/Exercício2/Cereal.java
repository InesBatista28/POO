package aula08.Exercício2;
import java.util.Objects;

public class Cereal implements Alimento {
    private String nome;
    private double proteinas, calorias, peso;

    public Cereal(String nome, double proteinas, double calorias, double peso) {
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
        return "Cereal " + nome +
               ", Proteinas " + proteinas +
               ", calorias " + calorias +
               ", Peso " + peso;
    }

    public int hashCode() { return Objects.hash(nome, proteinas, calorias, peso); }
    public boolean equals(Object o) {
        if (!(o instanceof Cereal c)) return false;
        return nome.equals(c.nome) &&
               proteinas == c.proteinas &&
               calorias == c.calorias &&
               peso == c.peso;
    }
}
