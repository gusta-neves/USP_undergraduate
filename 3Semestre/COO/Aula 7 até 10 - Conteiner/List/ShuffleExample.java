// package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleExample {

    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }

        System.out.println("Original:");
        System.out.println(numeros);

        Collections.shuffle(numeros);

        System.out.println("\nEmbaralhada:");
        System.out.println(numeros);
    }
}