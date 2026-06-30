// package collections.sortedmap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapNavigationExample {

    public static void main(String[] args) {

        NavigableMap<Integer, String> mapa = new TreeMap<>();

        mapa.put(10, "A");
        mapa.put(20, "B");
        mapa.put(30, "C");
        mapa.put(40, "D");

        System.out.println("lowerKey(20):");
        System.out.println(mapa.lowerKey(20));

        System.out.println("\nfloorKey(25):");
        System.out.println(mapa.floorKey(25));

        System.out.println("\nceilingKey(25):");
        System.out.println(mapa.ceilingKey(25));

        System.out.println("\nhigherKey(20):");
        System.out.println(mapa.higherKey(20));
    }
}