package aula07.Exercício3;

public class Escultura extends Obra {
    private String material;
    private final int exemplares;

    public Escultura(String nome, String autor, double preçoBase, String material, int exemplares) {
        super(nome, autor, preçoBase);
        this.material = material;
        this.exemplares = exemplares;
    }

    @Override
    public String toString() {
        return String.format("Escultura{id=%d, nome='%s', autor='%s', preçoBase=%.2f, vendida=%b, precoVenda=%.2f, material='%s', exemplares=%d}",
                getId(), getNome(), getAutor(), getPreçoBase(), isVendida(), getLucro(), material, exemplares);
    }
}
