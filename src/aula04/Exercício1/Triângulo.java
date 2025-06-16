package aula04.Exercício1;

public class Triângulo extends Figura {
    private double lado1, lado2, lado3;

    public Triângulo(double lado1, double lado2, double lado3) {
        setLados(lado1, lado2, lado3);
    }

    public void setLados (double lado1, double lado2, double lado3) {
        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            throw new IllegalArgumentException("Todos os lados devem ser positivos");
        }
        if (!validarTriangulo(lado1, lado2, lado3)) {
            throw new IllegalArgumentException("Os lados não satisfazem a desigualdade triangular");
        }
    }

    private boolean validarTriangulo(double a, double b, double c) {
        return (a+b > c) && (a+c > b) && (b+c > a);
    }

    public double getLado1() { return lado1; }
    public double getLado2() { return lado2; }
    public double getLado3() { return lado3; }

    @Override 
    public double calcularArea() {
        double s = calcularPerimetro() / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3)); // Fórmula de Heron
    }

    @Override 
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override 
    public String toString() {
        return String.format("Triângulo [lados=%.2f, %.2f, %.2f]", lado1, lado2, lado3);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Triângulo)) return false;
        Triângulo outro = (Triângulo) obj;
        double[] lados1 = {lado1, lado2, lado3};
        double[] lados2 = {outro.lado1, outro.lado2, outro.lado3};
        java.util.Arrays.sort(lados1);
        java.util.Arrays.sort(lados2);
        return java.util.Arrays.equals(lados1, lados2);
    }
}
