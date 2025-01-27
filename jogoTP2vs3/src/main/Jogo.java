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

    public Jogo(PainelJogo pj){
        this.pj = pj;
    }

    public enum PersonagemJogavel{
        KALROK("kalrok", 54, 50, "/src/lib/sounds/textSounds/somTextoKalrok.wav"),
        LOHAN("lohan", 24, 35, "/src/lib/sounds/textSounds/somTextoLohan.wav");

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

    }

    public void telaComecoJogo(){

    }

    public void telaPadraoJogo(){
        // PARTE DE CIMA: STATUS DO PLAYER
        pj.playerPanel = new JPanel();
        pj.playerPanel.setBounds(0, 0, pj.larguraTJ, 50);
        pj.playerPanel.setBackground(Color.blue);
        pj.playerPanel.setLayout(new GridLayout(1, 5));

        pj.nomePersonagemLabel = new JLabel("PERSONAGEM:");
        pj.nomePersonagemLabel.setBackground(Color.black);
        pj.nomePersonagemLabel.setForeground(Color.white);
        pj.nomePersonagemLabel.setFont(pj.fontePadrao);

        pj.textoNomePersonagemLabel = new JLabel(nomePersonagem);
        pj.textoNomePersonagemLabel.setBackground(Color.black);
        pj.textoNomePersonagemLabel.setForeground(Color.white);
        pj.textoNomePersonagemLabel.setFont(pj.fontePadrao);

        pj.energiaPersonagemLabel = new JLabel("ENERGIA:");
        pj.energiaPersonagemLabel.setBackground(Color.black);
        pj.energiaPersonagemLabel.setForeground(Color.white);
        pj.energiaPersonagemLabel.setFont(pj.fontePadrao);

        pj.numeroEnergiaPersonagemLabel = new JLabel("50");
        pj.numeroEnergiaPersonagemLabel.setBackground(Color.black);
        pj.numeroEnergiaPersonagemLabel.setForeground(Color.white);
        pj.numeroEnergiaPersonagemLabel.setFont(pj.fontePadrao);

        pj.personagemBotaoInventario = new JButton("INVENTÁRIO");
        pj.configurarBotao(pj.personagemBotaoInventario);
        //pj.personagemBotaoInventario.addActionListener(bih); // botao inventario handler

        pj.playerPanel.add(pj.nomePersonagemLabel);
        pj.playerPanel.add(pj.textoNomePersonagemLabel);
        pj.playerPanel.add(pj.energiaPersonagemLabel);
        pj.playerPanel.add(pj.numeroEnergiaPersonagemLabel);
        pj.playerPanel.add(pj.personagemBotaoInventario);

        pj.playerPanel.setVisible(true);

        // IMAGEM DA CENA PARTE DE CIMA/MEIO
        pj.painelImagemApartamento = new JPanel();
        pj.painelImagemApartamento.setBounds(0, 50, pj.larguraTJ, 400);
        pj.painelImagemApartamento.setBackground(Color.white);

        pj.painelImagemApartamento.setVisible(true);

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
        pj.con.add(pj.painelImagemApartamento);
        pj.con.add(pj.painelBotaoProximoInGame);
        pj.con.add(pj.painelTextoPadrao);

        pj.con.repaint();
    }
}
