// package io.scanner;

import java.util.Scanner;

public class ScannerConsoleExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");

        String nome = scanner.nextLine();

        System.out.println("Olá, " + nome + "!");

        scanner.close();
    }
}