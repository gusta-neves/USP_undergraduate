// package collections.sortedmap;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapRangeExample {

    public static void main(String[] args) {

        SortedMap<Integer, String> mapa = new TreeMap<>();

        mapa.put(10, "A");
        mapa.put(20, "B");
        mapa.put(30, "C");
        mapa.put(40, "D");
        mapa.put(50, "E");

        System.out.println("Mapa completo:");
        System.out.println(mapa);

        System.out.println("\nheadMap(30):");
        System.out.println(mapa.headMap(30));

        System.out.println("\ntailMap(30):");
        System.out.println(mapa.tailMap(30));

        System.out.println("\nsubMap(20, 50):");
        System.out.println(mapa.subMap(20, 50));
    }
}