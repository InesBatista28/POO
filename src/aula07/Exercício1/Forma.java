package aula07.Exercício1;

public abstract class Forma {
    protected String cor;
    public Forma(String cor) {
        this.cor = cor;  // Inicialização da cor
    }
    public abstract double getPerimeter();
    public abstract double getArea();
    public String getCor() {
        return cor;
    }
}
