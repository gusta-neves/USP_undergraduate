import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Lista de Integer
        List<Integer> li = Arrays.asList(1, 2, 3);

        // Lista de String
        List<String> ls = Arrays.asList("one", "two", "three");

        // O método aceita QUALQUER tipo de lista
        printList(li);
        printList(ls);
    }

    /*
     * ? = tipo desconhecido
     *
     * Isso significa:
     * "eu não me importo com o tipo da lista,
     * só preciso conseguir ler os elementos como Object"
     */
    public static void printList(List<?> list) {

        // Como não sabemos o tipo exato, tratamos tudo como Object
        for (Object elem : list) {
            System.out.print(elem + " ");
        }

        System.out.println();
    }
}
