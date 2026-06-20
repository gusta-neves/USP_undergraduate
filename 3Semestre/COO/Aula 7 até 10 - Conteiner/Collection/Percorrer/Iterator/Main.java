import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

public class Main {

    /*
     * Método que filtra elementos de uma Collection
     * removendo aqueles que NÃO satisfazem a condição.
     */
    static void filter(Collection<Integer> c) {

        // Iterator percorre a coleção de forma segura
        Iterator<Integer> it = c.iterator();

        while (it.hasNext()) {

            Integer value = it.next();

            // Se não satisfaz a condição, remove
            if (!cond(value)) {
                it.remove();
            }
        }
    }

    /*
     * Exemplo de condição:
     * manter apenas números pares
     */
    static boolean cond(Integer x) {
        return x % 2 == 0;
    }

    public static void main(String[] args) {

        Collection<Integer> lista = new ArrayList<>();

        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);

        filter(lista);

        System.out.println(lista); // [2, 4]
    }
}
