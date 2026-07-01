// package io.charset;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EncodingExample {

    public static void main(String[] args) {

        String texto = "Olá";

        byte[] utf8 =
                texto.getBytes(StandardCharsets.UTF_8);

        byte[] utf16 =
                texto.getBytes(StandardCharsets.UTF_16);

        System.out.println("UTF-8:");

        System.out.println(Arrays.toString(utf8));

        System.out.println("\nUTF-16:");

        System.out.println(Arrays.toString(utf16));
    }
}