import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapExample {

    public static void main(String[] args) {

        SortedMap<Integer, String> alunos = new TreeMap<>();
        // alunos
        alunos.put(3, "Carlos");
        alunos.put(1, "Ana");
        alunos.put(2, "Bruno");
        alunos.put(5, "Eduardo");
        alunos.put(4, "Daniel");

        System.out.println("Mapa:");
        System.out.println(alunos);

        System.out.println("\nfirstKey():");
        System.out.println(alunos.firstKey());

        System.out.println("\nlastKey():");
        System.out.println(alunos.lastKey());
    }
}