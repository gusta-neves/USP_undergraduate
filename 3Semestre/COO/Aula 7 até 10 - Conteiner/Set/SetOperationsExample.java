import java.util.HashSet;
import java.util.Set;

public class SetOperationsExample {

    public static void main(String[] args) {

        Set<Integer> s1 = new HashSet<>();

        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.add(4);

        Set<Integer> s2 = new HashSet<>();

        s2.add(3);
        s2.add(4);
        s2.add(5);
        s2.add(6);

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        // =====================================================
        // UNIÃO
        // =====================================================

        /*
         * Contém todos os elementos de s1 e s2.
         */

        Set<Integer> uniao = new HashSet<Integer>(s1);

        uniao.addAll(s2);

        System.out.println("\nUnião:");
        System.out.println(uniao);

        // =====================================================
        // INTERSEÇÃO
        // =====================================================

        /*
         * Contém apenas os elementos presentes
         * nos dois conjuntos.
         */

        Set<Integer> intersecao = new HashSet<Integer>(s1);

        intersecao.retainAll(s2);

        System.out.println("\nInterseção:");
        System.out.println(intersecao);

        // =====================================================
        // DIFERENÇA
        // =====================================================

        /*
         * Elementos que pertencem a s1
         * mas não pertencem a s2.
         */

        Set<Integer> diferenca = new HashSet<Integer>(s1);

        diferenca.removeAll(s2);

        System.out.println("\nDiferença (s1 - s2):");
        System.out.println(diferenca);

        // =====================================================
        // DIFERENÇA SIMÉTRICA
        // =====================================================

        /*
         * Elementos que pertencem a apenas
         * um dos conjuntos.
         */

        Set<Integer> diferencaSimetrica = new HashSet<Integer>(s1);

        diferencaSimetrica.addAll(s2);

        Set<Integer> tmp = new HashSet<Integer>(s1);

        tmp.retainAll(s2);

        diferencaSimetrica.removeAll(tmp);

        System.out.println("\nDiferença Simétrica:");
        System.out.println(diferencaSimetrica);

        // =====================================================
        // CONJUNTOS ORIGINAIS
        // =====================================================

        /*
         * Como as operações foram feitas sobre cópias,
         * os conjuntos originais permanecem inalterados.
         */

        System.out.println("\ns1 após as operações:");
        System.out.println(s1);

        System.out.println("\ns2 após as operações:");
        System.out.println(s2);
    }
}
