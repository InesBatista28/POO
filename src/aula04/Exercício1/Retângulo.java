package aula04.Exercício1;

public class Retângulo extends Figura {
    private double comprimento, altura;

    public Retângulo(double comprimento, double altura) {
         setComprimento(comprimento);
         setAltura(altura);
    }

    public double getAltura(){
        return altura;
    }
    
    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        if (comprimento <= 0) throw new IllegalArgumentException("O comprimento não pode ser nulo");
        this.comprimento = comprimento;
    }

    public void setAltura(double altura) {
        if (altura <= 0) throw new IllegalArgumentException("A altura não pode ser negativa");
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return comprimento * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (comprimento + altura);
    }

    @Override
    public String toString() {
        return String.format("Retângulo [comprimento=%.2f, altura=%.2f]", comprimento, altura);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Retângulo)) return false;
        Retângulo outro = (Retângulo) obj;
        return Double.compare(comprimento, outro.comprimento) == 0 &&
               Double.compare(altura, outro.altura) == 0;
    }
}
