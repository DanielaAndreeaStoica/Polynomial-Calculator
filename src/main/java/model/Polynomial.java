package model;

import java.util.List;

public class Polynomial {
    private List<Monomial> monomialsList;
    private int degree;

    public Polynomial(List<Monomial> monomialsList) {
        this.monomialsList = monomialsList;
        degree = 0;
        for (Monomial m : monomialsList) {
            if (m.getPower() > degree && m.getCoeff() != 0)
                degree = m.getPower();
        }
    }

    public List<Monomial> getMonomialsList() {
        return monomialsList;
    }

    public int getDegree() {
        return degree;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean first = false;
        boolean coefNenul = false;
        for (Monomial m : monomialsList) {
            if (m.getCoeff() != 0) {
                coefNenul = true;
                if (!first || m.getCoeff() < 0) {
                    if (m.getCoeff() == (int) m.getCoeff())
                        sb.append(m.toString(0));
                    else
                        sb.append(m.toString(1));
                    first = true;
                } else {
                    if (m.getCoeff() == (int) m.getCoeff())
                        sb.append("+").append(m.toString(0));
                    else
                        sb.append("+").append(m.toString(1));
                }
            }
        }
        if(!coefNenul)
            return "0";
        return sb.toString();
    }
}
