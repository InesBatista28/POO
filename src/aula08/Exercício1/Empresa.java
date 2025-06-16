package aula08.Exercício1;
import java.util.*;

public class Empresa {
    private String nome;
    private int codPostal;
    private String email;
    private List<Veiculo> veiculos;

    public Empresa(String nome, int codPostal, String email) {
        this.nome = nome;
        this.codPostal = codPostal;
        this.email = email;
        this.veiculos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public String getEmail() {
        return email;
    }

    public void adicionarVeiculos(Veiculo v) {
        veiculos.add(v);
    }

    public Veiculo viaturaMaisKms() {
        return Collections.max(veiculos, Comparator.comparingInt(Veiculo::distanciaTotal));
    }

    public List<Veiculo> getViaturas() { return veiculos; }
}
