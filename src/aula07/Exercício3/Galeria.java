package aula07.Exercício3;

import java.util.ArrayList;
import java.util.List;

//sempre que exercício pede para adicionar/remover/gerir == listas
public class Galeria {
    private final List<Obra> obras;

    public Galeria(int capacidadeInicial) {
        this.obras = new ArrayList<>(capacidadeInicial);
    }

    public void adicionarObra(Obra obra) {
        obras.add(obra);
    }

    public void listarObras() {
        if (obras.isEmpty()) {
            System.out.println("Não há obras na galeria.");
        } else {
            for (Obra obra : obras) {
                System.out.println(obra);
            }
        }
    }

    public boolean venderObra(int id, double precoVenda) {
        for (Obra obra : obras) {
            if (obra.getId() == id && !obra.isVendida()) {
                obra.vender(precoVenda);
                System.out.println("Obra vendida com sucesso: " + obra);
                return true;
            }
        }
        System.out.println("Obra não encontrada ou já vendida.");
        return false;
    }

    public double lucroTotal() {
        double lucroTotal = 0;
        for (Obra obra : obras) {
            if (obra.isVendida()) {
                lucroTotal += obra.getLucro();
            }
        }
        return lucroTotal;
    }
}
