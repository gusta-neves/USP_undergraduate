// package io.characterstreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterExample {

    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("texto.txt");

        writer.write("Olá Mundo!");

        writer.close();

        FileReader reader = new FileReader("texto.txt");

        int c;

        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }

        reader.close();
    }
}