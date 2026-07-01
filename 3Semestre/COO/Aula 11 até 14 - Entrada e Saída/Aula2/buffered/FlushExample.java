// package io.buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FlushExample {

    public static void main(String[] args) throws IOException {

        BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter("saida.txt"));

        writer.write("Primeira linha");

        writer.flush();

        System.out.println("Buffer gravado com flush().");

        writer.write("\nSegunda linha");

        writer.close();
    }
}