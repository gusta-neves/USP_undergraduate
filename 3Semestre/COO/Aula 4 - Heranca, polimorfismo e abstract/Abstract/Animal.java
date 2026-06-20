public abstract class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public abstract void emitirSom();

    public void responderChamado(String chamado) {
        emitirSom();
    }
}
