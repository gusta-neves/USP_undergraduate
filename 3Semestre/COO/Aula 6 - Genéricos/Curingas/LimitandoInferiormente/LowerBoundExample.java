import java.util.ArrayList;
import java.util.List;

public class LowerBoundExample {

    /*
     * ? super Animal
     *
     * Significa:
     * "aceito List<Animal>, List<Object>, ou qualquer supertipo de Animal"
     *
     * Ou seja:
     * Animal ou acima dele na hierarquia
     */
    public static void adicionarAnimais(List<? super Animal> lista) {

        // Posso ADICIONAR Animal ou qualquer subclasse dele
        lista.add(new Animal());
        lista.add(new Cachorro());

        // Mas ao ler, só posso garantir Object
        for (Object obj : lista) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {

        List<Object> objetos = new ArrayList<>();
        List<Animal> animais = new ArrayList<>();

        adicionarAnimais(objetos);
        adicionarAnimais(animais);
    }
}
