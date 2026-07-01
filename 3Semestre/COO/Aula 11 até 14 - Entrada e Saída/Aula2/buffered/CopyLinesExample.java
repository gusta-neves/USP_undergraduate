// package io.buffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLinesExample {

    public static void main(String[] args) throws IOException {

        BufferedReader input = null;
        PrintWriter output = null;

        try {

            input = new BufferedReader(
                    new FileReader("origem.txt"));

            output = new PrintWriter("destino.txt");

            String linha;

            while ((linha = input.readLine()) != null) {
                output.println(linha);
            }

            System.out.println("Arquivo copiado linha por linha.");

        } finally {

            if (input != null)
                input.close();

            if (output != null)
                output.close();
        }
    }
}