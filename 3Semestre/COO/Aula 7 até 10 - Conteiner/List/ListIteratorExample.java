// package collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();

        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");

        System.out.println("Percorrendo do fim para o início:");

        for (ListIterator<String> it =
                nomes.listIterator(nomes.size());
             it.hasPrevious();) {

            System.out.println(it.previous());
        }
    }
}
