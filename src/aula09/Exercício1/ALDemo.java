package aula09.Exercício1;

import java.util.ArrayList; 
import java.util.Collections; 
 
public class ALDemo { 
    public static void main(String[] args) { 
        ArrayList<Integer> c1 = new ArrayList<>(); 
        for (int i = 10; i <= 100; i+=10)  
            c1.add(i);
        System.out.println("Size: " + c1.size()); 
        for (int i = 0; i < c1.size(); i++)  
            System.out.println("Elemento: " + c1.get(i)); 
   
        ArrayList<String> c2 = new ArrayList<>(); 
        c2.add("Vento"); 
        c2.add("Calor"); 
        c2.add("Frio"); 
        c2.add("Chuva"); 
        System.out.println(c2); 
        Collections.sort(c2);    //Ordem alfabética
        System.out.println(c2); 
        c2.remove("Frio");  
        c2.remove(0);    //o elemento removido é o calor já que depois do sort a lista mantem essa ordem para as próximas iterações
        System.out.println(c2); 
    } 
}
