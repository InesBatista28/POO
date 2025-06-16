package aula04.Exercício2;

import java.util.*;

class Product {
    //definição dos atributos privados 
    private String name;
    private double price;
    private int quantity;

    //construtor (incializa os atributos)
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int  getQuantity() {
        return quantity;
    }
}


class CashRegister {
    private static ArrayList<Product> productsList =  new ArrayList<Product>();

    public void addProduct(Product product) {
        productsList.add(product);  //adiciona o produto à lista 
    }

    public String toString() {
        String menu;
        double totalPrice = 0.0;

        //cabeçalho da tabela 
        menu = String.format("%-15s %8s %8s %10s\n", "Product", "Price", "Quantity", "Total");

        //percorre todos os objetos pertencentes à lista de produtos e adiciona os à tabela 
        for(Product product : productsList){
            menu += String.format("%-15s %8s %8s %10.5s\n",product.getName(), product.getPrice(), product.getQuantity(), product.getTotalValue());
            totalPrice += product.getTotalValue();
        }
        menu += "\nTotal value: " + totalPrice;
        return menu;
    }
}

public class CashRegisterDemo {

    public static void main(String[] args) {

        // Cria e adiciona 5 produtos
        CashRegister cr = new CashRegister();
        cr.addProduct(new Product("Book", 9.99, 3));
        cr.addProduct(new Product("Pen", 1.99, 10));
        cr.addProduct(new Product("Headphones", 29.99, 2));
        cr.addProduct(new Product("Notebook", 19.99, 5));
        cr.addProduct(new Product("Phone case", 5.99, 1));
        
        System.out.println(cr);
    }
}
