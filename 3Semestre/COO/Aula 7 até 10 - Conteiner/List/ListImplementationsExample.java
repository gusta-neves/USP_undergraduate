// package collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListImplementationsExample {

    public static void main(String[] args) {

        /*
         * As duas principais implementações de List.
         */

        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        arrayList.add("Ana");
        arrayList.add("Bruno");
        arrayList.add("Carlos");

        linkedList.add("Ana");
        linkedList.add("Bruno");
        linkedList.add("Carlos");

        System.out.println("ArrayList:");
        System.out.println(arrayList);

        System.out.println("\nLinkedList:");
        System.out.println(linkedList);
    }
}
