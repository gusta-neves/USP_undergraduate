// package io.charset;

import java.nio.charset.Charset;

public class CharsetExample {

    public static void main(String[] args) {

        System.out.println("Charset padrão:");

        System.out.println(Charset.defaultCharset());

        System.out.println("\nCharsets disponíveis:");

        for (String nome : Charset.availableCharsets().keySet()) {
            System.out.println(nome);
        }
    }
}