// package collections.deque;
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {

    public static void main(String[] args) {

        Deque<String> deque = new ArrayDeque<>();

        deque.addFirst("B");
        deque.addFirst("A");

        deque.addLast("C");
        deque.addLast("D");

        System.out.println(deque);

        System.out.println("\nPrimeiro:");
        System.out.println(deque.getFirst());

        System.out.println("\nÚltimo:");
        System.out.println(deque.getLast());

        System.out.println("\nremoveFirst:");
        System.out.println(deque.removeFirst());

        System.out.println("\nremoveLast:");
        System.out.println(deque.removeLast());

        System.out.println("\nEstado final:");
        System.out.println(deque);
    }
}
