// package collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapViewsExample {

    public static void main(String[] args) {

        Map<String, Integer> alunos = new HashMap<>();

        alunos.put("Ana", 8);
        alunos.put("Bruno", 10);
        alunos.put("Carlos", 7);

        System.out.println("Mapa:");
        System.out.println(alunos);

        System.out.println("\nkeySet():");
        System.out.println(alunos.keySet());

        System.out.println("\nvalues():");
        System.out.println(alunos.values());

        System.out.println("\nentrySet():");
        System.out.println(alunos.entrySet());
    }
}
