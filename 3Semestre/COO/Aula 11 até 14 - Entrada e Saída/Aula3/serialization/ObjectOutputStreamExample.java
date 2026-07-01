// package io.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamExample {

    public static void main(String[] args) throws IOException {

        Pessoa pessoa =
                new Pessoa("Ana", 20);

        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream("pessoa.dat"));

        out.writeObject(pessoa);

        out.close();

        System.out.println("Objeto serializado.");
    }
}