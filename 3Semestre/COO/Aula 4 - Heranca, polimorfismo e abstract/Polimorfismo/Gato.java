// Subclasse Gato
class Gato extends Animal {
    public Gato(String nome) {
        super(nome);
    }

              // opcional, indica ao compilador que a intenção é sobrescrever (override)
    @Override // um método da superclasse ou implementar um método de uma interface
    public void emitirSom() {
        System.out.println(nome + " mia: Miau!");
    }
}

