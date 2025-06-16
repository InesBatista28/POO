package aula07.Exercício3;

public class ObraDigital extends Obra {
    private String blockchain;
    private String contacto;

    public ObraDigital(String nome, String autor, double preçoBase, String blockchain, String contacto) {
        super(nome, autor, preçoBase);
        this.blockchain = blockchain;
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return String.format("ObraOriginal{id=%d, nome='%s', autor='%s', preçoBase=%.2f, vendida=%b, precoVenda=%.2f, blockchain='%s', contacto='%s'}",
                getId(), getNome(), getAutor(), getPreçoBase(), isVendida(), getLucro(), blockchain, contacto);
    }
    
}
