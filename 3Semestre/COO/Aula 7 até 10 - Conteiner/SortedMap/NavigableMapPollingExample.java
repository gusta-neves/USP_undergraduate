// package collections.sortedmap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapPollingExample {

    public static void main(String[] args) {

        NavigableMap<Integer, String> mapa = new TreeMap<>();

        mapa.put(10, "A");
        mapa.put(20, "B");
        mapa.put(30, "C");
        mapa.put(40, "D");

        System.out.println("Mapa:");
        System.out.println(mapa);

        System.out.println("\npollFirstEntry():");
        System.out.println(mapa.pollFirstEntry());

        System.out.println("\nApós remover o primeiro:");
        System.out.println(mapa);

        System.out.println("\npollLastEntry():");
        System.out.println(mapa.pollLastEntry());

        System.out.println("\nApós remover o último:");
        System.out.println(mapa);
    }
}