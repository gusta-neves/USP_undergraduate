public class Main {
    public static void main(String[] args) {
        Animal toto = new Cachorro("Totó");
        Animal bichano = new Gato("Bichano");
        // toto.responderChamado("comer"); -> Erro pois o método responderChamado é abstrato e não tem implementação na classe Cachorro
        // Um método abstrato não é implementado na classe abstrata, mas pode ser implementado na subclasse. Se a subclasse não implementar o método, ela também deve ser declarada como abstrata.
        Cachorro totó = new Cachorro("Totó");
        totó.responderChamado("comer"); // Totó au au!
    }
}
