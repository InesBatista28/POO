package aula08.Exercício1;

public interface IGestaoBateria {
    double cargaDisponivel();
    void carregar(double percentagem);
    void limitarCargaMaxima(double percentagem);
}
