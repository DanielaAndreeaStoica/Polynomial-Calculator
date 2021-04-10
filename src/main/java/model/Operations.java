package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Operations {

    public Polynomial suma(Polynomial p1, Polynomial p2) {
        List<Monomial> result = new ArrayList<Monomial>();

        for (Monomial m1 : p1.getMonomialsList())
            result.add(m1);
        for (Monomial m2 : p2.getMonomialsList())
            result.add(m2);

        result = grupareMonoame(result);
        return new Polynomial(result);
    }

    private List<Monomial> grupareMonoame(List<Monomial> result) {

        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (result.get(i).getPower() == result.get(j).getPower()) {
                    result.add(new Monomial(result.get(i).getPower(), result.get(i).getCoeff() + result.get(j).getCoeff()));
                    result.remove(j);
                    result.remove(i);
                    i = 0;
                    j = 0;
                }
            }
        }
        return result;
    }

    public Polynomial diferenta(Polynomial p1, Polynomial p2) {
        List<Monomial> result = new ArrayList<Monomial>();

        for (Monomial m1 : p1.getMonomialsList())
            result.add(m1);
        for (Monomial m2 : p2.getMonomialsList())
            result.add(new Monomial(m2.getPower(), -1 * m2.getCoeff()));

        result = grupareMonoame(result);
        return new Polynomial(result);
    }

    public Polynomial inmultire(Polynomial p1, Polynomial p2) {
        List<Monomial> result = new ArrayList<Monomial>();

        for (Monomial m1 : p1.getMonomialsList()) {
            for (Monomial m2 : p2.getMonomialsList())
                result.add(inmultireM(m1, m2));
        }
        result = grupareMonoame(result);
        return new Polynomial(result);
    }

    public Polynomial[] impartire(Polynomial p1, Polynomial p2) throws ImpartireCuZeroExceptie {

        Collections.sort(p1.getMonomialsList());
        Collections.sort(p2.getMonomialsList());
        List<Monomial> lm = new ArrayList<>();
        Polynomial[] vectPoly = new Polynomial[2];
        Monomial m1, m2;
        m1 = cautaMonomNenul(p1.getMonomialsList());
        m2 = cautaMonomNenul(p2.getMonomialsList());
        if (p2.getDegree() == 0 && m2 == null)
            throw new ImpartireCuZeroExceptie("Nu se poate imparti cu 0!");
        else if (p1.getDegree() == 0 && m1 == null) {
            lm.add(new Monomial(0, 0));
            vectPoly[0] = new Polynomial(lm);
            vectPoly[1] = p1;
        } else if (p1.getDegree() < p2.getDegree()) {
            lm.add(new Monomial(0, 0));
            vectPoly[0] = new Polynomial(lm);
            vectPoly[1] = p1;
        } else {
            Monomial m = impartireM(m1, m2);
            List<Monomial> listaMonCat = new ArrayList<>();
            listaMonCat.add(m);
            Polynomial cat = new Polynomial(listaMonCat);
            Polynomial rest = diferenta(p1, inmultire(p2, cat));
            Polynomial[] aux = impartire(rest, p2);
            vectPoly[0] = suma(cat, aux[0]);
            vectPoly[1] = aux[1];
        }
        return vectPoly;
}

    private Monomial cautaMonomNenul(List<Monomial> ml){
        for(Monomial m : ml)
            if(m.getCoeff() != 0)
                return m;
         return null;
    }

    public Polynomial derivare(Polynomial p1) {
        List<Monomial> result = new ArrayList<Monomial>();

        for (Monomial m1 : p1.getMonomialsList()) {
            result.add(derivareM(m1));
        }
        result = grupareMonoame(result);
        return new Polynomial(result);
    }

    public Polynomial integrare(Polynomial p1) {
        List<Monomial> result = new ArrayList<Monomial>();

        for (Monomial m1 : p1.getMonomialsList()) {
            result.add(integrareM(m1));
        }
        result = grupareMonoame(result);
        return new Polynomial(result);
    }


    private Monomial inmultireM(Monomial m1, Monomial m2) {
        return new Monomial(m1.getPower() + m2.getPower(), m1.getCoeff() * m2.getCoeff());
    }

    private Monomial impartireM(Monomial m1, Monomial m2) {
        return new Monomial(m1.getPower() - m2.getPower(), m1.getCoeff() / m2.getCoeff());
    }

    private Monomial derivareM(Monomial m1) {
        if (m1.getCoeff() == 0)
            return new Monomial(0, 0);
        else
            return new Monomial(m1.getPower() - 1, m1.getPower() * m1.getCoeff());
    }

    private Monomial integrareM(Monomial m1) {
        if (m1.getCoeff() == 0)
            return new Monomial(0, 0);
        else
            return new Monomial(m1.getPower() + 1, m1.getCoeff() / (m1.getPower() + 1));
    }

}
