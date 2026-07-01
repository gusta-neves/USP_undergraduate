// package io.serialization;

import java.io.Serializable;

public class SerializableExample implements Serializable {

    private String nome;
    private int idade;

    public SerializableExample(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return nome + " (" + idade + ")";
    }

    public static void main(String[] args) {

        SerializableExample pessoa =
                new SerializableExample(
                        "Ana",
                        20);

        System.out.println(pessoa);
    }
}