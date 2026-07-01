// package io.characterstreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharactersExample {

    public static void main(String[] args) throws IOException {

        FileReader in = null;
        FileWriter out = null;

        try {

            in = new FileReader("origem.txt");
            out = new FileWriter("destino.txt");

            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }

            System.out.println("Arquivo copiado.");

        } finally {

            if (in != null)
                in.close();

            if (out != null)
                out.close();
        }
    }
}