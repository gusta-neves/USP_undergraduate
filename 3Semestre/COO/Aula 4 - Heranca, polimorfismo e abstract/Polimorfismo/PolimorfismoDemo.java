public class PolimorfismoDemo {
    public static void main(String[] args) {

        // O array é do tipo Animal.
        // Isso significa que ele pode armazenar qualquer objeto
        // que seja Animal ou herde de Animal, já que lembrando
        // da relação 'é um', Gato é um animal e Cachorro é um animal;D
        Animal[] animais = {

            // Embora a referência seja Animal,
            // o objeto real é um Cachorro ou Gato.
            new Cachorro("Rex"),
            new Gato("Mimi"),

            // Aqui tanto a referência quanto o objeto
            // são da própria classe Animal.
            new Animal("Genérico")
        };

        // Percorre todos os elementos do array.
        // A variável 'animal' é sempre do tipo Animal.
        for (Animal animal : animais) {

            /*
             * POLIMORFISMO:
             *
             * O compilador sabe apenas que 'animal'
             * é uma referência para Animal.
             *
             * Porém, em tempo de execução, o Java verifica
             * qual é o tipo real do objeto armazenado:
             *
             * - Se for Cachorro -> chama Cachorro.emitirSom()
             * - Se for Gato -> chama Gato.emitirSom()
             * - Se for Animal -> chama Animal.emitirSom()
             *
             * Ou seja, a mesma chamada de método produz
             * comportamentos diferentes dependendo do objeto.
             */
            animal.emitirSom();
        }
    }
}
