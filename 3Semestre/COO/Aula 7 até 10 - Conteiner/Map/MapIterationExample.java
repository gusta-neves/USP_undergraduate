// package collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapIterationExample {

    public static void main(String[] args) {

        Map<String, Integer> alunos = new HashMap<>();

        alunos.put("Ana", 8);
        alunos.put("Bruno", 10);
        alunos.put("Carlos", 7);

        System.out.println("Percorrendo pelas chaves:");

        for (String chave : alunos.keySet()) {
            System.out.println(chave);
        }

        System.out.println("\nPercorrendo pelos valores:");

        for (Integer valor : alunos.values()) {
            System.out.println(valor);
        }

        System.out.println("\nPercorrendo pelos pares chave-valor:");

        for (Map.Entry<String, Integer> entry : alunos.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
