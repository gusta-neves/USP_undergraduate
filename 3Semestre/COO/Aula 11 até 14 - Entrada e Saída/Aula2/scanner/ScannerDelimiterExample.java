// package io.scanner;

import java.util.Scanner;

public class ScannerDelimiterExample {

    public static void main(String[] args) {

        String texto =
                "Ana, Bruno, Carlos, Daniel";

        Scanner scanner = new Scanner(texto);

        scanner.useDelimiter(",\\s*");

        while (scanner.hasNext()) {

            System.out.println(scanner.next());
        }

        scanner.close();
    }
}