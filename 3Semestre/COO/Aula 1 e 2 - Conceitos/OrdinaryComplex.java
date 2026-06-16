public class OrdinaryComplex implements Complex {
    private double real;
    private double imaginary;

    // Esse é o construtor da classe, ele não precisa de tipagem
    public OrdinaryComplex(double real, double imaginary) {
        // This só mostra que real está falando da real DA CLASSE, e não da que é passada como parametro
        this.real = real;
        this.imaginary = imaginary;
    }

    public double realPart(){
        return real;
    }

    public double imaginaryPart(){
        return imaginary;
    }

    public void showComplex() {
        System.out.printf("%.1f + %.1fi%n", real, imaginary);
    }

    public Complex plus(Complex c){
        return new OrdinaryComplex((real + c.realPart()), (imaginary + c.imaginaryPart()));
    }

    public Complex minus(Complex c){
        return new OrdinaryComplex((real - c.realPart()), (imaginary - c.imaginaryPart()));
    }

    public Complex times(Complex c){
        return new OrdinaryComplex(real * c.realPart() - imaginary * c.imaginaryPart(),
                                    real * c.imaginaryPart() + imaginary * c.realPart());
    }

    public Complex dividedBy(Complex c){
        Complex conjugate = new OrdinaryComplex(c.realPart(), -c.imaginaryPart());
        Complex numerator = this.times(conjugate);
        double denominator = c.realPart() * c.realPart() + c.imaginaryPart() * c.imaginaryPart();
        return new OrdinaryComplex(numerator.realPart() / denominator,
                                    numerator.imaginaryPart() / denominator);
    }
}
