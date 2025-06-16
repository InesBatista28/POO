package aula04.Exercício1;

public class Círculo extends Figura {
    private double raio;

    public Círculo(double raio) {
        setRaio(raio);
    }

    public double getRaio() {  //getter
        return raio;
    }

    public void setRaio(double raio) {  //setter 
        if (raio <= 0) throw new IllegalArgumentException("Raio deve ser positivo.");
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * (raio * raio); 
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }

    @Override
    public String toString() {
        return String.format("Círculo [raio=%.2f]", raio);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  //Verifica se são o mesmo objeto na memória
         if (!(obj instanceof Círculo)) return false;  //Verifica se o outro objeto é um instância da mesma classe 
        Círculo outro = (Círculo) obj;  //Converte o objeto para o Círculo
        return Double.compare(raio, outro.raio) == 0;  //Compara os raios com precisão de ponto flutuante
    }
}
