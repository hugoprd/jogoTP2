package main;

import javax.swing.*;
import java.awt.*;

public class PainelJogo {
    JFrame jf;
    Container con;
    JPanel painelTitulo, painelBotaoStart, painelTextoPadrao;
    JLabel tituloJogo;
    Font fonteTitulo = new Font("Courier New", Font.BOLD, 32);
    Font fontePadrao = new Font("Courier New", Font.PLAIN, 18);
    JButton botaoStart;
    JTextArea areaTextoPadrao;

    TitleScreenHandler tsh = new TitleScreenHandler(this);

    ControleMusicaTI cmti = new ControleMusicaTI(this);

    // TELA JOGO
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    int larguraTJ = screenSize.width;
    int alturaTJ = screenSize.height;

    //centralizacao na tela inicial
    int x = screenSize.width / 3;
    int y = screenSize.height / 4;

    public PainelJogo(){
        jf = new JFrame();
        jf.setSize(larguraTJ, alturaTJ);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setBackground(Color.black);
        jf.setLayout(null);
        jf.setResizable(true);
        jf.setLocation(0, 0);

        con = jf.getContentPane();

        painelTitulo = new JPanel();
        painelTitulo.setBounds(450, 50, 600, 150);
        painelTitulo.setBackground(Color.black);

        tituloJogo = new JLabel("JOGO TP2");
        tituloJogo.setForeground(Color.white);
        tituloJogo.setFont(fonteTitulo);

        painelBotaoStart = new JPanel();
        painelBotaoStart.setBounds(650, 500, 200, 100);
        painelBotaoStart.setBackground(Color.black);

        botaoStart = new JButton("INICIAR");
        configurarBotao(botaoStart);
        botaoStart.addActionListener(tsh);

        painelBotaoStart.add(botaoStart);

        painelTitulo.add(tituloJogo);

        con.add(painelTitulo);
        con.add(painelBotaoStart);

        jf.setVisible(true);
    }

    public void criarTelaJogo(){
        painelTitulo.setVisible(false);
        painelBotaoStart.setVisible(false);

        painelTextoPadrao = new JPanel();
        painelTextoPadrao.setBounds(400, 0, 400, 600);
        painelTextoPadrao.setBackground(Color.gray);

        areaTextoPadrao = new JTextArea();
        areaTextoPadrao.setBounds(400, 0, 400, 600);
        areaTextoPadrao.setBackground(Color.black);
        areaTextoPadrao.setForeground(Color.white);
        areaTextoPadrao.setFont(fontePadrao);
        areaTextoPadrao.setLineWrap(true); //texto vai pra baixo automaticamente
        
        painelTextoPadrao.add(areaTextoPadrao);

        con.add(painelTextoPadrao);
    }

    public void configurarBotao(JButton botao){
        botao.setFocusPainted(false);
        botao.setBorderPainted(true);
        botao.setContentAreaFilled(false);
        botao.setOpaque(true);

        botao.setBackground(Color.black);
        botao.setForeground(Color.white);
        botao.setFont(fontePadrao);
    }
}
