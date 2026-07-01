// package io.scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScannerFileExample {

    public static void main(String[] args) throws IOException {

        Scanner scanner =
                new Scanner(
                        new BufferedReader(
                                new FileReader("texto.txt")));

        while (scanner.hasNext()) {

            System.out.println(scanner.next());
        }

        scanner.close();
    }
}