package aula08.Exercício2;

public class A08E02 {
    public static void main(String[] args) {
        // Alimentos
        Peixe peixe1 = new Peixe("CONGELADO", 31.3, 25.3, 200.0);
        Carne carne1 = new Carne("FRANGO", 22.3, 345.3, 300.0);
        Cereal milho = new Cereal("Milho", 19.3, 32.4, 110.0);
        Legume couveFlor = new Legume("Couve Flor", 21.3, 22.4, 150.0);

        // Ementa
        Ementa ementa = new Ementa("Ementa semanal", "Cantina UA");

        // Prato 1
        Prato p1 = new Prato("combinado n.1");
        System.out.println("A sair .. " + p1);
        System.out.println(addIngrediente(p1, peixe1, 1));
        System.out.println(addIngrediente(p1, peixe1, 2));
        ementa.addPrato("Segunda", p1);

        // Prato 2
        Prato p2 = new Prato("combinado n.2");
        System.out.println("A sair .. " + p2);
        System.out.println(addIngrediente(p2, peixe1, 1));
        System.out.println(addIngrediente(p2, peixe1, 2));
        ementa.addPrato("Terca", p2);

        // Prato 3 - Vegetariano
        PratoVegetariano p3 = new PratoVegetariano("combinado n.3");
        System.out.println("A sair .. " + p3);
        System.out.println(addIngrediente(p3, peixe1, 1));
        System.out.println(addIngrediente(p3, milho, 1));
        System.out.println(addIngrediente(p3, peixe1, 2));
        System.out.println(addIngrediente(p3, peixe1, 2));
        System.out.println(addIngrediente(p3, couveFlor, 2));
        ementa.addPrato("Quarta", p3);

        // Prato 4 - Dieta
        PratoDieta p4 = new PratoDieta("combinado n.4", 50.0);
        System.out.println("A sair .. " + p4);
        System.out.println(addIngrediente(p4, carne1, 1));
        System.out.println(addIngrediente(p4, milho, 1));
        System.out.println(addIngrediente(p4, milho, 2));
        ementa.addPrato("Quinta", p4);

        // Prato 5 - Dieta
        PratoDieta p5 = new PratoDieta("combinado n.5", 90.0);
        System.out.println("A sair .. " + p5);
        System.out.println(addIngrediente(p5, peixe1, 1));
        System.out.println(addIngrediente(p5, peixe1, 2));
        System.out.println(addIngrediente(p5, peixe1, 2));
        System.out.println(addIngrediente(p5, milho, 2));
        ementa.addPrato("Sexta", p5);

        // Prato 6 - Vegetariano
        PratoVegetariano p6 = new PratoVegetariano("combinado n.6");
        System.out.println("A sair .. " + p6);
        System.out.println(addIngrediente(p6, carne1, 1));
        System.out.println(addIngrediente(p6, couveFlor, 1));
        System.out.println(addIngrediente(p6, milho, 2));
        ementa.addPrato("Sabado", p6);

        // Prato 7 - Vegetariano
        PratoVegetariano p7 = new PratoVegetariano("combinado n.7");
        System.out.println("A sair .. " + p7);
        System.out.println(addIngrediente(p7, peixe1, 1));
        System.out.println(addIngrediente(p7, carne1, 1));
        System.out.println(addIngrediente(p7, milho, 1));
        System.out.println(addIngrediente(p7, couveFlor, 2));
        ementa.addPrato("Domingo", p7);

        // Mostrar ementa final
        System.out.println();
        System.out.println(ementa);
    }

    private static String addIngrediente(Prato prato, Alimento alimento, int numero) {
        if (prato.addIngrediente(alimento)) {
            return " Ingrediente " + numero + " adicionado: " + alimento;
        } else {
            return " ERRO: não é possível adicionar Ingrediente " + numero + ": " + alimento;
        }
    }
}
