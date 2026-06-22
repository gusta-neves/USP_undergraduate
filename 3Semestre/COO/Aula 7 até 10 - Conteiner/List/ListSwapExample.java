// package collections.list;

import java.util.ArrayList;
import java.util.List;

public class ListSwapExample {

    public static <E> void swap(List<E> a, int i, int j) {

        E tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();

        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");

        System.out.println("Antes:");
        System.out.println(nomes);

        swap(nomes, 0, 2);

        System.out.println("\nDepois:");
        System.out.println(nomes);
    }
}
