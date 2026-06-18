public abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void emitirSom();

    public void responderChamado(String chamado) {
        emitirSom();
    }
}
