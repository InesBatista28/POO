package aula06.Exercício1;
import aula05.Exercício1.DateYMD;

public class Tester {
    public static void main(String[] args)  { 
    Aluno al = new Aluno ("Andreia Melo", 9855678, new DateYMD(18, 7, 1990), new DateYMD(1, 9, 2018)); 
    Professor p1 = new Professor("Jorge Almeida", 3467225, new DateYMD(13, 3, 1967), 
    "Associado", "Informática"); 
    Bolseiro bls = new Bolseiro ("Igor Santos", 8976543, new DateYMD(11, 5, 1985), new DateYMD(11, 5, 1985), p1, 900); 
    bls.setBolsa(1050); 
  
    System.out.println("Aluno: " + al.getNome()); 
    System.out.println(al); 
      
    System.out.println("Bolseiro: " + bls.getNome() + ", NMec: "  + bls.getNMec() + ", Bolsa: " +  bls.getBolsa() + ", Orientador: " +  bls.getOrientador()); 
    System.out.println(bls); 
    }
}
