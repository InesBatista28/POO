package aula08.Exercício3;
import java.util.*;

public class CarrinhoCompras implements Compra {
    private List<Produto> produtos;

    public CarrinhoCompras() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (produtos.contains(produto)) {
            int index = produtos.indexOf(produto);
            Produto produtoExistente = produtos.get(index);
            produtoExistente.adicionarQuantidade(quantidade);
        } else {
            produto.adicionarQuantidade(quantidade);
            produtos.add(produto);
        }
    }

    public void listarProdutos() {
        System.out.println("Produtos no carrinho:");
        for (Produto produto : produtos) {
            System.out.println(produto.getNome() + " - " + produto.getQuantidade() + " unidades");
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        return total;
    }
}
