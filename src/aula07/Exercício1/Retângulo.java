package aula07.Exercício1;

public class Retângulo extends Forma {
    private double largura, altura;
    private String cor;

    public Retângulo(double largura, double altura, String cor) {
        super(cor);  // Chama o construtor da superclasse Forma
        if (largura <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Largura e altura devem ser positivas.");
        }
        this.largura = largura;
        this.altura = altura;
    }

    public double getLargura() {
        return largura;  // Retorna a largura do retângulo
    }

    public double getAltura() {
        return altura;  // Retorna a altura do retângulo
    }

    public double getArea() {
        return largura * altura;  // Calcula a área do retângulo
    }

    public double getPerimeter() {
        return 2 * (largura + altura);  // Calcula o perímetro do retângulo
    }

    @Override
    public String toString() {
        return "Retângulo{" +
                "largura=" + largura +
                ", altura=" + altura +
                ", cor='" + cor + '\'' +
                ", área=" + getArea() +
                ", perímetro=" + getPerimeter() +
                '}';
    }
}
