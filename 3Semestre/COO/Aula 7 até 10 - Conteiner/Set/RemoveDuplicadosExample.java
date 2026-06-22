import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicadosExample {

    /*
     * Remove elementos repetidos de uma coleção.
     *
     * LinkedHashSet mantém a ordem original de inserção.
     */
    public static <E> Set<E> removeDuplicados(Collection<E> c) {
        return new LinkedHashSet<E>(c);

        // Alternativas:
        // return new HashSet<E>(c);
        // return new TreeSet<E>(c);
    }

    public static void main(String[] args) {

        Collection<String> nomes = new ArrayList<>();

        nomes.add("Ana");
        nomes.add("Carlos");
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");

        System.out.println("Coleção original:");
        System.out.println(nomes);

        Set<String> semDuplicados = removeDuplicados(nomes);

        System.out.println("\nApós remover duplicados:");
        System.out.println(semDuplicados);
    }
}
