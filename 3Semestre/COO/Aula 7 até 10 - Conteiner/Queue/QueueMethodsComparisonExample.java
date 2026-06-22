// package collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMethodsComparisonExample {

    public static void main(String[] args) {

        Queue<String> fila = new LinkedList<>();

        fila.add("A");
        fila.add("B");

        System.out.println("element():");
        System.out.println(fila.element());

        System.out.println("\npeek():");
        System.out.println(fila.peek());

        System.out.println("\nremove():");
        System.out.println(fila.remove());

        System.out.println("\npoll():");
        System.out.println(fila.poll());

        System.out.println("\nFila vazia:");

        System.out.println(fila.peek());
        System.out.println(fila.poll());
    }
}
