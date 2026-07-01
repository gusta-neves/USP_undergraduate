// package io.scanner;

import java.util.Locale;
import java.util.Scanner;

public class ScannerNumbersExample {

    public static void main(String[] args) {

        String numeros = "10.5 20.3 30";

        Scanner scanner = new Scanner(numeros);

        scanner.useLocale(Locale.US);

        double soma = 0;

        while (scanner.hasNext()) {

            if (scanner.hasNextDouble()) {

                soma += scanner.nextDouble();

            } else {

                scanner.next();
            }
        }

        scanner.close();

        System.out.println("Soma = " + soma);
    }
}