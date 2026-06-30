// package collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapImplementationsExample {

    public static void main(String[] args) {

        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        hashMap.put("Carlos", 10);
        hashMap.put("Ana", 8);
        hashMap.put("Bruno", 9);

        treeMap.put("Carlos", 10);
        treeMap.put("Ana", 8);
        treeMap.put("Bruno", 9);

        linkedHashMap.put("Carlos", 10);
        linkedHashMap.put("Ana", 8);
        linkedHashMap.put("Bruno", 9);

        System.out.println("HashMap:");
        System.out.println(hashMap);

        System.out.println("\nTreeMap:");
        System.out.println(treeMap);

        System.out.println("\nLinkedHashMap:");
        System.out.println(linkedHashMap);

        System.out.println("\nAtualizando o valor da chave \"Ana\":");
        hashMap.put("Ana", 10);
        System.out.println(hashMap);
    }
}
