public class PolarComplex implements Complex {
    private double r;
    private double theta;

    public PolarComplex(double r, double theta) {
        this.r = r;
        this.theta = theta;
    }

    public double realPart() {
        return r * Math.cos(theta);
    }

    public double imaginaryPart() {
        return r * Math.sin(theta);
    }

    public void showComplex() {
        System.out.printf("%.1f(%.1f + i%.1f)%n", r, this.realPart(), this.imaginaryPart());
    }

    public Complex plus(Complex c) {
        double re = realPart() + c.realPart();
        double im = imaginaryPart() + c.imaginaryPart();

        return new PolarComplex(
            Math.sqrt(re * re + im * im),
            Math.atan2(im, re)
        );
    }

    public Complex minus(Complex c) {
        double re = realPart() - c.realPart();
        double im = imaginaryPart() - c.imaginaryPart();

        return new PolarComplex(
            Math.sqrt(re * re + im * im),
            Math.atan2(im, re)
        );
    }

    public Complex times(Complex c) {
        double r2 = Math.sqrt(
            c.realPart() * c.realPart() +
            c.imaginaryPart() * c.imaginaryPart()
        );

        double theta2 = Math.atan2(
            c.imaginaryPart(),
            c.realPart()
        );

        return new PolarComplex(
            r * r2,
            theta + theta2
        );
    }

    public Complex dividedBy(Complex c) {
        double r2 = Math.sqrt(
            c.realPart() * c.realPart() +
            c.imaginaryPart() * c.imaginaryPart()
        );

        double theta2 = Math.atan2(
            c.imaginaryPart(),
            c.realPart()
        );

        return new PolarComplex(
            r / r2,
            theta - theta2
        );
    }
}
