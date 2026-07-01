// package io.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterExample {

    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(
                        new FileReader("entrada.txt"));

        BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter("saida.txt"));

        String linha;

        while ((linha = reader.readLine()) != null) {

            writer.write(linha);
            writer.newLine();
        }

        reader.close();
        writer.close();

        System.out.println("Leitura e escrita utilizando buffers.");
    }
}