// package collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapMassOperationsExample {

    public static void main(String[] args) {

        Map<String, String> defaults = new HashMap<>();

        defaults.put("tema", "Claro");
        defaults.put("idioma", "Português");

        Map<String, String> overrides = new HashMap<>();

        overrides.put("tema", "Escuro");

        Map<String, String> configuracoes =
                new HashMap<>(defaults);

        configuracoes.putAll(overrides);

        System.out.println("Configurações:");
        System.out.println(configuracoes);

        configuracoes.clear();

        System.out.println("\nApós clear():");
        System.out.println(configuracoes);
    }
}
