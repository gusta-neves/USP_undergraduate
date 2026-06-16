public interface Complex {
    // Note que a interface só assina os métodos, mas sem implementar eles.
    // isso pois cabe a cada classe que vai implementar essa interface decidir
    // como vai implementar, sendo que obrigatorialmente deve implementar.
    // Note que não precisamos de construtores

    double realPart();
    double imaginaryPart();

    void showComplex();

    Complex plus(Complex c);
    Complex minus(Complex c);
    Complex times(Complex c);
    Complex dividedBy(Complex c);
}