// package collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapBasicOperationsExample {

    public static void main(String[] args) {

        Map<Integer, String> alunos = new HashMap<>();

        alunos.put(1, "Ana");
        alunos.put(2, "Bruno");
        alunos.put(3, "Carlos");

        System.out.println(alunos);

        System.out.println("\nget(2):");
        System.out.println(alunos.get(2));

        System.out.println("\ncontainsKey(3):");
        System.out.println(alunos.containsKey(3));

        System.out.println("\ncontainsValue(\"Ana\"):");
        System.out.println(alunos.containsValue("Ana"));

        System.out.println("\nremove(2):");
        System.out.println(alunos.remove(2));

        System.out.println("\nApós remover:");
        System.out.println(alunos);

        System.out.println("\nsize():");
        System.out.println(alunos.size());

        System.out.println("\nisEmpty():");
        System.out.println(alunos.isEmpty());
    }
}
