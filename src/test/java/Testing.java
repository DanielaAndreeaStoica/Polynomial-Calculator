import model.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;

public class Testing {

    static ParsingData prs = new ParsingData();
    Operations op = new Operations();

    static String p1;
    static String p2;
    static String p3;
    static String p4;
    static String p5;
    static String p6;

    static Polynomial P1;
    static Polynomial P2;
    static Polynomial P3;
    static Polynomial P4;
    static Polynomial P5;
    static Polynomial P6;

    @BeforeClass
    public static void setUp(){
        p1 = "3x^2+2x^1+5x^0";
        p2 = "2x^1+2x^0";
        p3 = "2x^3+2x^3+1x^1+1x^1";
        p4 = "6x^3-5x^1";
        p5 = "2x^2-4x^5";
        p6 = "-2x^2+4x^5";
        P1 = prs.parse(p1);
        P2 = prs.parse(p2);
        P3 = prs.parse(p3);
        P4 = prs.parse(p4);
        P5 = prs.parse(p5);
        P6 = prs.parse(p6);
    }

    @Test
    public void testSuma(){

        Polynomial suma = op.suma(P1,P2);
        Collections.sort(suma.getMonomialsList());
        Assert.assertEquals("3x^2+4x^1+7x^0",suma.toString());

        Polynomial suma2 = op.suma(P3,P4);
        Collections.sort(suma2.getMonomialsList());
        Assert.assertEquals("10x^3-3x^1",suma2.toString());

        Polynomial suma3 = op.suma(P5,P6);
        Collections.sort(suma3.getMonomialsList());
        Assert.assertEquals("0",suma3.toString());
    }

    @Test
    public void testDiferenta(){
        Polynomial diferenta = op.diferenta(P1,P2);
        Collections.sort(diferenta.getMonomialsList());
        Assert.assertEquals("3x^2+3x^0", diferenta.toString());

        Polynomial diferenta2 = op.diferenta(P3,P4);
        Collections.sort(diferenta2.getMonomialsList());
        Assert.assertEquals("-2x^3+7x^1",diferenta2.toString());
    }

    @Test
    public void testInmultire(){
        Polynomial inmultire = op.inmultire(P1,P2);
        Collections.sort(inmultire.getMonomialsList());
        Assert.assertEquals("6x^3+10x^2+14x^1+10x^0", inmultire.toString());

        Polynomial inmultire2 = op.inmultire(P3,P4);
        Collections.sort(inmultire2.getMonomialsList());
        Assert.assertEquals("24x^6-8x^4-10x^2",inmultire2.toString());
    }

    @Test
    public void testImpartire(){
        Polynomial[] impartire;
        try{
            impartire = op.impartire(P1,P2);
            Collections.sort(impartire[0].getMonomialsList());
            Collections.sort(impartire[1].getMonomialsList());
            Assert.assertEquals("1.5x^1-0.5x^0 rest: 6x^0", impartire[0].toString() + " rest: " + impartire[1].toString());
        }catch (ImpartireCuZeroExceptie ex){
            ex.getMessage();
        }
    }

    @Test
    public void testDerivare(){
        Polynomial derivare = op.derivare(P1);
        Collections.sort(derivare.getMonomialsList());
        Assert.assertEquals("6x^1+2x^0",derivare.toString());

        Polynomial derivare2 = op.derivare(P3);
        Collections.sort(derivare2.getMonomialsList());
        Assert.assertEquals("12x^2+2x^0",derivare2.toString());
    }

    @Test
    public void testIntegrare(){
        Polynomial integrare = op.integrare(P1);
        Collections.sort(integrare.getMonomialsList());
        Assert.assertEquals("1x^3+1x^2+5x^1",integrare.toString() );

        Polynomial integrare2 = op.integrare(P3);
        Collections.sort(integrare2.getMonomialsList());
        Assert.assertEquals("1x^4+1x^2",integrare2.toString());
    }
}
