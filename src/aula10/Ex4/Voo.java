package aula10.Ex4;

public class Voo {
    private String hora;
    private String codigo;
    private String companhia;
    private String origem;
    private String atraso;

    public Voo(String hora, String codigo, String companhia, String origem, String atraso) {
        this.hora = hora;
        this.codigo = codigo;
        this.companhia = companhia;
        this.origem = origem;
        this.atraso = atraso;
    }

    public boolean temAtraso() {
        return atraso != null && !atraso.isEmpty();
    }

    public int getAtrasoMinutos() {
        if (!temAtraso()) return 0;
        String[] partes = atraso.split(":");
        return Integer.parseInt(partes[0]) * 60 + Integer.parseInt(partes[1]);
    }

    public String getCompanhia() {
        return companhia;
    }

    public String getOrigem() {
        return origem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s %-8s %-25s %-20s", hora, codigo, companhia, origem));

        if (temAtraso()) {
            int totalMin = getHoraMinutos() + getAtrasoMinutos();
            int nh = (totalMin / 60) % 24;
            int nm = totalMin % 60;
            String previsto = String.format("Previsto: %d:%02d", nh, nm);
            sb.append(String.format("%-7s %s", atraso, previsto));
        }
        return sb.toString();
    }

    private int getHoraMinutos() {
        String[] partes = hora.split(":");
        return Integer.parseInt(partes[0]) * 60 + Integer.parseInt(partes[1]);
    }
}

