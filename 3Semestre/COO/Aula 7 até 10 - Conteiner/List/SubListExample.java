// package collections.list;

import java.util.ArrayList;
import java.util.List;

public class SubListExample {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();

        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("D");
        lista.add("E");

        System.out.println("Lista original:");
        System.out.println(lista);

        List<String> intervalo = lista.subList(1, 4);

        System.out.println("\nSubList:");
        System.out.println(intervalo);

        intervalo.clear();

        System.out.println("\nLista após clear() da subList:");
        System.out.println(lista);
    }
}
