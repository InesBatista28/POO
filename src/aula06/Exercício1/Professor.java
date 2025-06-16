package aula06.Exercício1;
import aula05.Exercício1.DateYMD;

public class Professor extends Pessoa {
    private String categoria;
    private String departamento;

    public Professor(String nome, int cc, DateYMD dataNasc, String categoria, String departamento) {
        super(nome, cc, dataNasc);
    }

    @Override
    public String toString() {
        return super.toString() + "; Categoria: " + categoria + "; Departamento: " + departamento;
    }   
}
