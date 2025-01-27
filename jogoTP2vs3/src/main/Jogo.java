package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import entidade.Item;

public class Jogo extends JFrame{
    PainelJogo pj;

    PersonagemJogavel protagonista;
    Autoestima autoestima;

    public Jogo(PainelJogo pj){
        this.pj = pj;
    }

    public enum PersonagemJogavel{
        KALROK("kalrok", 54, 40, "/src/lib/sounds/textSounds/somTextoKalrok.wav"){
            @Override
            public void contarHistoria(){
                System.out.println("Kalrok é um rato detetive que trabalha em um departamento, porém é desvalorizado constantemente e por isso tem objetivo de mudar de vida.");
            }

            @Override
            public void utilizarPoder(){
                System.out.println("Nome do poder: Investigação do roedor\nDescrição: Perde dez (10) de energia para conseguir ver com mais facilidade as coisas escondidas");
            }

            @Override
            public void adicionarItem(Item itemX){
                inventario.add(itemX);
            }
        },
        LOHAN("lohan", 24, 50, "/src/lib/sounds/textSounds/somTextoLohan.wav"){
            @Override
            public void contarHistoria(){
                System.out.println("Lohan é um furão que sonha em se tornar um grande investigador e entrou recentemente neste ramo. Atualmente, trabalha para Kalrok onde é seu ajudante nos casos.");
            }
        
            @Override
            public void utilizarPoder(){
                System.out.println("Nome do poder: Mente de aço\nDescrição: Perde vinte (20) de energia para conseguir esquivar de um ataque inimigo");
            }
        
            @Override
            public void adicionarItem(Item itemX){
                inventario.add(itemX);
            }
        };

        protected String nome;
        protected int idade;
        protected int energia;
        protected ArrayList<Item> inventario = new ArrayList<>();
        protected String caminhoSom;
        protected File som;

        PersonagemJogavel(String nome, int idade, int energia, String caminhoSom){
            this.nome = nome;
            this.idade = idade;
            this.energia = energia;
            this.caminhoSom = caminhoSom;
            setSom(getCaminhoSom());
        }

        public abstract void contarHistoria();
        public abstract void utilizarPoder();
        public abstract void adicionarItem(Item itemX);

        public String getNome() {
            return nome;
        }

        public int getIdade(){
            return idade;
        }

        public int getEnergia() {
            return energia;
        }

        public String getCaminhoSom(){
            return caminhoSom;
        }

        public void setSom(String caminhoSom){
            try{
                System.out.println("carregando o som");
                this.som = new File(caminhoSom);
                System.out.println("som carregado");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        public static PersonagemJogavel fromNome(String nome) {
            for (PersonagemJogavel p : values()) {
                if (p.getNome().equalsIgnoreCase(nome)) {
                    return p;
                }
            }
            throw new IllegalArgumentException("Personagem desconhecido: " + nome);
        }
    }

    public enum Comodo{
        APARTAMENTO("apartamento", "src/lib/imagens/cenaApartamento1.png"),
        SALA("sala", "src/lib/imagens/cenaSala1.png"),
        QUARTO("quarto", "src/lib/imagens/cenaQuarto1.png"),
        COZINHA("cozinha", "src/lib/imagens/cenaCozinha1.png"),
        BANHEIRO("banheiro", "src/lib/imagens/cenaBanheiro1.png");

        protected String nome;
        protected String caminhoImagem1;
        protected ArrayList<Item> itens = new ArrayList<>();
        
        protected BufferedImage img1;

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenSize = toolkit.getScreenSize();

        Comodo(String nome, String caminhoImagem1){
            setNome(nome);
            setCaminhoImagem1(caminhoImagem1);
            setImagens(getCaminhoImagem1());
            getImagem();
        }

        public String getNome(){
            return nome;
        }

        public boolean setNome(String nome){
            if(nome.length() > 0){
                this.nome = nome;

                return true;
            }

            return false;
        }

        public String getCaminhoImagem1(){
            return caminhoImagem1;
        }

        public boolean setCaminhoImagem1(String caminhoImagem1){
            if(caminhoImagem1.length() > 0){
                this.caminhoImagem1 = caminhoImagem1;

                return true;
            }

            return false;
        }

        public void getImagem(){
            try{
                System.out.println("carregando as imagens");
                img1 = ImageIO.read(getClass().getResourceAsStream(getCaminhoImagem1()));
                System.out.println("imagens carregadas");
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

        public void setImagens(String caminhoImagem1){
            try{
                img1 = ImageIO.read(getClass().getResourceAsStream(caminhoImagem1));
            }
            catch(Exception e){
                //e.setStackTrace(null);
            }
        }

        public static Comodo fromNome(String nome) {
            for (Comodo p : values()) {
                if (p.getNome().equalsIgnoreCase(nome)) {
                    return p;
                }
            }
            throw new IllegalArgumentException("Comodo desconhecido: " + nome);
        }
    }

    public enum Autoestima{
        AUTOESTIMAK(50, 5, "/src/lib/imagens/autoestimaKalrok.png", "/src/lib/sounds/textSounds/somTextoAutoestima.wav"),
        AUTOESTIMAL(50, 5, "/src/lib/imagens/autoestimaLohan.png", "/src/lib/sounds/textSounds/somTextoAutoestima.wav");

        protected int vida;
        protected int dano;
        
        protected String caminhoImagem;
        protected String caminhoSom;
        
        protected File imagemAutoestima;
        protected File somAutoestima;

        Autoestima(int vida, int dano, String caminhoImagem, String caminhoSom){
            setVida(vida);
            setDano(dano);
            setCaminhoImagem(caminhoImagem);
            setCaminhoSom(caminhoSom);
            setImagem(getCaminhoImagem());
            setSom(getCaminhoSom());
        }
        
        public int getVida(){
            return vida;
        }

        public boolean setVida(int vida){
            if(vida > 0){
                this.vida = vida;

                return true;
            }

            return false;
        }

        public int getDano(){
            return dano;
        }

        public boolean setDano(int dano){
            if(dano > 0){
                this.dano = dano;

                return true;
            }

            return false;
        }

        public String getCaminhoImagem(){
            return caminhoImagem;
        }

        public boolean setCaminhoImagem(String caminhoImagem){
            if(caminhoImagem.length() > 0){
                this.caminhoImagem = caminhoImagem;

                return true;
            }

            return false;
        }

        public File getImagem(){
            return imagemAutoestima;
        }

        public void setImagem(String caminhoImagem){
            try{
                this.imagemAutoestima = new File(caminhoImagem);
            }
            catch(Exception e){
                e.setStackTrace(null);
            }
        }

        public String getCaminhoSom(){
            return caminhoSom;
        }

        public boolean setCaminhoSom(String caminhoSom){
            if(caminhoSom.length() > 0){
                this.caminhoSom = caminhoSom;

                return true;
            }

            return false;
        }

        public boolean setSom(String caminhoSom){
            try{
                this.somAutoestima = new File(caminhoSom);

                return true;
            }
            catch(Exception e){
                throw e;
            }
        }

        public static Autoestima fromNome(String caminhoImagem){
            for (Autoestima p : values()) {
                if (p.getCaminhoImagem().equalsIgnoreCase(caminhoImagem)){
                    return p;
                }
            }
            throw new IllegalArgumentException("Autoestima desconhecida: " + caminhoImagem);
        }
    }

    public void definirPersonagem(String nomePersonagem){
        protagonista = PersonagemJogavel.fromNome(nomePersonagem);

        if(protagonista.getNome().equals("kalrok")){
            autoestima = Autoestima.fromNome("/src/lib/imagens/autoestimaKalrok.png");
        }
        else if(protagonista.getNome().equals("lohan")){
            autoestima = Autoestima.fromNome("/src/lib/imagens/autoestimaLohan.png");
        }

        System.out.printf("\nPersonagem selecionado:\nNome: %s\nIdade: %d\nEnergia: %d\n", protagonista.getNome(),
        protagonista.getIdade(), protagonista.getEnergia());
        System.out.printf("\nAutoestima correspondente:\nCaminho imagem: %s\n", autoestima.getCaminhoImagem());
    }

    public void telaComecoJogo(){

    }

    public void telaPadraoJogo(){
        // PARTE DE CIMA: STATUS DO PLAYER
        pj.playerPanel = new JPanel();
        pj.playerPanel.setBounds(0, 0, pj.larguraTJ, 50);
        pj.playerPanel.setBackground(Color.blue);
        pj.playerPanel.setLayout(new GridLayout(1, 7));

        pj.nomePersonagemLabel = new JLabel("PERSONAGEM:");
        pj.nomePersonagemLabel.setBackground(Color.black);
        pj.nomePersonagemLabel.setForeground(Color.white);
        pj.nomePersonagemLabel.setFont(pj.fontePadrao);

        pj.textoNomePersonagemLabel = new JLabel(protagonista.getNome());
        pj.textoNomePersonagemLabel.setBackground(Color.black);
        pj.textoNomePersonagemLabel.setForeground(Color.white);
        pj.textoNomePersonagemLabel.setFont(pj.fontePadrao);

        pj.idadePersonagemLabel = new JLabel("IDADE:");
        pj.idadePersonagemLabel.setBackground(Color.black);
        pj.idadePersonagemLabel.setForeground(Color.white);
        pj.idadePersonagemLabel.setFont(pj.fontePadrao);

        pj.numeroIdadePersonagemLabel = new JLabel("" + protagonista.getIdade());
        pj.numeroIdadePersonagemLabel.setBackground(Color.black);
        pj.numeroIdadePersonagemLabel.setForeground(Color.white);
        pj.numeroIdadePersonagemLabel.setFont(pj.fontePadrao);

        pj.energiaPersonagemLabel = new JLabel("ENERGIA:");
        pj.energiaPersonagemLabel.setBackground(Color.black);
        pj.energiaPersonagemLabel.setForeground(Color.white);
        pj.energiaPersonagemLabel.setFont(pj.fontePadrao);

        pj.numeroEnergiaPersonagemLabel = new JLabel("" + protagonista.getEnergia());
        pj.numeroEnergiaPersonagemLabel.setBackground(Color.black);
        pj.numeroEnergiaPersonagemLabel.setForeground(Color.white);
        pj.numeroEnergiaPersonagemLabel.setFont(pj.fontePadrao);

        pj.personagemBotaoInventario = new JButton("INVENTÁRIO");
        pj.configurarBotao(pj.personagemBotaoInventario);
        pj.personagemBotaoInventario.addActionListener(e -> {
            abrirInventario();
        });

        pj.playerPanel.add(pj.nomePersonagemLabel);
        pj.playerPanel.add(pj.textoNomePersonagemLabel);
        pj.playerPanel.add(pj.idadePersonagemLabel);
        pj.playerPanel.add(pj.numeroIdadePersonagemLabel);
        pj.playerPanel.add(pj.energiaPersonagemLabel);
        pj.playerPanel.add(pj.numeroEnergiaPersonagemLabel);
        pj.playerPanel.add(pj.personagemBotaoInventario);

        pj.playerPanel.setVisible(true);

        // PAINEL INVENTARIO -> OUTRA PAGINA
        pj.painelTituloPersonagemInventario = new JPanel();
        pj.painelTituloPersonagemInventario.setBounds(550, 50, 300, 30);
        pj.painelTituloPersonagemInventario.setBackground(Color.blue);
        
        pj.tituloPersonagemInventario = new JLabel("INVENTÁRIO");
        pj.tituloPersonagemInventario.setBackground(Color.black);
        pj.tituloPersonagemInventario.setForeground(Color.white);
        pj.tituloPersonagemInventario.setFont(pj.fontePadrao);

        pj.painelTituloPersonagemInventario.add(pj.tituloPersonagemInventario);

        pj.painelTituloPersonagemInventario.setVisible(false);

        pj.painelPersonagemInventario = new JPanel();
        pj.painelPersonagemInventario.setBounds(550, 80, 600, 700);
        pj.painelPersonagemInventario.setBackground(Color.yellow);
        pj.painelPersonagemInventario.setForeground(Color.white);
        pj.painelPersonagemInventario.setLayout(new GridLayout(5, 1));
        pj.painelPersonagemInventario.setFont(pj.fontePadrao);

        pj.painelPersonagemInventario.setVisible(false);

        pj.painelPersonagemBotaoVoltarInventario = new JPanel();
        pj.painelPersonagemBotaoVoltarInventario.setBounds(550, 830, 200, 50);
        pj.painelPersonagemBotaoVoltarInventario.setBackground(Color.red);
        
        pj.personagemBotaoVoltarInventario = new JButton("VOLTAR");
        pj.configurarBotao(pj.personagemBotaoVoltarInventario);
        pj.personagemBotaoInventario.addActionListener(e -> {
            voltarPainelJogo();
        });

        pj.painelPersonagemBotaoVoltarInventario.add(pj.personagemBotaoVoltarInventario);

        pj.painelPersonagemBotaoVoltarInventario.setVisible(false);

        // IMAGEM DA CENA PARTE DE CIMA/MEIO
        pj.painelImagemComodo = new JPanel();
        pj.painelImagemComodo.setBounds(0, 50, pj.larguraTJ, 400);
        pj.painelImagemComodo.setBackground(Color.white);

        pj.painelImagemComodo.setVisible(true);

        // PARTE DO MEIO: BOTAO PROXIMO
        pj.painelBotaoProximoInGame = new JPanel();
        pj.painelBotaoProximoInGame.setBounds(650, 455, 50, 40);
        pj.painelBotaoProximoInGame.setBackground(Color.black);

        pj.botaoProximoInGame = new JButton(">");
        pj.configurarBotao(pj.botaoProximoInGame);
        //botaoProximoInGame.addActionListener(bph); // botao proximo handler

        pj.painelBotaoProximoInGame.add(pj.botaoProximoInGame);

        pj.painelBotaoProximoInGame.setVisible(true);

        // TEXTO PARTE DEBAIXO DO JOGO
        pj.painelTextoPadrao = new JPanel();
        pj.painelTextoPadrao.setBounds(0, 500, pj.larguraTJ, 700);
        pj.painelTextoPadrao.setBackground(Color.gray);

        pj.areaTextoPadrao = new JTextArea("olá teste");
        pj.areaTextoPadrao.setBounds(35, 500, pj.larguraTJ - 35, 700);
        pj.areaTextoPadrao.setBackground(Color.gray);
        pj.areaTextoPadrao.setForeground(Color.white);
        pj.areaTextoPadrao.setFont(pj.fontePadrao);
        pj.areaTextoPadrao.setLineWrap(true); //texto vai pra baixo automaticamente
        
        pj.painelTextoPadrao.add(pj.areaTextoPadrao);

        pj.painelTextoPadrao.setVisible(true);

        pj.con.add(pj.playerPanel);
        pj.con.add(pj.painelImagemComodo);
        pj.con.add(pj.painelBotaoProximoInGame);
        pj.con.add(pj.painelTextoPadrao);

        pj.con.repaint();
    }

    public void abrirInventario(){
        pj.csh.tocarClickSound();

        pj.playerPanel.setVisible(false);
        pj.painelImagemComodo.setVisible(false);
        pj.painelBotaoProximoInGame.setVisible(false);
        pj.painelTextoPadrao.setVisible(false);

        if(protagonista.inventario != null && protagonista.inventario.size() > 0){
            for(Item itemX : protagonista.inventario){
                JLabel itemXLabel = new JLabel(itemX.getNome());

                pj.painelPersonagemInventario.add(itemXLabel);

                pj.painelPersonagemInventario.revalidate();
                pj.painelPersonagemInventario.repaint();
            }
        }

        pj.painelTituloPersonagemInventario.setVisible(true);
        pj.painelPersonagemInventario.setVisible(true);
        pj.painelPersonagemBotaoVoltarInventario.setVisible(true);
    }

    public void voltarPainelJogo(){
        pj.csh.tocarClickSound();
        
        pj.playerPanel.setVisible(true);
        pj.painelImagemComodo.setVisible(true);
        pj.painelBotaoProximoInGame.setVisible(true);
        pj.painelTextoPadrao.setVisible(true);
        pj.painelTituloPersonagemInventario.setVisible(false);
        pj.painelPersonagemInventario.setVisible(false);
        pj.painelPersonagemBotaoVoltarInventario.setVisible(false);

        pj.painelPersonagemInventario.removeAll();
        pj.painelPersonagemInventario.revalidate();
        pj.painelPersonagemInventario.repaint();
    }
}
