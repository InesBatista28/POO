package aula06.Exercício1;
import aula05.Exercício1.DateYMD;

public class Bolseiro extends Aluno {
    private Professor orientador;
    private double montante;

    public Bolseiro(String nome, int cc, DateYMD dataNasc, DateYMD dataInsc, Professor orientador, double montante) {
        super(nome, cc, dataNasc, dataInsc);
        setOrientador(orientador);
        setBolsa(montante);
    }

    public void setOrientador(Professor orientador) {
        if (orientador == null) {
            throw new IllegalArgumentException("Orientador inválido.");
        }
        this.orientador = orientador;
    }

    public Professor getOrientador() {
        return orientador;
    }

    public void setBolsa(double montante) {
        if (montante < 0) {
            throw new IllegalArgumentException("Montante da bolsa não pode ser negativo.");
        }
        this.montante = montante;
    }

    public double getBolsa() {
        return montante;
    }

    @Override
    public String toString() {
        return super.toString() + "; Bolsa: " + montante + "€; Orientador: " + orientador.getNome();
    }
}
