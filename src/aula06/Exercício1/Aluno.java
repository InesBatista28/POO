package aula06.Exercício1;
import aula05.Exercício1.DateYMD;

public class Aluno extends Pessoa {
    private static int contadorNMec = 100; 
    private int nMec;
    private DateYMD dataInsc;

    public Aluno(String iNome, int iBI, DateYMD iDataNasc, DateYMD iDataInsc) {
        super(iNome, iBI, iDataNasc); //super == chama o construtor da classe Pessoa e garante os atributos herdados
        this.nMec = contadorNMec++; 
        this.dataInsc = new DateYMD(iDataInsc.getDay(), iDataInsc.getMonth(), iDataInsc.getYear()); 
    }   

    public int getNMec() {
        return nMec;
    }

    public DateYMD getDataInsc() {
        return new DateYMD(dataInsc.getDay(), dataInsc.getMonth(), dataInsc.getYear());
    }

    @Override
    public String toString() {
        return super.toString() + ", Nº Mec: " + nMec + ", Data de Inscrição: " + dataInsc;
    }
}
