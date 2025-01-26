package main;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;

public class PainelJogo {
    JFrame jf;
    Container con;

    JPanel painelTitulo, painelBotaoStart, painelBotaoConfig, painelBotaoPontuacoes;
    JPanel painelTextoPadrao;
    JPanel painelImagemApartamento, painelImagemSala, painelImagemCozinha, painelImagemQuarto, painelImagemBanheiro;
    JPanel painelImagemAutoestima, painelImagemChefe;
    JPanel painelBotaoProximoInGame;
    JPanel painelBotaoVoltarConfig, painelBotaoVoltarPontuacoes, painelBotaoVoltarIniciar;
    JPanel painelBotaoPersonagemKalrok, painelBotaoPersonagemLohan;
    JPanel painelBotaoAumentarVol, painelBotaoDiminuirVol;

    JLabel tituloJogo;

    JTextArea areaTextoPadrao;

    Font fonteTitulo = new Font("Courier New", Font.BOLD, 32);
    Font fontePadrao = new Font("Courier New", Font.PLAIN, 18);

    JButton botaoStart, botaoConfig, botaoPontuacoes;
    JButton botaoProximoInGame;
    JButton botaoVoltarConfig, botaoVoltarPontuacoes, botaoVoltarIniciar;
    JButton botaoPersonagemKalrok, botaoPersonagemLohan;
    JButton botaoAumentarVol, botaoDiminuirVol;

    // menu
    TitleScreenHandler tsh = new TitleScreenHandler(this);
    TitleScreenHandlerB tshb = new TitleScreenHandlerB(this);
    // misc
    ConfigHandler ch = new ConfigHandler(this);
    // start handler: kalrok || lohan
    StartHandlerK shk = new StartHandlerK(this);
    StartHandlerL shl = new StartHandlerL(this);
    // aumentar diminuir volume
    VolHandlerUp vhu = new VolHandlerUp(this);
    VolHandlerDown vhd = new VolHandlerDown(this);

    public Clip clip;
    public FloatControl volumeControl;

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

        // TITULO
        painelTitulo = new JPanel();
        painelTitulo.setBounds(450, 50, 600, 150);
        painelTitulo.setBackground(Color.black);

        tituloJogo = new JLabel("JOGO TP2");
        tituloJogo.setForeground(Color.white);
        tituloJogo.setFont(fonteTitulo);

        painelTitulo.add(tituloJogo);

        painelTitulo.setVisible(true);

        // BOTAO INICIAR
        painelBotaoStart = new JPanel();
        painelBotaoStart.setBounds(650, 500, 200, 50);
        painelBotaoStart.setBackground(Color.black);

        botaoStart = new JButton("INICIAR");
        configurarBotao(botaoStart);
        botaoStart.addActionListener(tsh);

        painelBotaoStart.add(botaoStart);

        painelBotaoStart.setVisible(true);

        // BOTAO CONFIGURACOES
        painelBotaoConfig = new JPanel();
        painelBotaoConfig.setBounds(550, 600, 200, 50);
        painelBotaoConfig.setBackground(Color.black);

        botaoConfig = new JButton("CONFIGURAÇÕES");
        configurarBotao(botaoConfig);
        botaoConfig.addActionListener(ch);

        painelBotaoConfig.add(botaoConfig);

        painelBotaoConfig.setVisible(true);

        // BOTAO PONTUACOES
        painelBotaoPontuacoes = new JPanel();
        painelBotaoPontuacoes.setBounds(750, 600, 200, 50);
        painelBotaoPontuacoes.setBackground(Color.black);

        botaoPontuacoes = new JButton("PONTUAÇÕES");
        configurarBotao(botaoPontuacoes);
        botaoPontuacoes.addActionListener(tsh);

        painelBotaoPontuacoes.add(botaoPontuacoes);
        
        painelBotaoPontuacoes.setVisible(true);

        // BOTAO PROXIMO IN-GAME
        painelBotaoProximoInGame = new JPanel();
        painelBotaoProximoInGame.setBounds(650, 500, 200, 50);
        painelBotaoProximoInGame.setBackground(Color.black);

        botaoProximoInGame = new JButton(">");
        configurarBotao(botaoProximoInGame);
        botaoProximoInGame.addActionListener(tsh);

        painelBotaoProximoInGame.add(botaoProximoInGame);

        painelBotaoProximoInGame.setVisible(false);

        // BOTAO VOLTAR DA CONFIGURACAO
        painelBotaoVoltarConfig = new JPanel();
        painelBotaoVoltarConfig.setBounds(650, 700, 200, 50);
        painelBotaoVoltarConfig.setBackground(Color.black);

        botaoVoltarConfig = new JButton("MENU");
        configurarBotao(botaoVoltarConfig);
        botaoVoltarConfig.addActionListener(tshb);

        painelBotaoVoltarConfig.add(botaoVoltarConfig);

        painelBotaoVoltarConfig.setVisible(false);

        // BOTAO VOLTAR DA PONTUACAO
        painelBotaoVoltarPontuacoes = new JPanel();
        painelBotaoVoltarPontuacoes.setBounds(650, 700, 200, 50);
        painelBotaoVoltarPontuacoes.setBackground(Color.black);

        botaoVoltarPontuacoes = new JButton("MENU");
        configurarBotao(botaoVoltarPontuacoes);
        botaoVoltarPontuacoes.addActionListener(tshb);

        painelBotaoVoltarPontuacoes.add(botaoVoltarPontuacoes);

        painelBotaoVoltarPontuacoes.setVisible(false);

        // BOTAO VOLTAR DO INICIAR
        painelBotaoVoltarIniciar = new JPanel();
        painelBotaoVoltarIniciar.setBounds(650, 700, 200, 50);
        painelBotaoVoltarIniciar.setBackground(Color.black);

        botaoVoltarIniciar = new JButton("MENU");
        configurarBotao(botaoVoltarIniciar);
        botaoVoltarIniciar.addActionListener(tshb);

        painelBotaoVoltarIniciar.add(botaoVoltarIniciar);

        painelBotaoVoltarIniciar.setVisible(false);

        // BOTAO AUMENTAR VOLUME
        painelBotaoAumentarVol = new JPanel();
        painelBotaoAumentarVol.setBounds(500, 450, 250, 50);
        painelBotaoAumentarVol.setBackground(Color.black);

        botaoAumentarVol = new JButton("AUMENTAR VOLUME");
        configurarBotao(botaoAumentarVol);
        botaoAumentarVol.addActionListener(vhu);

        painelBotaoAumentarVol.add(botaoAumentarVol);

        painelBotaoAumentarVol.setVisible(false);

        // BOTAO DIMINUIR VOLUME
        painelBotaoDiminuirVol = new JPanel();
        painelBotaoDiminuirVol.setBounds(750, 450, 250, 50);
        painelBotaoDiminuirVol.setBackground(Color.black);

        botaoDiminuirVol = new JButton("DIMINUIR VOLUME");
        configurarBotao(botaoDiminuirVol);
        botaoDiminuirVol.addActionListener(vhd);

        painelBotaoDiminuirVol.add(botaoDiminuirVol);

        painelBotaoDiminuirVol.setVisible(false);

        // BOTAO PERSONAGEM KALROK
        painelBotaoPersonagemKalrok = new JPanel();
        painelBotaoPersonagemKalrok.setBounds(550, 500, 200, 50);
        painelBotaoPersonagemKalrok.setBackground(Color.black);

        botaoPersonagemKalrok = new JButton("KALROK");
        configurarBotao(botaoPersonagemKalrok);
        botaoPersonagemKalrok.addActionListener(shk);

        painelBotaoPersonagemKalrok.add(botaoPersonagemKalrok);

        painelBotaoPersonagemKalrok.setVisible(false);

        // BOTAO PERSONAGEM LOHAN
        painelBotaoPersonagemLohan = new JPanel();
        painelBotaoPersonagemLohan.setBounds(750, 500, 200, 50);
        painelBotaoPersonagemLohan.setBackground(Color.black);

        botaoPersonagemLohan = new JButton("LOHAN");
        configurarBotao(botaoPersonagemLohan);
        botaoPersonagemLohan.addActionListener(shl);

        painelBotaoPersonagemLohan.add(botaoPersonagemLohan);

        painelBotaoPersonagemLohan.setVisible(false);

        con.add(painelTitulo);
        con.add(painelBotaoStart);
        con.add(painelBotaoConfig);
        con.add(painelBotaoPontuacoes);
        con.add(painelBotaoProximoInGame);

        con.add(painelBotaoVoltarConfig);
        con.add(painelBotaoVoltarPontuacoes);
        con.add(painelBotaoVoltarIniciar);

        con.add(painelBotaoAumentarVol);
        con.add(painelBotaoDiminuirVol);

        con.add(painelBotaoPersonagemKalrok);
        con.add(painelBotaoPersonagemLohan);

        jf.setVisible(true);
    }

    public void abrirMenu(){
        painelTitulo.setVisible(true);
        painelBotaoStart.setVisible(true);
        painelBotaoConfig.setVisible(true);
        painelBotaoPontuacoes.setVisible(true);
        painelBotaoConfig.setVisible(false);
        painelBotaoPontuacoes.setVisible(false);
        painelBotaoVoltarIniciar.setVisible(false);
        painelBotaoPersonagemKalrok.setVisible(false);
        painelBotaoPersonagemLohan.setVisible(false);
    }

    public void criarTelaJogo(){
        painelTitulo.setVisible(false);
        painelBotaoStart.setVisible(false);
        painelBotaoConfig.setVisible(false);
        painelBotaoPontuacoes.setVisible(false);
        painelBotaoVoltarConfig.setVisible(false);
        painelBotaoVoltarPontuacoes.setVisible(false);
        painelBotaoVoltarIniciar.setVisible(true);
        painelBotaoPersonagemKalrok.setVisible(true);
        painelBotaoPersonagemLohan.setVisible(true);
    }

    public void iniciarJogo(String personagem){
        painelTitulo.setVisible(false);
        painelBotaoStart.setVisible(false);
        painelBotaoConfig.setVisible(false);
        painelBotaoPontuacoes.setVisible(false);
        painelBotaoVoltarConfig.setVisible(false);
        painelBotaoVoltarPontuacoes.setVisible(false);
        painelBotaoVoltarIniciar.setVisible(false);
        painelBotaoPersonagemKalrok.setVisible(false);
        painelBotaoPersonagemLohan.setVisible(false);

        // IMAGEM DA CENA PARTE DE CIMA/MEIO
        painelImagemApartamento = new JPanel();
        painelImagemApartamento.setBounds(0, 0, larguraTJ, 100);
        painelImagemApartamento.setBackground(Color.white);

        painelImagemApartamento.setVisible(true);

        // TEXTO PARTE DEBAIXO DO JOGO
        painelTextoPadrao = new JPanel();
        painelTextoPadrao.setBounds(0, 500, larguraTJ, 400);
        painelTextoPadrao.setBackground(Color.gray);

        areaTextoPadrao = new JTextArea("olá teste");
        areaTextoPadrao.setBounds(0, 500, larguraTJ, 400);
        areaTextoPadrao.setBackground(Color.gray);
        areaTextoPadrao.setForeground(Color.white);
        areaTextoPadrao.setFont(fontePadrao);
        areaTextoPadrao.setLineWrap(true); //texto vai pra baixo automaticamente
        
        painelTextoPadrao.add(areaTextoPadrao);

        painelTextoPadrao.setVisible(true);

        con.add(painelImagemApartamento);
        con.add(painelTextoPadrao);
    }

    public void abrirConfigs(){
        painelTitulo.setVisible(false);
        painelBotaoStart.setVisible(false);
        painelBotaoConfig.setVisible(false);
        painelBotaoPontuacoes.setVisible(false);
        painelBotaoVoltarConfig.setVisible(true);
        painelBotaoAumentarVol.setVisible(true);
        painelBotaoDiminuirVol.setVisible(true);
    }

    public void abrirPontuacoes(){

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

    public void ajustarVolume(float valor){
        if(volumeControl != null){
            float volumeAtual = volumeControl.getValue();
            float novoVolume = volumeAtual + valor;

            novoVolume = Math.min(novoVolume, volumeControl.getMaximum());
            novoVolume = Math.max(novoVolume, volumeControl.getMinimum());

            volumeControl.setValue(novoVolume);
        }
    }
}
