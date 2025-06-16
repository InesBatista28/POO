package aula07.Exercício1;

public class Círculo extends Forma {
    private double raio;

    public Círculo(double raio, String cor) {
        super(cor);  // Chama o construtor da classe pai Forma
        this.raio = raio;  // Inicializa o raio do círculo
    }
    
    private double getRaio(){
        return this.raio;
    }
    public double getArea(){
        return Math.PI * getRaio() * getRaio();
    }
    public double getPerimeter(){
        return 2 * Math.PI * getRaio() ;
    }

    @Override
    public String toString() {
        return "Círculo{" +
                "raio=" + raio +
                ", cor='" + cor + '\'' +
                ", área=" + getArea() +
                ", perímetro=" + getPerimeter() +
                '}';
    }
}
