// Classe base
public class Animal{
    String nome;
    
    public Animal(String nome) {
        this.nome = nome;
    }
    
    public void emitirSom() {
        System.out.println(nome + " emite um som genérico.");
    }
}