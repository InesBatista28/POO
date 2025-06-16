package aula08.Exercício3;

public class ProdutoDescontos extends ProdutoGenerico {
    private double desconto;

    public ProdutoDescontos(String nome, int quantidade, int preco, double desconto) {
        super(nome, quantidade, preco);
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPreco() {
        return super.getPreco() * (1 - desconto / 100.0);
    }
}
