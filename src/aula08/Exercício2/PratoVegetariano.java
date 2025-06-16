package aula08.Exercício2;

public class PratoVegetariano extends Prato {

    public PratoVegetariano(String nome) {
        super(nome);
    }

    @Override
    public boolean addIngrediente(Alimento a) {
        if (!a.isVegetariano()) return false;
        return super.addIngrediente(a);
    }

    @Override
    public String toString() {
        return super.toString() + " - Prato Vegetariano";
    }
}

