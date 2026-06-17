public class Main {
    public static void main(String[] args) {
        // AUTOBOXING (primitivo -> wrapper)

        int numero = 10;
        Integer boxNumero = numero;

        double valorDecimal = 3.14;
        Double boxValorDecimal = valorDecimal;

        boolean ativo = true;
        Boolean boxAtivo = ativo;

        char letra = 'A';
        Character boxLetra = letra;

        System.out.println("Autoboxing:");
        System.out.println(boxNumero);
        System.out.println(boxValorDecimal);
        System.out.println(boxAtivo);
        System.out.println(boxLetra);

        // UNBOXING (wrapper -> primitivo)

        Integer idadeWrapper = 20;
        int idade = idadeWrapper;

        Double alturaWrapper = 1.75;
        double altura = alturaWrapper;

        Boolean aprovadoWrapper = true;
        boolean aprovado = aprovadoWrapper;

        Character inicialWrapper = 'J';
        char inicial = inicialWrapper;

        System.out.println("\nUnboxing:");
        System.out.println(idade);
        System.out.println(altura);
        System.out.println(aprovado);
        System.out.println(inicial);
    }
}
