package aula03.TP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {
    public static void main(String args[]) {
        String[] str1 = {"Rui", "Manuel", "Jose", "Pires", "Eduardo", "Santos"};
        String[] str2 = {"Rosa", "Pereira", "Rui", "Vidal", "Hugo", "Maria"};
    
        List<String> larray = new ArrayList<>();
        List<String> llist = new LinkedList<>();
    
        for (String i : str1) larray.add(i);
        for (String i : str2) llist.add(i);

        llist.addAll(llist.size() / 2, larray);

        for (String ele : llist)
            System.out.println(ele);

        System.out.println("Rui está na posição " +
            llist.indexOf("Rui") + " e " + llist.lastIndexOf("Rui"));

        llist.set(llist.lastIndexOf("Rui"), "Rui2");

        System.out.println(llist.lastIndexOf("Rui"));
    }

}
