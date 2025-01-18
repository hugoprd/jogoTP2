import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.sound.sampled.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.plaf.FontUIResource;

public class Frame extends JFrame{
    public static Frame jf = new Frame();

    public static Clip clip;
    public static FloatControl volumeControl;

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int largura = (int) screenSize.getWidth();
    public static int altura = (int) screenSize.getHeight() / 2;

    public static Clip clipSound;

    public static Clip clipTexto;

    public static JButton botaoProximo = new JButton("PROXIMO");

    private int painelAtual = 0; // indice do painel
    private static final Map<String, Integer> PAINEIS = new LinkedHashMap<>() {{
        put("apartamento", 1);
        put("sala", 2);
        put("quarto", 3);
        put("cozinha", 4);
        put("banheiro", 5);
        put("autoestima", 6);
        put("chefe", 7);
    }};

    public static Font font = new Font("Courier New", Font.PLAIN, 18);

    public static File soundEffect = new File("lib/8bitSoundEffect.wav");

    // ============== PAINEIS PRINCIPAIS ==============
    public static JPanel menu;
    public static JPanel config;
    public static JPanel iniciar;
    public static JPanel novoJogo;
    public static JPanel pontuacao;
    public static JPanel jogo;

    /*static{
        PAINEIS.put("apartamento", 0);
        PAINEIS.put("sala", 1);
        PAINEIS.put("quarto", 2);
        PAINEIS.put("cozinha", 3);
        PAINEIS.put("banheiro", 4);

        PAINEIS.put("batalhaAutoestima", 5);
        PAINEIS.put("dialogoChefe", 6);
    }*/

    public Frame(){
        super("JOGO RPG");
        //setDefaultFont(font);
    }

    public static void criarJanela(){
        // ============== DEFINICAO DAS CONFIGURACOES ==============
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(true);
        jf.setLocationRelativeTo(null);
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jf.getContentPane().setBackground(Color.black);

        jf.setLayout(new FlowLayout());
        setDefaultFont(font);

        File musica8bit1 = new File("lib/8bitmusic.wav");
        File musicaJogo = new File("lib/gameMusic.wav");

        jf.setLayout(new BorderLayout());
        Border whiteline = BorderFactory.createLineBorder(Color.white);
        Font titleFont = new Font("Courier New", Font.BOLD, 32);

        setFont();
        mudarFonte(jf, font);

        // ============== LAYOUT PARA CONTROLE DE PAINEIS ==============
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // ============== AUXILIARES PARA OS PAINEIS DO LAYOUT ==============
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int largura = (int) screenSize.getWidth();
        int altura = (int) screenSize.getHeight() / 2;

        int alturaP = (int) screenSize.getHeight() / 3;

        int alturaCT = (int) screenSize.getHeight() / 4;

        // ============== BOTOES PARA CADA PAINEL ==============
        JButton botaoConfig = new JButton("CONFIGURAÇÕES");
        configurarBotao(botaoConfig);

        JButton botaoIniciar = new JButton("INICIAR");
        configurarBotao(botaoIniciar);

        JButton botaoMenuC = new JButton("MENU"); // para as config
        configurarBotao(botaoMenuC);

        JButton botaoMenuP = new JButton("MENU"); // para as pontuacoes
        configurarBotao(botaoMenuP);

        JButton botaoMenuI = new JButton("MENU"); // para o iniciar
        configurarBotao(botaoMenuI);

        JButton botaoNJ = new JButton("NOVO JOGO");
        configurarBotao(botaoNJ);

        JButton botaoPontuacao = new JButton("PONTUAÇÕES");
        configurarBotao(botaoPontuacao);

        JButton botaoVoltarIJ = new JButton("VOLTAR");
        configurarBotao(botaoVoltarIJ);

        JButton personagemK = new JButton("KALROK");
        configurarBotao(personagemK);

        JButton personagemL = new JButton("LOHAN");
        configurarBotao(personagemL);

        configurarBotao(botaoProximo);

        // ============== PAINEL CONFIGURACOES ==============
        config = new JPanel(new BorderLayout());
        config.setForeground(Color.white);
        config.setBackground(Color.black);
        config.setOpaque(true);

        JPanel buttonPanelConfig = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanelConfig.setBackground(Color.black);

        botaoMenuC = new JButton("MENU");
        configurarBotao(botaoMenuC);

        buttonPanelConfig.add(botaoMenuC);

        config.add(buttonPanelConfig, BorderLayout.SOUTH);

        // ============== PAINEL INICIAR ==============
        iniciar = new JPanel(new BorderLayout());
        iniciar.setForeground(Color.white);
        iniciar.setBackground(Color.black);
        iniciar.setOpaque(true);

        JPanel aux = new JPanel();
        aux.setBackground(Color.black);
        aux.setPreferredSize(new Dimension(largura, altura));

        JPanel buttonPanelIniciar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanelIniciar.setBackground(Color.black);

        JPanel centralPanelIniciar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centralPanelIniciar.setBackground(Color.black);

        botaoMenuI = new JButton("MENU");
        configurarBotao(botaoMenuI);

        botaoNJ = new JButton("NOVO JOGO");
        configurarBotao(botaoNJ);

        botaoPontuacao = new JButton("PONTUAÇÕES");
        configurarBotao(botaoPontuacao);

        buttonPanelIniciar.add(botaoMenuI);
        centralPanelIniciar.add(botaoNJ);
        centralPanelIniciar.add(botaoPontuacao);

        iniciar.add(aux, BorderLayout.NORTH);

        iniciar.add(centralPanelIniciar, BorderLayout.CENTER);

        iniciar.add(buttonPanelIniciar, BorderLayout.SOUTH);

        // ============== PAINEL MENU ==============
        menu = new JPanel(new BorderLayout());
        menu.setForeground(Color.white);
        menu.setBackground(Color.black);
        menu.setOpaque(true);

        JLabel labelTitulo = new JLabel("BEM-VINDO AO ABISMO", SwingConstants.CENTER);
        labelTitulo.setForeground(Color.yellow);
        labelTitulo.setBackground(Color.black);
        labelTitulo.setOpaque(true);
        labelTitulo.setBorder(whiteline);
        labelTitulo.setFont(titleFont);
        menu.add(labelTitulo, BorderLayout.NORTH);

        JPanel buttonPanelMenu = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanelMenu.setBackground(Color.black);

        buttonPanelMenu.add(botaoConfig);
        buttonPanelMenu.add(botaoIniciar);
        menu.add(buttonPanelMenu, BorderLayout.SOUTH);

        // ============== PAINEL JOGO ==============
        jogo = new JPanel(new BorderLayout());
        jogo.setForeground(Color.white);
        jogo.setBackground(Color.black);
        jogo.setOpaque(true);

        JPanel caixaTexto = new JPanel(new BorderLayout());

        Color customColor = Color.decode("#0D0D0D");
        caixaTexto.setBackground(customColor);

        caixaTexto.setPreferredSize(new Dimension(largura, alturaCT));

        JPanel tela = new JPanel(new BorderLayout());

        tela.setBackground(Color.black);

        JPanel buttonPanelProximo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanelProximo.setOpaque(false);

        buttonPanelProximo.add(botaoProximo, BorderLayout.EAST);

        tela.add(buttonPanelProximo, BorderLayout.SOUTH);

        jogo.add(caixaTexto, BorderLayout.SOUTH);

        jogo.add(tela, BorderLayout.CENTER);

        // ============== PAINEL PONTUACOES ==============
        pontuacao = new JPanel(new BorderLayout());
        pontuacao.setForeground(Color.white);
        pontuacao.setBackground(Color.black);
        pontuacao.setOpaque(true);

        JPanel buttonPanelPontuacao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanelPontuacao.setBackground(Color.black);

        JPanel aux2 = new JPanel(new BorderLayout());
        aux2.setBackground(Color.black);

        aux2.setBackground(Color.black);
        aux2.setPreferredSize(new Dimension(largura, alturaP));

        botaoMenuP = new JButton("MENU");
        configurarBotao(botaoMenuP);

        buttonPanelPontuacao.add(botaoMenuP);

        pontuacao.add(aux2, BorderLayout.NORTH);

        pontuacao.add(buttonPanelPontuacao, BorderLayout.SOUTH);

        // ============== PAINEL SELECAO DOS PERSONAGENS (NOVO JOGO) ==============
        novoJogo = new JPanel(new BorderLayout());
        novoJogo.setForeground(Color.white);
        novoJogo.setBackground(Color.black);
        novoJogo.setOpaque(true);

        JPanel aux3 = new JPanel(new BorderLayout());
        aux3.setBackground(Color.black);

        aux3.setBackground(Color.black);
        aux3.setPreferredSize(new Dimension(largura, altura));

        JPanel buttonPanelNovoJogo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanelNovoJogo.setBackground(Color.black);

        botaoVoltarIJ = new JButton("VOLTAR");
        configurarBotao(botaoVoltarIJ);

        buttonPanelNovoJogo.add(botaoVoltarIJ);

        JPanel personagensPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        personagensPanel.setBackground(Color.black);

        personagemK = new JButton("KALROK");
        configurarBotao(personagemK);

        personagensPanel.add(personagemK);

        personagemL = new JButton("LOHAN");
        configurarBotao(personagemL);

        personagensPanel.add(personagemL);

        novoJogo.add(aux3, BorderLayout.NORTH);

        novoJogo.add(personagensPanel, BorderLayout.CENTER);

        novoJogo.add(buttonPanelNovoJogo, BorderLayout.SOUTH);

        // ============== COMODOS ==============
        JPanel painelApartamento = new JPanel(new BorderLayout());

        JPanel painelSala = new JPanel(new BorderLayout());

        JPanel painelQuarto = new JPanel(new BorderLayout());

        JPanel painelCozinha = new JPanel(new BorderLayout());

        JPanel painelBanheiro = new JPanel(new BorderLayout());

        // ============== AUTOESTIMA ==============
        JPanel painelAutoestima = new JPanel(new BorderLayout());

        // ============== CHEFE ==============
        JPanel painelChefe = new JPanel(new BorderLayout());

        // ============== CARD LAYOUT PRO MENU ==============
        // EXTRA
        JPanel vazio = new JPanel(); // Painel vazio
        vazio.setBackground(Color.black);
        cardPanel.add(vazio, "vazio");
        cardPanel.add(novoJogo, "novoJogo");
        cardPanel.add(jogo, "jogo");
        cardPanel.add(pontuacao, "pontuacao");
        cardPanel.add(menu, "menu");
        cardPanel.add(config, "configuracoes");
        cardPanel.add(iniciar, "iniciar");

        // ============== CARD LAYOUT PARA AS CENAS/TEXTOS ==============
        int i = 0;
        for (Map.Entry<String, Integer> entrada : PAINEIS.entrySet()){
            JLabel painel = new JLabel();
            //painel.setBackground(new Color(30 + 30 * i, 60 + 20 * i, 150 - 10 * i)); // Cores diferentes
            System.out.println("Feito: " + entrada.getKey() +  "(Valor: + " + entrada.getValue() + "))");
            cardPanel.add(painel, entrada.getKey());
            i++;
        }

        /*cardPanel.add(apartamento, "apartamento");
        cardPanel.add(sala, "sala");
        cardPanel.add(quarto, "quarto");
        cardPanel.add(cozinha, "cozinha");
        cardPanel.add(banheiro, "banheiro");
        cardPanel.add(autoestima, "autoestima");
        cardPanel.add(chefe, "chefe");*/

        // ============== AÇAO DOS BOTOES ==============
        // BOTOES MENU
        botaoMenuC.addActionListener(e -> {
            cardLayout.show(cardPanel, "menu");
            config.setVisible(false);
            iniciar.setVisible(false);
            novoJogo.setVisible(false);
            pontuacao.setVisible(false);
            menu.setVisible(true);
            jogo.setVisible(false);

            tocarSoundEffect(soundEffect, true);
        });

        botaoMenuI.addActionListener(e -> {
            cardLayout.show(cardPanel, "menu");
            config.setVisible(false);
            iniciar.setVisible(false);
            novoJogo.setVisible(false);
            pontuacao.setVisible(false);
            menu.setVisible(true);
            jogo.setVisible(false);

            tocarSoundEffect(soundEffect, true);
        });

        botaoMenuP.addActionListener(e -> {
            cardLayout.show(cardPanel, "menu");
            config.setVisible(false);
            iniciar.setVisible(false);
            novoJogo.setVisible(false);
            pontuacao.setVisible(false);
            menu.setVisible(true);
            jogo.setVisible(false);

            tocarSoundEffect(soundEffect, true);
        });

        // BOTAO VOLTAR
        botaoVoltarIJ.addActionListener(e -> {
            cardLayout.show(cardPanel, "novoJogo");
            config.setVisible(false);
            iniciar.setVisible(true);
            novoJogo.setVisible(false);
            pontuacao.setVisible(false);
            menu.setVisible(false);
            jogo.setVisible(false);

            tocarSoundEffect(soundEffect, true);
        });

        // BOTAO CONFIG
        botaoConfig.addActionListener(e -> {
            cardLayout.show(cardPanel, "configuracoes");
            menu.setVisible(false);
            iniciar.setVisible(false);
            config.setVisible(true);
            novoJogo.setVisible(false);
            pontuacao.setVisible(false);
            jogo.setVisible(false);

            Controle.controlVolume(config);

            tocarSoundEffect(soundEffect, true);
        });

        // BOTAO INICIAR
        botaoIniciar.addActionListener(e -> {
            cardLayout.show(cardPanel, "iniciar");
            menu.setVisible(false);
            config.setVisible(false);
            iniciar.setVisible(true);
            novoJogo.setVisible(false);
            pontuacao.setVisible(false);
            jogo.setVisible(false);

            tocarSoundEffect(soundEffect, true);
        });

        // BOTAO NOVO JOGO
        botaoNJ.addActionListener(e -> {
            cardLayout.show(cardPanel, "novoJogo");
            menu.setVisible(false);
            config.setVisible(false);
            iniciar.setVisible(false);
            pontuacao.setVisible(false);
            novoJogo.setVisible(true);
            jogo.setVisible(false);

            tocarSoundEffect(soundEffect, true);
        });

        // BOTAO PONTUACAO
        botaoPontuacao.addActionListener(e -> {
            cardLayout.show(cardPanel, "pontuacao");
            menu.setVisible(false);
            config.setVisible(false);
            iniciar.setVisible(false);
            novoJogo.setVisible(false);
            pontuacao.setVisible(true);
            jogo.setVisible(false);

            tocarSoundEffect(soundEffect, true);
        });

        // BOTOES PRA JOGO
        personagemK.addActionListener(e -> {
            menu.setVisible(false);
            config.setVisible(false);
            iniciar.setVisible(false);
            novoJogo.setVisible(false);
            pontuacao.setVisible(false);
            jogo.setVisible(true);

            Jogo.jogar("kalrok");
            //cardLayout.show(cardPanel, "vazio");

            if(clip != null && clip.isRunning()){
                clip.stop();  // para a musica do menu
            }
            tocarMusica(musicaJogo, true);

            tocarSoundEffect(soundEffect, true);
            cardLayout.show(cardPanel, "jogo");
            System.out.println("painel jogo abriu");
        });

        personagemL.addActionListener(e -> {
            menu.setVisible(false);
            config.setVisible(false);
            iniciar.setVisible(false);
            novoJogo.setVisible(false);
            pontuacao.setVisible(false);
            jogo.setVisible(true);

            Jogo.jogar("lohan");
            //cardLayout.show(cardPanel, "vazio");

            if(clip != null && clip.isRunning()){
                clip.stop();  // para a musica do menu
            }
            tocarMusica(musicaJogo, true);

            tocarSoundEffect(soundEffect, true);

            cardLayout.show(cardPanel, "jogo");
            System.out.println("painel jogo abriu");
        });

        botaoProximo.addActionListener(e -> {
            alternarPainel(cardLayout, cardPanel);

            tocarSoundEffect(soundEffect, true);
        });

        // ============== SETAGEM GERAL ==============
        cardLayout.show(cardPanel, "menu");

        jf.add(cardPanel);

        tocarMusica(musica8bit1, true);

        jf.setVisible(true);
    }

    public static void configurarBotao(JButton botao){
        botao.setForeground(Color.white);
        botao.setBackground(Color.black);
        botao.setFont(font);
        botao.setBorder(BorderFactory.createLineBorder(Color.white));
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(300, 100));
    }

    public static void addBotaoProximo(JPanel painel){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        configurarBotao(botaoProximo);
        buttonPanel.add(botaoProximo); // Adiciona o botão global ao painel
        painel.add(buttonPanel, BorderLayout.SOUTH); // Adiciona o painel com o botão na parte inferior
    }

    public static void alternarPainel(CardLayout cardLayout, JPanel cardPanel){
        int painelAtual = 0;

        configurarBotao(botaoProximo);
        System.out.println("botao configurado");

        int i = 0;
        for (Map.Entry<String, Integer> entrada : PAINEIS.entrySet()) {
            JPanel painel = new JPanel();

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(botaoProximo, BorderLayout.CENTER);

            JPanel auxTop = new JPanel();
            auxTop.setPreferredSize(new Dimension(largura, altura));
            auxTop.setOpaque(false);

            JPanel auxBot = new JPanel();
            auxBot.setPreferredSize(new Dimension(largura, altura));
            auxBot.setOpaque(false);

            painel.add(auxTop, BorderLayout.NORTH);
            painel.add(buttonPanel, BorderLayout.CENTER);
            painel.add(auxBot, BorderLayout.SOUTH);
            painel.setBackground(new Color(30 + 30 * i, 60 + 20 * i, 150 - 10 * i)); // Cores diferentes
            painel.add(new JLabel(entrada.getKey() + " (Valor: " + entrada.getValue() + ")"));
            cardPanel.add(painel, entrada.getKey());
            i++;
        }

        alternar(cardLayout, cardPanel, painelAtual);
    }

    static void alternar(CardLayout cardLayout, JPanel cardPanel, int painelAtual){
        String[] chaves = PAINEIS.keySet().toArray(new String[0]);

        painelAtual = (painelAtual + 1) % PAINEIS.size();

        cardLayout.show(cardPanel, chaves[painelAtual]);
    }

    public static void tocarVoz(File arquivo, boolean tocar){
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
    
            AudioFormat formato = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, formato);
            clipTexto = AudioSystem.getClip();
            clipTexto.open(audioStream);

            if(tocar == true){
                clipTexto.start();
    
                //clip.loop(Clip.LOOP_CONTINUOUSLY);
                volumeControl = (FloatControl) clipTexto.getControl(FloatControl.Type.MASTER_GAIN);
                System.out.println("som comecou");
            }  
            else if(tocar == false){
                clipTexto.stop();
                System.out.println("som parou");
            }  
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tocar música: " + e.getMessage());
        }
    }

    public static void tocarSoundEffect(File arquivo, boolean tocar){
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
    
            AudioFormat formato = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, formato);
            clipSound = AudioSystem.getClip();
            clipSound.open(audioStream);

            if(tocar == true){
                clipSound.start();
    
                //clip.loop(Clip.LOOP_CONTINUOUSLY);
                volumeControl = (FloatControl) clipSound.getControl(FloatControl.Type.MASTER_GAIN);
                System.out.println("som comecou");
            }  
            else if(tocar == false){
                clipSound.stop();
                System.out.println("som parou");
            }  
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tocar música: " + e.getMessage());
        }
    }

    public static void tocarMusica(File arquivo, boolean tocar){
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
    
            AudioFormat formato = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, formato);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            if(tocar == true){
                clip.start();
    
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                System.out.println("musica comecou");
            }  
            else if(tocar == false){
                clip.stop();
                System.out.println("musica parou");
            }  
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tocar música: " + e.getMessage());
        }
    }

    public static void setFont(){
        UIManager.put("Button.font", "Courier New");
        UIManager.put("ToggleButton.font", "Courier New");
        UIManager.put("RadioButton.font", "Courier New");
        UIManager.put("CheckBox.font", "Courier New");
        UIManager.put("ColorChooser.font", "Courier New");
        UIManager.put("ComboBox.font", "Courier New");
        UIManager.put("Label.font", "Courier New");
        UIManager.put("List.font", "Courier New");
        UIManager.put("MenuBar.font", "Courier New");
        UIManager.put("MenuItem.font", "Courier New");
        UIManager.put("RadioButtonMenuItem.font", "Courier New");
        UIManager.put("CheckBoxMenuItem.font", "Courier New");
        UIManager.put("Menu.font", "Courier New");
        UIManager.put("PopupMenu.font", "Courier New");
        UIManager.put("OptionPane.font", "Courier New");
        UIManager.put("Panel.font", "Courier New");
        UIManager.put("ProgressBar.font", "Courier New");
        UIManager.put("ScrollPane.font", "Courier New");
        UIManager.put("Viewport.font", "Courier New");
        UIManager.put("TabbedPane.font", "Courier New");
        UIManager.put("Table.font", "Courier New");
        UIManager.put("TableHeader.font", "Courier New");
        UIManager.put("TextField.font", "Courier New");
        UIManager.put("PasswordField.font", "Courier New");
        UIManager.put("TextArea.font", "Courier New");
        UIManager.put("TextPane.font", "Courier New");
        UIManager.put("EditorPane.font", "Courier New");
        UIManager.put("TitledBorder.font", "Courier New");
        UIManager.put("ToolBar.font", "Courier New");
        UIManager.put("ToolTip.font", "Courier New");
        UIManager.put("Tree.font", "Courier New");
    }

    public static void mudarFonte(Container container, Font fonte) {
        for (Component componente : container.getComponents()) {
            if (componente instanceof Container) {
                mudarFonte((Container) componente, fonte);
            }
            componente.setFont(fonte);
        }
    }

    public static void setDefaultFont(Font defaultFont){

        FontUIResource font = new FontUIResource(defaultFont);

        Enumeration uiManagerKeys = UIManager.getDefaults().keys();
        while(uiManagerKeys.hasMoreElements()){
            Object key   = uiManagerKeys.nextElement(),
                value = UIManager.get(key);

            if(null != value && value instanceof FontUIResource)
                UIManager.put(key, font);
        }
    }
}
