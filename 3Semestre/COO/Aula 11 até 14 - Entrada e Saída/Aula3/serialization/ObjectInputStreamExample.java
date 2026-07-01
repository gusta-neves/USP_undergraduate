// package io.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamExample {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream("pessoa.dat"));

        Pessoa pessoa =
                (Pessoa) in.readObject();

        in.close();

        System.out.println(pessoa);
    }
}