// package collections.queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSortExample {

    public static <E> List<E> heapSort(Collection<E> c) {

        Queue<E> queue = new PriorityQueue<E>(c);

        List<E> result = new ArrayList<E>();

        while (!queue.isEmpty()) {
            result.add(queue.remove());
        }

        return result;
    }

    public static void main(String[] args) {

        List<Integer> numeros = List.of(5, 1, 4, 2, 3);

        System.out.println(heapSort(numeros));
    }
}
