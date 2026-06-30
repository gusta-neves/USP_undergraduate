// package collections.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapValidationExample {

    public static void main(String[] args) {

        Map<String, String> atributos = new HashMap<>();

        atributos.put("nome", "João");
        atributos.put("idade", "20");
        atributos.put("cpf", "123456");

        Set<String> obrigatorios = new HashSet<>();

        obrigatorios.add("nome");
        obrigatorios.add("idade");
        obrigatorios.add("email");

        Set<String> permitidos = new HashSet<>();

        permitidos.add("nome");
        permitidos.add("idade");
        permitidos.add("email");
        permitidos.add("telefone");

        Set<String> chaves = atributos.keySet();

        if (!chaves.containsAll(obrigatorios)) {

            Set<String> faltando =
                    new HashSet<>(obrigatorios);

            faltando.removeAll(chaves);

            System.out.println("Atributos obrigatórios ausentes:");
            System.out.println(faltando);
        }

        if (!permitidos.containsAll(chaves)) {

            Set<String> invalidos =
                    new HashSet<>(chaves);

            invalidos.removeAll(permitidos);

            System.out.println("\nAtributos inválidos:");
            System.out.println(invalidos);
        }
    }
}
