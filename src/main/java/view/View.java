package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private final JLabel title;
    private JTextField poly1 = new JTextField();
    private JTextField poly2 = new JTextField();
    private JTextField result = new JTextField();
    private JButton adunare = new JButton("+");
    private JButton scadere = new JButton("-");
    private JButton inmultire = new JButton("*");
    private JButton impartire = new JButton("/");
    private JButton derivare = new JButton("'");
    private JButton integrare = new JButton("∫");
    private JButton reset = new JButton("Reset");


    View() {

        JFrame frame = new JFrame("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(700, 400);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.white);

        title = new JLabel();
        title.setHorizontalAlignment((int) Component.LEFT_ALIGNMENT);
        title.setText("Polynomial Calculator");
        Border border = new LineBorder(Color.BLACK, 2);
        title.setFont(new Font("Ink Free", Font.BOLD, 25));
        title.setBorder(border);
        Title ttl = new Title();
        frame.add(ttl, BorderLayout.NORTH);

        JPanel space0 = new JPanel();
        space0.setPreferredSize(new Dimension(400, 10));

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());

        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(400, 40));
        p.setLayout(new FlowLayout());
        JLabel L1 = new JLabel();
        L1.setText("Polynomial 1:");
        L1.setFont(new Font("MV Boli", Font.BOLD, 17));
        p.add(L1);
        poly1.setPreferredSize(new Dimension(200, 25));
        p.add(poly1);

        JPanel q = new JPanel();
        q.setPreferredSize(new Dimension(400, 40));
        q.setLayout(new FlowLayout());
        JLabel L2 = new JLabel();
        L2.setText("Polynomial 2:");
        L2.setFont(new Font("MV Boli", Font.BOLD, 17));
        q.add(L2);
        poly2.setPreferredSize(new Dimension(200, 25));
        q.add(poly2);

        JPanel space = new JPanel();
        space.setPreferredSize(new Dimension(500, 40));

        JPanel ad = new JPanel();
        ad.setPreferredSize(new Dimension(900, 40));
        ad.setLayout(new FlowLayout());
        adunare.setPreferredSize(new Dimension(100, 23));
        adunare.setFont(new Font("MV Boli", Font.BOLD, 19));
        ad.add(adunare);
        scadere.setPreferredSize(new Dimension(100, 23));
        scadere.setFont(new Font("MV Boli", Font.BOLD, 19));
        ad.add(scadere);
        inmultire.setPreferredSize(new Dimension(100, 23));
        inmultire.setFont(new Font("MV Boli", Font.BOLD, 19));
        ad.add(inmultire);
        impartire.setFont(new Font("MV Boli", Font.BOLD, 19));
        impartire.setPreferredSize(new Dimension(100, 23));
        ad.add(impartire);
        derivare.setPreferredSize(new Dimension(100, 23));
        derivare.setFont(new Font("MV Boli", Font.BOLD, 19));
        ad.add(derivare);
        integrare.setPreferredSize(new Dimension(100, 23));
        integrare.setFont(new Font("Algerian", Font.BOLD, 16));
        ad.add(integrare);

        JPanel space2 = new JPanel();
        space2.setPreferredSize(new Dimension(500, 40));

        JPanel rez = new JPanel();
        rez.setPreferredSize((new Dimension(600, 40)));
        rez.setLayout(new FlowLayout());
        JLabel L3 = new JLabel();
        L3.setText("Result:");
        L3.setFont(new Font("MV Boli", Font.BOLD, 17));
        rez.add(L3);
        result.setPreferredSize(new Dimension(350, 25));
        result.setFont(new Font("Bookman Old Style", 1,13));
        result.setDisabledTextColor(Color.BLACK);
        rez.add(result);
        reset.setPreferredSize(new Dimension(100, 23));
        rez.add(reset);
        result.setEnabled(false);

        content.add(space0);
        content.add(p);
        content.add(q);
        content.add(space);
        content.add(ad);
        content.add(space2);
        content.add(rez);
        frame.add(content);

    }

    class Title extends JPanel {

        public Title() {
            super(new BorderLayout());
            add(title);
            setBackground(Color.pink);
            setPreferredSize(new Dimension(80, 45));
        }
    }

    public JTextField getPoly1() {
        return poly1;
    }

    public JTextField getPoly2() {
        return poly2;
    }

    public void setPoly1(String string) {
        poly1.setText(string);
    }

    public void setPoly2(String string) {
        poly2.setText(string);
    }

    public void setResult(String string) {
        result.setText(string);
    }

    public void setAdunareListener(ActionListener a) {
        adunare.addActionListener(a);
    }

    public void setScadereListener(ActionListener a) {
        scadere.addActionListener(a);
    }

    public void setInmultireListener(ActionListener a) {
        inmultire.addActionListener(a);
    }

    public void setImpartireListener(ActionListener a) {
        impartire.addActionListener(a);
    }

    public void setDerivareListener(ActionListener a) {
        derivare.addActionListener(a);
    }

    public void setIntegrareListener(ActionListener a) {
        integrare.addActionListener(a);
    }

    public void setResetListener(ActionListener a) {
        reset.addActionListener(a);
    }
}
