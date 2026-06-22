// package collections.list;

import java.util.ArrayList;
import java.util.List;

public class ListAccessExample {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();

        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");
        nomes.add("Ana");

        System.out.println(nomes);

        System.out.println("\nget(1):");
        System.out.println(nomes.get(1));

        System.out.println("\nset(1, Maria):");
        System.out.println("Valor substituído: " + nomes.set(1, "Maria"));
        System.out.println(nomes);

        System.out.println("\nadd(2, Pedro):");
        nomes.add(2, "Pedro");
        System.out.println(nomes);

        System.out.println("\nremove(0):");
        System.out.println("Removido: " + nomes.remove(0));
        System.out.println(nomes);

        System.out.println("\nindexOf(Ana):");
        System.out.println(nomes.indexOf("Ana"));

        System.out.println("\nlastIndexOf(Ana):");
        System.out.println(nomes.lastIndexOf("Ana"));
    }
}
