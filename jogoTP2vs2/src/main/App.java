package main;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame jf = new JFrame();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(true);
        jf.setTitle("JOGO TP2");

        PainelJogo pj = new PainelJogo();
        jf.add(pj);

        jf.pack();

        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        pj.startGameThread();
    }
}
