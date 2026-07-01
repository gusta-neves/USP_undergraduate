// package io.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderExample {

    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(System.in));

        System.out.print("Digite seu nome: ");

        String nome = reader.readLine();

        System.out.println("Olá, " + nome + "!");
    }
}