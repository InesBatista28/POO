package aula04.Exercício1;

public abstract class Figura {
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    @Override
    public abstract String toString();
    
    @Override
    public abstract boolean equals(Object obj);
}
