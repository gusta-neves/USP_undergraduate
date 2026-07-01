// package io.console;

import java.io.Console;

public class ConsoleExample {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {

            System.out.println("Console não disponível.");

            return;
        }

        String nome =
                console.readLine("Nome: ");

        char[] senha =
                console.readPassword("Senha: ");

        console.printf(
                "Bem-vindo, %s!%n",
                nome);

        System.out.println(
                "Senha possui " +
                senha.length +
                " caracteres.");
    }
}