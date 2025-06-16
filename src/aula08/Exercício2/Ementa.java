package aula08.Exercício2;
import java.util.*;

public class Ementa {
    private String nome, local;
    private Map<String, Prato> pratosPorDia;

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;
        this.pratosPorDia = new LinkedHashMap<>();
    }

    public void addPrato(String dia, Prato prato) {
        pratosPorDia.put(dia, prato);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Ementa final\n--------------------\n");
        for (var entry : pratosPorDia.entrySet()) {
            sb.append(entry.getValue().toString()).append(", dia ").append(entry.getKey()).append("\n");
        }
        return sb.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    
}
