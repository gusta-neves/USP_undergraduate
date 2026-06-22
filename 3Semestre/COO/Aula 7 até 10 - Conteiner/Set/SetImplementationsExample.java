import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetImplementationsExample {

    public static void main(String[] args) {

        // =====================================================
        // HASHSET
        // =====================================================

        /*
         * Implementado com tabela hash.
         * É a implementação mais rápida.
         * Não garante ordem de iteração.
         */

        Set<String> hashSet = new HashSet<>();

        hashSet.add("Carlos");
        hashSet.add("Ana");
        hashSet.add("Bruno");
        hashSet.add("Ana"); // duplicado

        System.out.println("HashSet:");
        System.out.println(hashSet);

        // =====================================================
        // TREESET
        // =====================================================

        /*
         * Implementado com árvore rubro-negra.
         * Mantém os elementos ordenados.
         */

        Set<String> treeSet = new TreeSet<>();

        treeSet.add("Carlos");
        treeSet.add("Ana");
        treeSet.add("Bruno");
        treeSet.add("Ana"); // duplicado

        System.out.println("\nTreeSet:");
        System.out.println(treeSet);

        // =====================================================
        // LINKEDHASHSET
        // =====================================================

        /*
         * Mantém a ordem de inserção dos elementos.
         */

        Set<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("Carlos");
        linkedHashSet.add("Ana");
        linkedHashSet.add("Bruno");
        linkedHashSet.add("Ana"); // duplicado

        System.out.println("\nLinkedHashSet:");
        System.out.println(linkedHashSet);
    }
}
