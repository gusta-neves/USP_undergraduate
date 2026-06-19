public interface Complex {
    // Note que a interface só assina os métodos, mas sem implementar eles.
    // isso pois cabe a cada classe que vai implementar essa interface decidir
    // como vai implementar, sendo que obrigatorialmente deve implementar.
    // Note que não precisamos de construtores

    // Interface é um contrato, onde cada classe que vai implementar ela
    // Deve escolher como vai implementar esses métodos com esses tipos (de parâmetro e de retorno).

    double realPart();
    double imaginaryPart();

    void showComplex();

    Complex plus(Complex c);
    Complex minus(Complex c);
    Complex times(Complex c);
    Complex dividedBy(Complex c);
}