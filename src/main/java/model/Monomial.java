package model;

public class Monomial implements Comparable<Monomial> {
    private int power;
    private double coeff;

    public Monomial(int power, double coeff) {
        this.power = power;
        this.coeff = coeff;
    }

    public int getPower() {
        return power;
    }

    public double getCoeff() {
        return coeff;
    }

    public String toString(int x) {
        if (coeff != 0) {
            if (x == 0)
                return (int) coeff + "x^" + power;
            else
                return coeff + "x^" + power;
        }
        return "";
    }

    @Override
    public int compareTo(Monomial o) {
        return Integer.compare(power, o.power) * (-1);
    }
}
