package MT1.Parte2;

public class TCP extends Pacote {
    private static int nextSeq = 100;  
    private int seq;  //Número de sequência a ser incrementado
    private static final int Max_Mensagem = 1460;  //Máximo de caracteres da mensagem

    public TCP(String source, String destination, String mensagem) {
        super(source, destination, mensagem);

        if (mensagem.length() > Max_Mensagem) {
            throw new IllegalArgumentException("A mensagem não deve execeder o número de " + Max_Mensagem + " caracteres.");
        }
        this.seq = nextSeq++;
    }

    
    
    @Override
    public int getTamanho() {  //Tamanho do pacote TCP é o tamanho da mensagem
        return mensagem.length();
    }

    @Override
    public String toString() {
        return "TCP (source=" + source + ", destination=" + destino + ") seq:" + seq + " msg: [" + mensagem + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TCP)) return false;
        TCP other = (TCP) obj;
        return source.equals(other.source) && destino.equals(other.destino) && mensagem.equals(other.mensagem) && seq == other.seq;  //Verifica se o número de sequência é igual  IMPORTANTE, FALA NAS OUTRAS CLASSES
    }
}

