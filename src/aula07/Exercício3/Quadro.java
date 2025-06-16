package aula07.Exercício3;

//representa um tipo de obra == extends Obra
public class Quadro extends Obra {
    private String tipoTinta;
    private boolean emoldurado;
    private String tamanho;

    public Quadro(String nome, String autor, double preçoBase, String tipoTinta, boolean emoldurado, String tamanho) {
        super(nome, autor, preçoBase);
        this.tipoTinta = tipoTinta;
        this.emoldurado = emoldurado;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return String.format("Quadro{id=%d, nome='%s', autor='%s', preçoBase=%.2f, vendida=%b, precoVenda=%.2f, tipoTinta='%s', emoldurado=%b, tamanho='%s'}",
                getId(), getNome(), getAutor(), getPreçoBase(), isVendida(), getLucro(), tipoTinta, emoldurado, tamanho);
    }
}
