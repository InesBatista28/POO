package aula06.Exercício3;

import java.util.HashSet;
import java.util.Set;

//guarda conjunto de números inteiros que não se repetem
public class Conjunto {
    private Set<Integer> elementos;

    public Conjunto() {
        elementos = new HashSet<>();
    }

    public void insert(int n) {
        elementos.add(n); //Com a utilização de HashSet, não há necessidade de verificar se o elemento já existe, pois ele não permitirá duplicatas.
    }

    public boolean contains(int n) {
        return elementos.contains(n);
    }

    public void remove(int n) {
        elementos.remove(n);
    }

    public int size() {
        return elementos.size();
    }

    public void empty() {
        elementos.clear();
    }
 
    public Conjunto combine(Conjunto add) {
        Conjunto resultado = new Conjunto();
        resultado.elementos.addAll(this.elementos);
        resultado.elementos.addAll(add.elementos);
        return resultado;
    }

    public Conjunto subtract(Conjunto dif) {
        Conjunto resultado = new Conjunto();
        resultado.elementos.addAll(this.elementos);
        resultado.elementos.removeAll(dif.elementos);
        return resultado;
    }

    public Conjunto interset(Conjunto inter) {
        Conjunto resultado = new Conjunto();
        for (int el : this.elementos) {  //escolhe um dos elementos do conjunto this 
            if (inter.contains(el)) {  //verifica se este está no conjunto inter 
                resultado.insert(el);  //se sim, este é adicionado ao resultado, já que faz parte da interseção dos dois 
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int n : elementos) {
            sb.append(n).append(" ");
        }
        return sb.toString().trim();
    }
}
