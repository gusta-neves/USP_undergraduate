// package io.bytestreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamExample {

    public static void main(String[] args) throws IOException {

        FileOutputStream out = new FileOutputStream("saida.txt");

        out.write('A');
        out.write('B');
        out.write('C');

        out.close();

        FileInputStream in = new FileInputStream("saida.txt");

        int b;

        System.out.println("Conteúdo do arquivo:");

        while ((b = in.read()) != -1) {
            System.out.print((char) b);
        }

        in.close();
    }
}