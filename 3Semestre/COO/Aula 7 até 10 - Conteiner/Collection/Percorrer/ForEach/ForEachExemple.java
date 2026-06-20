import java.util.Collection;
import java.util.ArrayList;

public class ForEachExemple {

    Collection<Integer> c = new ArrayList<>();

    public ForEachExemple() {
        c.add(1);
        c.add(2);
        c.add(3);
    }

    /*
     * For-each (enhanced for)
     *
     * Internamente ele usa Iterator,
     * mas de forma automática.
     */
    public void percorrerForEach() {

        for (Integer o : c) {
            System.out.println(o);
        }
    }
}
