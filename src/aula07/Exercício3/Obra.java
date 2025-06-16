package aula07.Exercício3;

//Obra de arte genérica == abstract class 
public abstract class Obra {
    private String nome, autor;
    private double preçoBase;
    private final int id; 
    public static int nextId = 33; 
       
    private double precoVenda = -1;

    public Obra(String nome, String autor, double preçoBase) {
        this.nome = nome;
        this.autor = autor;
        this.preçoBase = preçoBase;
        this.id = nextId++;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreçoBase() {
        return preçoBase;
    }

    public int getId() {
        return id;
    }

    public void vender(double precoVenda) {
        if (this.precoVenda != -1) {
            throw new IllegalStateException("Obra já vendida.");
        }
        this.precoVenda = precoVenda;
    }

    public boolean isVendida() {
        return precoVenda != -1;
    }

    public double getLucro() {
        return isVendida() ? precoVenda - preçoBase : 0;
    }

    @Override
    public String toString() {
        return String.format("Obra{id=%d, nome='%s', autor='%s', preçoBase=%.2f, vendida=%b, precoVenda=%.2f}",
                id, nome, autor, preçoBase, isVendida(), precoVenda);
    } 
}
