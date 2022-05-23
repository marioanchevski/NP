package aud02;

import java.math.BigDecimal;

public class BigComplex {

    private BigDecimal realPart;
    private BigDecimal imaginaryPart;

    public BigComplex(BigDecimal realPart, BigDecimal imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public BigComplex add(BigComplex complex) {
        return new BigComplex(this.realPart.add(complex.realPart),
                this.imaginaryPart.add(complex.imaginaryPart));
    }

    public static BigComplex subtract(BigComplex complex1, BigComplex complex2) {
        return new BigComplex(complex1.realPart.subtract(complex2.realPart),
                complex1.imaginaryPart.subtract(complex2.imaginaryPart));
    }

    @Override
    public String toString() {
        return "BigComplex{" +
                "realPart=" + realPart +
                ", imaginaryPart=" + imaginaryPart +
                '}';
    }
}
