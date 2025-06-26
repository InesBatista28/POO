package MT1.Parte2;

public class UDP extends Pacote{
    public UDP(String source, String destination, String mensagem) {
        super(source, destination, mensagem);
    }

    @Override
    public int getTamanho() {
        return mensagem.length();
    }

    @Override
    public String toString() {
        return "UDP (source=" + source + ", destination=" + destino + ") msg: [" + mensagem + "]";  //UDP sem número de sequência 
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UDP)) return false;
        UDP other = (UDP) obj;
        return source.equals(other.source) && destino.equals(other.destino) && mensagem.equals(other.mensagem);
    }
}
