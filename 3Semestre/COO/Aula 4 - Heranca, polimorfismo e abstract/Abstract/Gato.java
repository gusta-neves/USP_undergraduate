public class Gato extends Animal {
    public Gato(String name) {
        super(name);
    }

    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }

    public void responderChamado(String chamado) {
        if (chamado.equals("comer")) {
            emitirSom();
        }
    }
    
}
