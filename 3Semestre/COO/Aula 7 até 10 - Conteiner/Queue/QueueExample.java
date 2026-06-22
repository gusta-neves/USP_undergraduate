// ackage collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {

        Queue<String> fila = new LinkedList<>();

        fila.offer("Ana");
        fila.offer("Bruno");
        fila.offer("Carlos");

        System.out.println(fila);

        System.out.println("\npeek:");
        System.out.println(fila.peek());

        System.out.println("\npoll:");
        System.out.println(fila.poll());

        System.out.println("\nFila após poll:");
        System.out.println(fila);
    }
}
