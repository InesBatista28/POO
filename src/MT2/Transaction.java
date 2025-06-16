//Inês Batista 124877

package MT2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private static int nextId = 1;

    private int id;
    private double horasTrabalho;
    private String descricao;
    private LocalDateTime dataHora;

    public Transaction(String descricao, String dataHoraStr, double horasTrabalho) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.id = nextId++;
        this.descricao = descricao;
        this.dataHora = LocalDateTime.parse(dataHoraStr, formatter);
        this.horasTrabalho = horasTrabalho;
    }


    public Transaction(int id, String descricao, LocalDateTime dataHora, double horasTrabalho) {
        this.id = id;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.horasTrabalho =horasTrabalho;

        if(id >= nextId) { 
            nextId = id + 1;
        }
    }

    public int getId() {
        return id;
    }

    public double getHorasTrabalho() {
        return horasTrabalho;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public static int getNextId() {
        return nextId;
    }

    public void setHorasTrabalho(double horasTrabalho) {
        this.horasTrabalho = horasTrabalho;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    // public void setDescricap == dizia que não era necessario no output 

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("ID: %d ; Horas: %.2f ; Serviço: %s ; Data/Hora: %s",
                id, horasTrabalho, descricao, dataHora.format(formatter));
    }

    public static void setNextId(int novoId) {
        if (novoId > nextId) {
            nextId = novoId;
        }
    }
}
