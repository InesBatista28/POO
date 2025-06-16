package MT1.Parte2;

import java.util.LinkedList;

public class Roteador {
    private String nome;
    private LinkedList<Pacote> lista;
    private Pacote ultimoEnviado;

    public Roteador(String nome) {
        this.nome = nome;
        this.lista = new LinkedList<>();
        this.ultimoEnviado = null;
    }

    public void addPacote(Pacote p) {
        lista.add(p);
    }

    public void removePacote(Pacote p) {
        lista.remove(p);
    }

    public boolean hasPacotes() {
        return !lista.isEmpty();
    }

    public int getTamanhoFila() {
        return lista.stream().mapToInt(Pacote::getTamanho).sum();
    }

    public void enviaPacote() {
        if (!hasPacotes()) return;
    
        Pacote atual = lista.poll();
    
        if (ultimoEnviado != null && atual.equals(ultimoEnviado)) {
            System.out.println("(pacote duplicado)");
        } else {
            System.out.println(atual);
        }
    
        ultimoEnviado = atual;
    }
    

    @Override
    public String toString() {
        return "Encaminhador " + nome + " está UP, tamanhoFila=" + getTamanhoFila();
    }
}

