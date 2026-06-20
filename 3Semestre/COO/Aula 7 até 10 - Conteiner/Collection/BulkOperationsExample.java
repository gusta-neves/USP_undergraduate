import java.util.*;

public class BulkOperationsExample {

    public static void main(String[] args) {

        Collection<Integer> a = new ArrayList<>();
        Collection<Integer> b = new ArrayList<>();

        a.addAll(Arrays.asList(1, 2, 3, 4, 5));
        b.addAll(Arrays.asList(3, 4, 5, 6, 7));

        System.out.println("A: " + a);
        System.out.println("B: " + b);

        // verifica se A contém todos os elementos de B
        boolean r1 = a.containsAll(b);
        System.out.println("A contém B? " + r1);

        // AddAll
        Collection<Integer> c = new ArrayList<>();

        c.addAll(Arrays.asList(1, 2, 3));

        // adiciona todos os elementos de outra coleção
        c.addAll(Arrays.asList(4, 5, 6));

        System.out.println("C: " + c);

        // RemoveAll
        Collection<Integer> r = new ArrayList<>(a);

        // remove de A tudo que também está em B
        r.removeAll(b);

        System.out.println("A - B: " + r);

        // RetainAll
        Collection<Integer> i = new ArrayList<>(a);

        // mantém apenas o que está em B também
        i.retainAll(b);

        System.out.println("A inter B: " + i);

        // Clear
        Collection<Integer> temp = new ArrayList<>(a);

        temp.clear();

        System.out.println("Depois do clear: " + temp);

        System.out.println("containsAll: " + a.containsAll(b));

        Collection<Integer> z = new ArrayList<>(a);
        z.addAll(b);
        System.out.println("addAll: " + z);

        Collection<Integer> d = new ArrayList<>(a);
        d.removeAll(b);
        System.out.println("removeAll: " + d);

        Collection<Integer> e = new ArrayList<>(a);
        e.retainAll(b);
        System.out.println("retainAll: " + e);

        Collection<Integer> f = new ArrayList<>(a);
        f.clear();
        System.out.println("clear: " + f);
    }
}
