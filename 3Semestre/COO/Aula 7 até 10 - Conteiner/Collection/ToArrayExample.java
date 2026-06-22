import java.util.ArrayList;
import java.util.Collection;

/*
 * OPERAÇÕES COM VETORES
 *
 * Os métodos toArray() funcionam como uma ponte entre
 * Collections e Arrays.
 *
 * Collection -> Array
 *
 * Object[] vetor = collection.toArray();
 *
 * Quando todos os elementos possuem o mesmo tipo:
 * 
 * String[] vetor = collection.toArray(new String[0]);
 * 
 * Notação estranha do java, mas é como se você estivesse passando um elemento para ele entender qual tipo é que você está falando
 */

public class ToArrayExample {

    public static void main(String[] args) {

        Collection<String> nomes = new ArrayList<>();

        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");

        System.out.println("Collection:");
        System.out.println(nomes);

        // =====================================================
        // CONVERSÃO PARA Object[]
        // =====================================================

        /*
         * Cria um novo vetor de Object contendo todos os
         * elementos da coleção.
         */
        Object[] vetorObjetos = nomes.toArray();

        System.out.println("\nVetor Object[]:");

        for (Object nome : vetorObjetos) {
            System.out.println(nome);
        }

        // =====================================================
        // CONVERSÃO PARA String[]
        // =====================================================

        /*
         * Quando sabemos o tipo dos elementos da coleção,
         * podemos gerar um vetor tipado.
         *
         * O parâmetro informa o tipo desejado para o vetor.
         */
        String[] vetorStrings = nomes.toArray(new String[0]);

        System.out.println("\nVetor String[]:");

        for (String nome : vetorStrings) {
            System.out.println(nome);
        }
    }
}
