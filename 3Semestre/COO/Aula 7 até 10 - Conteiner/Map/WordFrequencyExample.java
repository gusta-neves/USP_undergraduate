// package collections.map;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyExample {

    public static void main(String[] args) {

        String texto =
                "if it is to be it is up to me to delegate";

        String[] palavras = texto.split(" ");

        Map<String, Integer> frequencias = new HashMap<>();

        for (String palavra : palavras) {

            Integer freq = frequencias.get(palavra);

            frequencias.put(palavra,
                    (freq == null) ? 1 : freq + 1);
        }

        System.out.println("Quantidade de palavras distintas:");
        System.out.println(frequencias.size());

        System.out.println("\nFrequência das palavras:");
        System.out.println(frequencias);
    }
}