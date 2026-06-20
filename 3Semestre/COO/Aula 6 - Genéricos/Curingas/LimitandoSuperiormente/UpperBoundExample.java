import java.util.ArrayList;
import java.util.List;

public class UpperBoundExample {

    /*
     * ? extends Animal
     *
     * Significa:
     * "aceito uma lista de Animal OU qualquer subclasse dele"
     *
     * Ex: List<Animal>, List<Cachorro>, List<Gato> etc.
     */
    public static void imprimirSons(List<? extends Animal> lista) {

        // Só é seguro LER como Animal, pois você não pode arriscar adivinhar qual subclasse de Animal é
        for (Animal a : lista) {
            a.som();
        }

        // lista.add(...) NÃO é permitido aqui
        // porque não sabemos o tipo exato da lista
    }

    public static void main(String[] args) {

        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal());

        List<Cachorro> cachorros = new ArrayList<>();
        cachorros.add(new Cachorro());

        imprimirSons(animais);
        imprimirSons(cachorros);
    }
}
