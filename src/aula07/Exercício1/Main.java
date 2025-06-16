package aula07.Exercício1;

public class Main {
    public static void main(String[] args) {
        // Criar formas geométricas
        Forma[] formas = new Forma[3];
        
        formas[0] = new Triângulo(3, 4, 5, "vermelho");
        formas[1] = new Círculo(2.5, "azul");
        formas[2] = new Retângulo(4.0, 6, "verde");

        // Imprimir detalhes de cada forma
        for (Forma f : formas) {
            System.out.println(f);
        }
    }
}

