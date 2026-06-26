// Pato é Animal, Corredor e Nadador
class Pato extends Animal implements Corredor, Nadador {

    @Override
    public void correr() {
        System.out.println("Pato Correndo...");
    }

    @Override
    public void nadar() {
        System.out.println("Pato Nadando...");
    }
}
