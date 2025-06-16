package MT1.Parte2;

public abstract class Pacote {
    protected String source;
    protected String destino;
    protected String mensagem;

    public Pacote (String source, String destino, String mensagem) {
        this.source = source;
        this.destino = destino;
        this.mensagem = mensagem;
    }

    public String getMensagem() { 
        return mensagem;
    }

    public abstract int getTamanho();
}