package br.com.pedroenju;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Tela extends JFrame implements ActionListener {

    private JLabel lb[];
    private JTextField txt[];
    private JButton btn[];
    private Dimension whLb, whTxt, whbtn, whResult;
    private Font font1, fontResult;

    public Tela() throws HeadlessException {
        super("Kilometragem");
        this.setSize(600, 270);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createWindow();
        this.setVisible(true);
    }

    private void createWindow() {
        this.setLayout(new FlowLayout());
        this.setResizable(false);

        this.lb = new JLabel[8];
        this.txt = new JTextField[4];
        this.btn = new JButton[2];

        this.whLb = new Dimension(200, 30);
        this.whTxt = new Dimension(300, 30);
        this.whbtn = new Dimension(200, 30);
        this.whResult = new Dimension(150, 30);

        this.font1 = new Font("Tahoma", Font.PLAIN, 13);
        this.fontResult = new Font("Tahoma", Font.PLAIN, 17);

        this.string1();
        this.string2();
        this.string3();
        this.string4();
        this.string5();
        this.string6();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("primeiro")) {
            float num[] = new float[3];
            float res[] = new float[2];

            num[0] = Float.parseFloat(this.txt[0].getText());
            num[1] = Float.parseFloat(this.txt[1].getText());
            num[2] = Float.parseFloat(this.txt[2].getText());

            res[0] = num[1] / num[0];
            res[1] = num[2] / num[1];

            this.lb[3].setText(res[0] + " KM/L");
            this.lb[4].setText("R$" + res[1] + " por litro");
        }
        if (e.getActionCommand().equals("segundo")) {
            float num[] = new float[4];
            float res[] = new float[2];

            num[0] = Float.parseFloat(this.txt[0].getText());
            num[1] = Float.parseFloat(this.txt[1].getText());
            num[2] = Float.parseFloat(this.txt[2].getText());
            num[3] = Float.parseFloat(this.txt[3].getText());

            res[0] = num[3] / (num[1] / num[0]);
            res[1] = (num[2] / num[1]) * num[3];

            this.lb[6].setText(res[0] + " litro(s)");
            this.lb[7].setText("Custo de R$" + res[1]);
        }
    }

    private void string1() {
        this.lb[0] = new JLabel("Quantidade de litros");
        this.lb[0].setPreferredSize(whLb);
        this.lb[0].setFont(font1);
        this.add(lb[0]);

        this.txt[0] = new JTextField();
        this.txt[0].setPreferredSize(whTxt);
        this.add(txt[0]);
    }

    private void string2() {
        this.lb[1] = new JLabel("Quantidade de Km");
        this.lb[1].setPreferredSize(whLb);
        this.lb[1].setFont(font1);
        this.add(lb[1]);

        this.txt[1] = new JTextField();
        this.txt[1].setPreferredSize(whTxt);
        this.add(txt[1]);
    }

    private void string3() {
        this.lb[2] = new JLabel("Valor Pago");
        this.lb[2].setPreferredSize(whLb);
        this.lb[2].setFont(font1);
        this.add(lb[2]);

        this.txt[2] = new JTextField();
        this.txt[2].setPreferredSize(whTxt);
        this.add(txt[2]);
    }

    private void string4() {
        this.btn[0] = new JButton("Calcular");
        this.btn[0].addActionListener(this);
        this.btn[0].setActionCommand("primeiro");
        this.btn[0].setPreferredSize(whbtn);
        this.add(btn[0]);

        this.lb[3] = new JLabel("Resultado (km / litros)");
        this.lb[3].setPreferredSize(whResult);
        this.lb[3].setFont(fontResult);
        this.add(lb[3]);

        this.lb[4] = new JLabel("Resultado (vl / km)");
        this.lb[4].setPreferredSize(whResult);
        this.lb[4].setFont(fontResult);
        this.lb[4].setForeground(Color.red);
        this.add(lb[4]);
    }

    private void string5() {
        this.lb[5] = new JLabel("KM Viagem");
        this.lb[5].setPreferredSize(whLb);
        this.lb[5].setFont(font1);
        this.add(lb[5]);

        this.txt[3] = new JTextField();
        this.txt[3].setPreferredSize(whTxt);
        this.add(txt[3]);
    }

    private void string6() {
        this.btn[1] = new JButton("Calcular");
        this.btn[1].addActionListener(this);
        this.btn[1].setActionCommand("segundo");
        this.btn[1].setPreferredSize(whbtn);
        this.add(btn[1]);

        this.lb[6] = new JLabel("Litros Necessários");
        this.lb[6].setPreferredSize(whResult);
        this.lb[6].setFont(fontResult);
        this.add(lb[6]);

        this.lb[7] = new JLabel("Custo Viagem");
        this.lb[7].setPreferredSize(whResult);
        this.lb[7].setFont(fontResult);
        this.lb[7].setForeground(Color.red);
        this.add(lb[7]);
    }

}
