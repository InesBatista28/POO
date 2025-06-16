package aula08.Exercício2;

public class PratoDieta extends Prato {
    private double maxCalorias;

    public PratoDieta(String nome, double maxCalorias) {
        super(nome);
        this.maxCalorias = maxCalorias;
    }

    @Override
    public boolean addIngrediente(Alimento a) {
        if (getTotalCalorias() + a.getCalorias() > maxCalorias)
            return false;
        return super.addIngrediente(a);
    }

    @Override
    public String toString() {
        return super.toString() + " - Dieta (" + String.format("%.2f", getTotalCalorias()) + " Calorias)";
    }
}
