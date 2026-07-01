// package io.formatting;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

    public static void main(String[] args) throws IOException {

        PrintWriter writer =
                new PrintWriter(
                        new FileWriter("saida.txt"));

        writer.println("Primeira linha");

        writer.printf("Número: %d%n", 10);

        writer.printf("Valor: %.2f%n", 15.78);

        writer.close();

        System.out.println("Arquivo escrito com PrintWriter.");
    }
}