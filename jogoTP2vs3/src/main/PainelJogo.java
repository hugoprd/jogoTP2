package main;

import javax.swing.*;
import java.awt.*;

public class PainelJogo {
    JFrame jf;
    Container con;
    JPanel painelTitulo, painelBotaoStart, painelTextoPadrao, painelBotaoConfig, painelBotaoPontuacoes, painelBotaoProximoInGame,
            painelBotaoVoltarConfig, painelBotaoVoltarPontuacoes, painelBotaoVoltarIniciar;
    JLabel tituloJogo;
    Font fonteTitulo = new Font("Courier New", Font.BOLD, 32);
    Font fontePadrao = new Font("Courier New", Font.PLAIN, 18);
    JButton botaoStart, botaoConfig, botaoPontuacoes, botaoProximoInGame;
    JTextArea areaTextoPadrao;

    TitleScreenHandler tsh = new TitleScreenHandler(this);
    ConfigHandler ch = new ConfigHandler(this);

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

        // BOTAO INICIAR
        painelBotaoStart = new JPanel();
        painelBotaoStart.setBounds(650, 500, 200, 50);
        painelBotaoStart.setBackground(Color.black);

        botaoStart = new JButton("INICIAR");
        configurarBotao(botaoStart);
        botaoStart.addActionListener(tsh);

        painelBotaoStart.add(botaoStart);

        // BOTAO CONFIGURACOES
        painelBotaoConfig = new JPanel();
        painelBotaoConfig.setBounds(550, 600, 200, 50);
        painelBotaoConfig.setBackground(Color.black);

        botaoConfig = new JButton("CONFIGURAÇÕES");
        configurarBotao(botaoConfig);
        botaoConfig.addActionListener(ch);

        painelBotaoConfig.add(botaoConfig);

        // BOTAO PONTUACOES
        painelBotaoPontuacoes = new JPanel();
        painelBotaoPontuacoes.setBounds(750, 600, 200, 50);
        painelBotaoPontuacoes.setBackground(Color.black);

        botaoPontuacoes = new JButton("PONTUAÇÕES");
        configurarBotao(botaoPontuacoes);
        botaoPontuacoes.addActionListener(tsh);

        painelBotaoPontuacoes.add(botaoPontuacoes);

        // BOTAO PROXIMO IN-GAME
        painelBotaoProximoInGame = new JPanel();
        painelBotaoProximoInGame.setBounds(650, 500, 200, 50);
        painelBotaoProximoInGame.setBackground(Color.yellow);

        botaoProximoInGame = new JButton(">");
        configurarBotao(botaoProximoInGame);
        botaoProximoInGame.addActionListener(tsh);

        painelTitulo.add(tituloJogo);

        con.add(painelTitulo);
        con.add(painelBotaoStart);
        con.add(painelBotaoConfig);
        con.add(painelBotaoPontuacoes);
        con.add(painelBotaoProximoInGame);

        jf.setVisible(true);
    }

    public void criarTelaJogo(){
        painelTitulo.setVisible(false);
        painelBotaoStart.setVisible(false);
        painelBotaoConfig.setVisible(false);
        painelBotaoPontuacoes.setVisible(false);

        painelTextoPadrao = new JPanel();
        painelTextoPadrao.setBounds(0, (alturaTJ - 300), larguraTJ, 400);
        painelTextoPadrao.setBackground(Color.gray);

        areaTextoPadrao = new JTextArea("olá teste");
        areaTextoPadrao.setBounds(0, (alturaTJ - 300), larguraTJ, 400);
        areaTextoPadrao.setBackground(Color.gray);
        areaTextoPadrao.setForeground(Color.white);
        areaTextoPadrao.setFont(fontePadrao);
        areaTextoPadrao.setLineWrap(true); //texto vai pra baixo automaticamente
        
        painelTextoPadrao.add(areaTextoPadrao);

        con.add(painelTextoPadrao);
    }

    public void abrirConfigs(){
        painelTitulo.setVisible(false);
        painelBotaoStart.setVisible(false);
        painelBotaoConfig.setVisible(false);
        painelBotaoPontuacoes.setVisible(false);
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
