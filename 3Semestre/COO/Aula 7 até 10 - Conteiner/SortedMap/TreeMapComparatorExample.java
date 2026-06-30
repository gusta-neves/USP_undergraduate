// package collections.sortedmap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapComparatorExample {

    public static void main(String[] args) {

        Map<String, Integer> mapa =
                new TreeMap<>(Comparator.reverseOrder());

        mapa.put("Ana", 8);
        mapa.put("Carlos", 10);
        mapa.put("Bruno", 9);

        System.out.println("Ordenação reversa:");
        System.out.println(mapa);
    }
}