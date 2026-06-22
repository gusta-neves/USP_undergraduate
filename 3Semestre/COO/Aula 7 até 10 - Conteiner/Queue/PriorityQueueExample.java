// package collections.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

    public static void main(String[] args) {

        Queue<Integer> fila = new PriorityQueue<>();

        fila.add(5);
        fila.add(1);
        fila.add(4);
        fila.add(2);
        fila.add(3);

        while (!fila.isEmpty()) {
            System.out.println(fila.remove());
        }
    }
}
