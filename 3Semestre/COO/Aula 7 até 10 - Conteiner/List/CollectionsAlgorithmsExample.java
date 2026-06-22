// package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsAlgorithmsExample {

    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();

        numeros.add(5);
        numeros.add(1);
        numeros.add(4);
        numeros.add(2);
        numeros.add(3);

        System.out.println("Original:");
        System.out.println(numeros);

        Collections.sort(numeros);
        System.out.println("\nsort:");
        System.out.println(numeros);

        Collections.reverse(numeros);
        System.out.println("\nreverse:");
        System.out.println(numeros);

        Collections.rotate(numeros, 2);
        System.out.println("\nrotate:");
        System.out.println(numeros);

        Collections.swap(numeros, 0, 2);
        System.out.println("\nswap:");
        System.out.println(numeros);

        Collections.sort(numeros);

        System.out.println("\nbinarySearch(4):");
        System.out.println(Collections.binarySearch(numeros, 4));
    }
}