package aula07.Exercício1;

public class Triângulo extends Forma {
    private double lado1, lado2, lado3;

    public Triângulo(double lado1, double lado2, double lado3, String cor) {
        super(cor);  // Chama o construtor da classe pai Forma
        setLados(lado1, lado2, lado3);  // Inicializa os lados do triângulo
    } 

    private void setLados(double lado1, double lado2, double lado3) {
        if (!triânguloVálido(lado1, lado2, lado3)) {
            throw new IllegalArgumentException("Os lados fornecidos não formam um triângulo válido.");
        }
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    private boolean triânguloVálido(double lado1, double lado2, double lado3) {
        return (lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1);
    }

    public double getArea() {
        double s = (lado1 + lado2 + lado3) / 2;  // Semi-perímetro
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));  // Fórmula de Heron
    }

    public double getPerimeter() {
        return lado1 + lado2 + lado3;  // Perímetro do triângulo
    }


    @Override
    public String toString() {
        return "Triângulo{" +
                "lado1=" + lado1 +
                ", lado2=" + lado2 +
                ", lado3=" + lado3 +
                ", cor='" + cor + '\'' +
                ", área=" + getArea() +
                ", perímetro=" + getPerimeter() +
                '}';
    }
}
