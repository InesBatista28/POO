package aula06.Exercício1;
import aula05.Exercício1.DateYMD;

public class Pessoa {
    private String nome;
    private int cc;
    private DateYMD dataNasc;

    public Pessoa(String nome, int cc, DateYMD dataNasc) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        if (cc <= 0) {
            throw new IllegalArgumentException("O CC deve ser um número positivo.");
        }
        if (dataNasc == null) {
            throw new IllegalArgumentException("A data de nascimento não pode ser nula.");
        }

        this.nome = nome;
        this.cc = cc;
        this.dataNasc = new DateYMD(dataNasc.getDay(), dataNasc.getMonth(), dataNasc.getYear());
    }

    public String getNome() {
        return nome;
    }

    public int getCc() {
        return cc;
    }

    public DateYMD getDataNasc() {
        return new DateYMD(dataNasc.getDay(), dataNasc.getMonth(), dataNasc.getYear());
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cc=" + cc + ", dataNasc=" + dataNasc + "]";
    }
}
