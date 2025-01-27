package main;

import saves.SalvamentoJogo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PainelJogo {
    JFrame jf;
    Container con;

    Jogo jogo = new Jogo(this);

    String nomeJogador = "";

    long pontuacao;

    long tempoInicial = System.currentTimeMillis();
    long tempoFinal;
    long tempoTotal = tempoInicial - tempoFinal;
    //long segundos = (tempoTotal / 1000) % 60;
    //long minutos = (tempoTotal / (1000 * 60)) % 60;
    //long horas = (tempoTotal / (1000 * 60 * 60)) % 24;

    // menu
    JPanel painelTitulo, painelBotaoStart, painelBotaoConfig, painelBotaoPontuacoes, painelTituloTabPontuacoes;
    JPanel painelBotaoVoltarConfig, painelBotaoVoltarPontuacoes, painelBotaoVoltarIniciar;
    // tela de botar o nome
    JPanel painelTituloNomeJogador, painelNomeJogador, painelBotaoConfirmarNome, painelBotaoVoltarNome;
    // tela de escolher o personagem
    JPanel painelTituloEscolherPersonagem;
    JPanel painelBotaoPersonagemKalrok, painelBotaoPersonagemLohan;
    JPanel painelBotaoAumentarVol, painelBotaoDiminuirVol;
    // in-game
    JPanel painelTextoPadrao;
    JPanel painelBotaoProximoInGame;
    // player
    JPanel playerPanel;
    JPanel painelTituloPersonagemInventario, painelPersonagemInventario, painelPersonagemBotaoVoltarInventario;
    // cenas
    JPanel painelImagemComodo, painelImagemApartamento, painelImagemSala, painelImagemCozinha, painelImagemQuarto, painelImagemBanheiro;
    JPanel painelImagemAutoestima, painelImagemChefe;

    // menu
    JLabel tituloJogo;
    JLabel tituloTabPontuacoes;
    // tela botar nome
    JLabel tituloNomeJogador;
    JTextField inputNomeJogador;
    // escolha de personagem
    JLabel tituloEscolherPersonagem;
    // player
    JLabel nomePersonagemLabel, textoNomePersonagemLabel, idadePersonagemLabel, 
    numeroIdadePersonagemLabel, energiaPersonagemLabel, numeroEnergiaPersonagemLabel;
    JLabel tituloPersonagemInventario;

    JTextArea areaTextoPadrao;

    Font fonteTitulo = new Font("Courier New", Font.BOLD, 32);
    Font fontePadrao = new Font("Courier New", Font.PLAIN, 18);

    JButton botaoStart, botaoConfig, botaoPontuacoes;
    JButton botaoProximoInGame;
    JButton botaoVoltarConfig, botaoVoltarPontuacoes, botaoVoltarIniciar, botaoVoltarNome;
    JButton botaoConfirmarNome;
    JButton botaoPersonagemKalrok, botaoPersonagemLohan;
    JButton botaoAumentarVol, botaoDiminuirVol;
    JButton personagemBotaoUsarHabilidade, personagemBotaoInventario, personagemBotaoVoltarInventario;

    // menu
    TitleScreenHandler tsh = new TitleScreenHandler(this);
    TitleScreenHandlerB tshb = new TitleScreenHandlerB(this);
    // config
    ConfigHandler ch = new ConfigHandler(this);
    // aumentar diminuir volume
    VolHandlerUp vhu = new VolHandlerUp(this);
    VolHandlerDown vhd = new VolHandlerDown(this);
    // som de click
    public ClickSoundHandler csh = new ClickSoundHandler(this);
    // pontuacao
    PontuacaoHandler ph = new PontuacaoHandler(this);
    // start handler: kalrok || lohan
    StartHandlerK shk = new StartHandlerK(this);
    StartHandlerL shl = new StartHandlerL(this);

    public Clip clip, clip2, clipClickSound;
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
        botaoPontuacoes.addActionListener(ph);

        painelBotaoPontuacoes.add(botaoPontuacoes);
        
        painelBotaoPontuacoes.setVisible(true);

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

        botaoVoltarIniciar = new JButton("VOLTAR");
        configurarBotao(botaoVoltarIniciar);
        botaoVoltarIniciar.addActionListener(tshb);

        painelBotaoVoltarIniciar.add(botaoVoltarIniciar);

        painelBotaoVoltarIniciar.setVisible(false);

        // BOTAO VOLTAR DO NOME
        painelBotaoVoltarNome = new JPanel();
        painelBotaoVoltarNome.setBounds(650, 700, 200, 50);
        painelBotaoVoltarNome.setBackground(Color.black);

        botaoVoltarNome = new JButton("MENU");
        configurarBotao(botaoVoltarNome);
        botaoVoltarNome.addActionListener(e -> {
            csh.tocarClickSound();
            abrirMenu();
        });

        painelBotaoVoltarNome.add(botaoVoltarNome);

        painelBotaoVoltarNome.setVisible(false);

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

        // TELA BOTAR NOME
        painelTituloNomeJogador = new JPanel();
        painelTituloNomeJogador.setBounds(500, 50, 500, 100);
        painelTituloNomeJogador.setBackground(Color.black);
        painelTituloNomeJogador.setForeground(Color.white);

        tituloNomeJogador = new JLabel("COLOQUE SEU NOME:");
        tituloNomeJogador.setBackground(Color.black);
        tituloNomeJogador.setForeground(Color.white);
        tituloNomeJogador.setFont(fonteTitulo);

        painelTituloNomeJogador.add(tituloNomeJogador, BorderLayout.CENTER);

        painelTituloNomeJogador.setVisible(false);

        painelNomeJogador = new JPanel();
        painelNomeJogador.setBounds(500, 150, 500, 200);
        painelNomeJogador.setBackground(Color.black);
        painelNomeJogador.setForeground(Color.white);
        painelNomeJogador.setLayout(new FlowLayout());

        inputNomeJogador = new JTextField(20);
        inputNomeJogador.setBackground(Color.white);
        inputNomeJogador.setForeground(Color.black);
        inputNomeJogador.setFont(fontePadrao);

        painelNomeJogador.add(inputNomeJogador, BorderLayout.CENTER);

        painelNomeJogador.setVisible(false);

        painelBotaoConfirmarNome = new JPanel();
        painelBotaoConfirmarNome.setBounds(650, 600, 200, 50);
        painelBotaoConfirmarNome.setBackground(Color.black);
        painelBotaoConfirmarNome.setForeground(Color.white);

        botaoConfirmarNome = new JButton("CONFIRMAR");
        configurarBotao(botaoConfirmarNome);
        botaoConfirmarNome.addActionListener(e -> {
            if(inputNomeJogador.getText() != null){
                csh.tocarClickSound();
                nomeJogador = inputNomeJogador.getText().trim();
                if(nomeJogador.isEmpty() || nomeJogador.length() > 20){
                    System.out.println("o campo de texto nao pode estar vazio e nao pode ter mais de 20 caracteres");
                }
                else{
                    criarTelaJogo();
                }
            }
            else{
                System.out.println("digite um nome válido e preencha o input");
            }
        });

        painelBotaoConfirmarNome.add(botaoConfirmarNome);

        painelBotaoConfirmarNome.setVisible(false);

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

        // MENU DO JOGO
        con.add(painelTitulo);
        con.add(painelBotaoStart);
        con.add(painelBotaoConfig);
        con.add(painelBotaoPontuacoes);

        // BOTOES DE VOLTAR PARA O MENU NOS MISC DO JOGO
        con.add(painelBotaoVoltarConfig);
        con.add(painelBotaoVoltarPontuacoes);
        con.add(painelBotaoVoltarIniciar);

        // CONFIG DO JOGO
        con.add(painelBotaoAumentarVol);
        con.add(painelBotaoDiminuirVol);

        // INPUT DO NOME
        con.add(painelTituloNomeJogador);
        con.add(painelNomeJogador);
        con.add(painelBotaoConfirmarNome);
        con.add(painelBotaoVoltarNome);

        // INICIO DO JOGO: SELECAO DE PERSONAGENS
        con.add(painelBotaoPersonagemKalrok);
        con.add(painelBotaoPersonagemLohan);

        jf.setVisible(true);
    }

    public void abrirMenu(){
        painelTitulo.setVisible(true);
        painelBotaoStart.setVisible(true);
        painelBotaoConfig.setVisible(true);
        painelBotaoPontuacoes.setVisible(true);
        painelBotaoVoltarIniciar.setVisible(false);
        painelBotaoVoltarConfig.setVisible(false);
        painelBotaoPersonagemKalrok.setVisible(false);
        painelBotaoPersonagemLohan.setVisible(false);
        painelBotaoAumentarVol.setVisible(false);
        painelBotaoDiminuirVol.setVisible(false);
        if(painelTituloTabPontuacoes != null){
            painelTituloTabPontuacoes.setVisible(false);
        }
        if(playerPanel != null){
            playerPanel.setVisible(false);
        }
        painelTituloNomeJogador.setVisible(false);
        painelNomeJogador.setVisible(false);
        painelBotaoConfirmarNome.setVisible(false);
        painelBotaoVoltarNome.setVisible(false);
        painelTituloEscolherPersonagem.setVisible(false);
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
        if(painelTituloTabPontuacoes != null){
            painelTituloTabPontuacoes.setVisible(false);
        }
        if(playerPanel != null){
            playerPanel.setVisible(false);
        }
        painelTituloNomeJogador.setVisible(false);
        painelNomeJogador.setVisible(false);
        painelBotaoConfirmarNome.setVisible(false);
        painelBotaoVoltarNome.setVisible(false);

        painelTituloEscolherPersonagem = new JPanel();
        painelTituloEscolherPersonagem.setBounds(500, 50, 400, 100);
        painelTituloEscolherPersonagem.setBackground(Color.black);

        tituloEscolherPersonagem = new JLabel();
        tituloEscolherPersonagem.setText("Bem-vindo(a) " + nomeJogador);
        tituloEscolherPersonagem.setBackground(Color.black);
        tituloEscolherPersonagem.setForeground(Color.white);
        tituloEscolherPersonagem.setFont(fonteTitulo);

        painelTituloEscolherPersonagem.add(tituloEscolherPersonagem);

        painelTituloEscolherPersonagem.setVisible(true);

        con.add(painelTituloEscolherPersonagem);

        con.repaint();
    }

    public void abrirTelaInputNome(){
        painelTitulo.setVisible(false);
        painelBotaoStart.setVisible(false);
        painelBotaoConfig.setVisible(false);
        painelBotaoPontuacoes.setVisible(false);
        painelBotaoVoltarConfig.setVisible(false);
        painelBotaoVoltarPontuacoes.setVisible(false);
        painelBotaoVoltarIniciar.setVisible(false);
        painelBotaoPersonagemKalrok.setVisible(false);
        painelBotaoPersonagemLohan.setVisible(false);
        painelTituloNomeJogador.setVisible(true);
        painelNomeJogador.setVisible(true);
        painelBotaoConfirmarNome.setVisible(true);
        painelBotaoVoltarNome.setVisible(true);
        if(painelTituloTabPontuacoes != null){
            painelTituloTabPontuacoes.setVisible(false);
        }
        if(painelTituloEscolherPersonagem != null){
            painelTituloEscolherPersonagem.setVisible(false);
        }
    }

    public void iniciarJogo(String nomePersonagem){
        painelTitulo.setVisible(false);
        painelBotaoStart.setVisible(false);
        painelBotaoConfig.setVisible(false);
        painelBotaoPontuacoes.setVisible(false);
        painelBotaoVoltarConfig.setVisible(false);
        painelBotaoVoltarPontuacoes.setVisible(false);
        painelBotaoVoltarIniciar.setVisible(false);
        painelBotaoPersonagemKalrok.setVisible(false);
        painelBotaoPersonagemLohan.setVisible(false);
        if(painelTituloTabPontuacoes != null){
            painelTituloTabPontuacoes.setVisible(false);
        }
        painelTituloEscolherPersonagem.setVisible(false);

        jogo.definirPersonagem(nomePersonagem);
        jogo.telaPadraoJogo();
    }

    public void abrirConfigs(){
        painelTitulo.setVisible(false);
        painelBotaoStart.setVisible(false);
        painelBotaoConfig.setVisible(false);
        painelBotaoPontuacoes.setVisible(false);
        painelBotaoVoltarConfig.setVisible(true);
        painelBotaoAumentarVol.setVisible(true);
        painelBotaoDiminuirVol.setVisible(true);
        if(painelTituloTabPontuacoes != null){
            painelTituloTabPontuacoes.setVisible(false);
        }
        if(playerPanel != null){
            playerPanel.setVisible(false);
        }
    }

    public void abrirPontuacoes(){
        painelTitulo.setVisible(false);
        painelBotaoStart.setVisible(false);
        painelBotaoConfig.setVisible(false);
        painelBotaoPontuacoes.setVisible(false);
        painelBotaoVoltarConfig.setVisible(false);
        painelBotaoAumentarVol.setVisible(false);
        painelBotaoDiminuirVol.setVisible(false);
        painelBotaoVoltarPontuacoes.setVisible(true);
        if(playerPanel != null){
            playerPanel.setVisible(false);
        }

        // titulo tabela
        painelTituloTabPontuacoes = new JPanel();
        painelTituloTabPontuacoes.setBounds(500, 50, 500, 75);
        painelTituloTabPontuacoes.setBackground(Color.black);

        tituloTabPontuacoes = new JLabel("PONTUAÇÕES:");
        tituloTabPontuacoes.setForeground(Color.white);
        tituloTabPontuacoes.setFont(fonteTitulo);

        painelTituloTabPontuacoes.add(tituloTabPontuacoes);

        //conteudo tabela

        con.add(painelTituloTabPontuacoes);
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
            System.out.println("Volume ajustado: " + valor);
        }
    }
}
