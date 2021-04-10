package controller;

import model.ImpartireCuZeroExceptie;
import model.Operations;
import model.ParsingData;
import model.Polynomial;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Controller {

    ParsingData prs;
    Operations opr;
    View v;

    public Controller(View v) {
        this.prs = new ParsingData();
        this.opr = new Operations();
        this.v = v;

        v.setAdunareListener(new AdunareListener());
        v.setScadereListener(new ScadereListener());
        v.setImpartireListener(new ImpartireListener());
        v.setInmultireListener(new InmultireListener());
        v.setDerivareListener(new DerivareListener());
        v.setIntegrareListener(new IntegrareListener());
        v.setResetListener(new ResetListener());
    }

    private Polynomial citestePoly1(){ return prs.parse(v.getPoly1().getText()); }

    private Polynomial citestePoly2(){
        return prs.parse(v.getPoly2().getText());
    }

    public class AdunareListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial rezultat = opr.suma(citestePoly1(),citestePoly2());
            Collections.sort(rezultat.getMonomialsList());
            v.setResult(rezultat.toString());

        }
    }

    public class ScadereListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial rezultat = opr.diferenta(citestePoly1(),citestePoly2());
            Collections.sort(rezultat.getMonomialsList());
            v.setResult(rezultat.toString());
        }
    }

    public class InmultireListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial rezultat = opr.inmultire(citestePoly1(),citestePoly2());
            Collections.sort(rezultat.getMonomialsList());
            v.setResult(rezultat.toString());
        }
    }

    public class ImpartireListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial[] rezultat;
            try {
                rezultat = opr.impartire(citestePoly1(),citestePoly2());
                Collections.sort(rezultat[0].getMonomialsList());
                Collections.sort(rezultat[1].getMonomialsList());
                v.setResult(rezultat[0].toString() + " rest: " + rezultat[1].toString());
            } catch (ImpartireCuZeroExceptie er) {
                er.printStackTrace();
                v.setResult(er.getMessage());
            }
        }
    }
    public class DerivareListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial rezultat = opr.derivare(citestePoly1());
            Collections.sort(rezultat.getMonomialsList());
            v.setResult(rezultat.toString());
        }
    }
    public class IntegrareListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial rezultat = opr.integrare(citestePoly1());
            Collections.sort(rezultat.getMonomialsList());
            v.setResult(rezultat.toString());
        }
    }
    public class ResetListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            v.setPoly1(" ");
            v.setPoly2(" ");
            v.setResult(" ");
        }
    }

}
