public class ExemploTipos {
    // Existem dois tipos em Java, tipos primitivos, como:
    byte bempequeno = 127;
    short pequeno = 100;
    int inteiro = 10000;
    long inteirolongo = 1000000;
    float real = 3.14f;
    double realpreciso = 10.5; //  use double sempre que possível
    boolean booleano = true;
    char caractere = 'a';
    
    /*  Em contrapartida existem os tipos por referência
    Este pode ser um tipo de classe, interface, vetor e enum

    Pode ter como valor uma referencia a um objeto e vetor ou null

    Para cada tipo variável primitiva existe uma classe wrapper
    correspondente que, por suva vez, é um tipo de referência

    Um wrapper deve ser usado quando um valor de um tipo
    primitivo é passado para um método que espera um tipo de
    referência, ou quando um valor primitivo é armazenado em uma
    variável ou campo de um tipo de referência

    Java automaticamente faz o boxing (transformação do tipo primitivo para wrapper)
    e o unboxing.
    */

    Byte boxbempequeno = new Byte(bempequeno);
    Short boxpequeno = new Short(pequeno);
    Integer boxinteiro = new Integer(inteiro);
    Long boxinteirolongo = new Long(inteirolongo);
    Float boxreal = new Float(real);
    Double boxrealpreciso = new Double(realpreciso);
    Boolean boxbooleano = new Boolean(booleano);
    Character boxcaractere = new Character(caractere);
}
