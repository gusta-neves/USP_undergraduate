// package io.formatting;

public class FormatExample {

    public static void main(String[] args) {

        int numero = 5;

        double raiz = Math.sqrt(numero);

        System.out.format(
                "A raiz de %d é %.2f.%n",
                numero,
                raiz);
    }
}