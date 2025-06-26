//Inês Batista 124877

package TestePráticoFinal.src.TestePrático;
import java.time.LocalDateTime;

public class Concert {
    private double duracao;
    private String local;
    private LocalDateTime dataHora;
    private int id;

    public Concert(int id, double duracao, String local, LocalDateTime dataHora) {
        this.id = id;
        this.duracao = duracao;
        this.local = local;
        this.dataHora = dataHora;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Concert [duracao=" + duracao + ", local=" + local + ", dataHora=" + dataHora + ", id=" + id + "]";
    }
}
