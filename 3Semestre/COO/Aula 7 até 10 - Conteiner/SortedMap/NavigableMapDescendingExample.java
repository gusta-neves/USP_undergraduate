// package collections.sortedmap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapDescendingExample {

    public static void main(String[] args) {

        NavigableMap<Integer, String> mapa = new TreeMap<>();

        mapa.put(10, "A");
        mapa.put(20, "B");
        mapa.put(30, "C");
        mapa.put(40, "D");

        System.out.println("Ordem crescente:");
        System.out.println(mapa);

        System.out.println("\ndescendingMap():");
        System.out.println(mapa.descendingMap());

        System.out.println("\ndescendingKeySet():");
        System.out.println(mapa.descendingKeySet());
    }
}