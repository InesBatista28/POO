package aula08.Exercício1;

public class Atleta implements IKmPercorridos {
    private String nome;
    private int ultimoTreino, totalKms;

    public Atleta(String nome, int ultimoTreino, int totalKms)  {
        this.nome = nome;
        this.ultimoTreino = 0;
        this.totalKms = 0;
    }

    public void trajeto(int quilometros) {
        this.ultimoTreino = quilometros;
        this.totalKms += quilometros;
    }

    public int ultimoTrajeto() {return ultimoTreino; }
    public int distanciaTotal() {return totalKms; }

    @Override
    public String toString() {
        return "Atleta [nome=" + nome + ", ultimoTreino=" + ultimoTreino + ", totalKms=" + totalKms + "]";
    }
}
