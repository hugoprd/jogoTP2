package main;

import entidade.Item;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Jogo extends JFrame{
    PainelJogo pj;

    PersonagemJogavel protagonista;
    Autoestima autoestima;

    // itens dos comodos
    Item pedacoQueijo = new Item("queijo", 5, 1, false); // dentro da geladeira da cozinha
    Item caixaLeite = new Item("leite", 2, 1, false); // dentro da geladeira da cozinha
    Item peCabra = new Item("peDeCabra", 0, 3, false); // dentro de uma costura da poltrona da sala
    Item garrafaCerveja = new Item("cerveja", 3, 2, false); // dentro de um armario da cozinha
    Item clipePapel = new Item("clipe", 0, 3, false); // dentro da gaveta da cabiceira do quarto

    // pistas
    Item facaSangue = new Item("facaEnsanguentada", 0, 2, true); // debaixo da cama
    Item papelSangue = new Item("papelEnsanguentado", 0, 4, true); // atras de uma parede falsa
                                                                                                        // no fundo do guarda-roupa
                                                                                                        // no quarto !precisa ter
                                                                                                        // pé de cabra para abrir
    int escalaXY = 128 * 3;
    
    Color corKalrok = Color.decode("#c04849");
    Color corLohan = Color.decode("#480049");

    public Jogo(PainelJogo pj){
        this.pj = pj;
    }

    public enum PersonagemJogavel{
        KALROK("kalrok", 54, 40, "/src/lib/sounds/textSounds/somTextoKalrok.wav", false){
            @Override
            public void contarHistoria(){
                System.out.println("Kalrok é um rato detetive que trabalha em um departamento, porém é desvalorizado constantemente e por isso tem objetivo de mudar de vida.");
            }

            @Override
            public void utilizarPoder(){
                System.out.println("Nome do poder: Investigação do roedor\nDescrição: Perde dez (10) de energia para conseguir ver com mais facilidade as coisas escondidas");
                if(energia >= 10){
                    energia -= 10;
                    for(Item x : inventario){
                        if(x.getDificuldadeAchar() >= 2){
                            x.setDificuldadeAchar(x.getDificuldadeAchar() - 2);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "VOCÊ PERDEU 10 DE ENERGIA, MAS AGORA ACHARÁ ITENS COM MAIS FACILIDADE", "Investigação do Roedor", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Perdeu 10 de energia e fez o efeito"); 
                }               
            }

            @Override
            public void adicionarItem(Item itemX){
                inventario.add(itemX);
            }
        },
        LOHAN("lohan", 24, 50, "/src/lib/sounds/textSounds/somTextoLohan.wav", false){
            @Override
            public void contarHistoria(){
                System.out.println("Lohan é um furão que sonha em se tornar um grande investigador e entrou recentemente neste ramo. Atualmente, trabalha para Kalrok onde é seu ajudante nos casos.");
            }
        
            @Override
            public void utilizarPoder(){
                System.out.println("Nome do poder: Mente de aço\nDescrição: Perde vinte (20) de energia para conseguir esquivar de um ataque inimigo");
                if(energia >= 20){
                    energia -= 20;
                    esquivar = true;
                    JOptionPane.showMessageDialog(null, "VOCÊ PERDEU 20 DE ENERGIA, MAS O PRÓXIMO GOLPE QUE SOFRER CONSEGUIRÁ ESQUIVAR", "Mente de Aço", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Perdeu 20 de energia e fez o efeito");
                }
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

        protected boolean esquivar;

        PersonagemJogavel(String nome, int idade, int energia, String caminhoSom, boolean esquivar){
            this.nome = nome;
            this.idade = idade;
            this.energia = energia;
            this.caminhoSom = caminhoSom;
            setSom(getCaminhoSom());
            this.esquivar = esquivar;
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
        APARTAMENTO("apartamento", "/lib/imagens/cenaApartamento1.png"),
        SALA("sala", "/lib/imagens/cenaSala1.png"),
        QUARTO("quarto", "/lib/imagens/cenaQuarto1.png"),
        COZINHA("cozinha", "/lib/imagens/cenaCozinha1.png"),
        BANHEIRO("banheiro", "/lib/imagens/cenaBanheiro1.png");

        protected String nome;
        protected String caminhoImagem1;
        protected ArrayList<Item> itens = new ArrayList<>();
        
        protected BufferedImage img1;

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenSize = toolkit.getScreenSize();

        Comodo(String nome, String caminhoImagem1){
            setNome(nome);
            setCaminhoImagem1(caminhoImagem1);
            //setImagens(getCaminhoImagem1());
            //getImagem();
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
        pj.playerPanel.setBackground(Color.black);
        pj.playerPanel.setLayout(new GridLayout(1, 8));

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

        pj.personagemBotaoUsarHabilidade = new JButton("USAR PODER");
        pj.configurarBotao(pj.personagemBotaoUsarHabilidade);
        pj.personagemBotaoUsarHabilidade.addActionListener(e -> {
            System.out.println("usando habilidade");
            usarHabilidade();
        });

        pj.personagemBotaoInventario = new JButton("INVENTÁRIO");
        pj.configurarBotao(pj.personagemBotaoInventario);
        pj.personagemBotaoInventario.addActionListener(e -> {
            System.out.println("abrindo inventario...");
            abrirInventario();
        });

        pj.playerPanel.add(pj.nomePersonagemLabel);
        pj.playerPanel.add(pj.textoNomePersonagemLabel);
        pj.playerPanel.add(pj.idadePersonagemLabel);
        pj.playerPanel.add(pj.numeroIdadePersonagemLabel);
        pj.playerPanel.add(pj.energiaPersonagemLabel);
        pj.playerPanel.add(pj.numeroEnergiaPersonagemLabel);
        pj.playerPanel.add(pj.personagemBotaoUsarHabilidade);
        pj.playerPanel.add(pj.personagemBotaoInventario);

        pj.playerPanel.setVisible(true);

        // PAINEL INVENTARIO -> OUTRA PAGINA
        pj.painelTituloPersonagemInventario = new JPanel();
        pj.painelTituloPersonagemInventario.setBounds(600, 50, 300, 50);
        pj.painelTituloPersonagemInventario.setBackground(Color.black);
        
        pj.tituloPersonagemInventario = new JLabel("INVENTÁRIO");
        pj.tituloPersonagemInventario.setBackground(Color.black);
        pj.tituloPersonagemInventario.setForeground(Color.white);
        pj.tituloPersonagemInventario.setFont(pj.fonteTitulo);

        pj.painelTituloPersonagemInventario.add(pj.tituloPersonagemInventario);

        pj.painelTituloPersonagemInventario.setVisible(false);

        pj.painelPersonagemInventario = new JPanel();
        pj.painelPersonagemInventario.setBounds(450, 100, 600, 600);
        pj.painelPersonagemInventario.setBackground(Color.black);
        pj.painelPersonagemInventario.setForeground(Color.white);
        pj.painelPersonagemInventario.setLayout(new GridLayout(5, 1));
        pj.painelPersonagemInventario.setFont(pj.fontePadrao);

        pj.painelPersonagemInventario.setVisible(false);

        pj.painelPersonagemBotaoVoltarInventario = new JPanel();
        pj.painelPersonagemBotaoVoltarInventario.setBounds(650, 700, 200, 50);
        pj.painelPersonagemBotaoVoltarInventario.setBackground(Color.black);
        
        pj.personagemBotaoVoltarInventario = new JButton("VOLTAR");
        pj.configurarBotao(pj.personagemBotaoVoltarInventario);
        pj.personagemBotaoVoltarInventario.addActionListener(e -> {
            System.out.println("saindo do inventario...");
            voltarPainelJogo();
        });

        pj.painelPersonagemBotaoVoltarInventario.add(pj.personagemBotaoVoltarInventario);

        pj.painelPersonagemBotaoVoltarInventario.setVisible(false);

        // IMAGEM DA CENA PARTE DE CIMA/MEIO
        pj.painelImagemComodo = new JPanel();
        pj.painelImagemComodo.setBounds(0, 50, pj.larguraTJ, 400);
        pj.painelImagemComodo.setBackground(Color.black);

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
        if(protagonista.getNome().equals("kalrok")){
            pj.painelTextoPadrao.setBackground(corKalrok);
        }
        else if(protagonista.getNome().equals("lohan")){
            pj.painelTextoPadrao.setBackground(corLohan);
        }
        pj.painelTextoPadrao.setBorder(BorderFactory.createLineBorder(Color.white, 3));

        pj.areaTextoPadrao = new JTextArea("olá teste");
        pj.areaTextoPadrao.setBounds(35, 500, pj.larguraTJ - 35, 700);
        if(protagonista.getNome().equals("kalrok")){
            pj.areaTextoPadrao.setBackground(corKalrok);
        }
        else if(protagonista.getNome().equals("lohan")){
            pj.areaTextoPadrao.setBackground(corLohan);
        }
        pj.areaTextoPadrao.setForeground(Color.white);
        pj.areaTextoPadrao.setFont(pj.fontePadrao);
        pj.areaTextoPadrao.setLineWrap(true); //texto vai pra baixo automaticamente
        
        pj.painelTextoPadrao.add(pj.areaTextoPadrao);

        pj.painelTextoPadrao.setVisible(true);

        pj.con.add(pj.playerPanel);
        pj.con.add(pj.painelTituloPersonagemInventario);
        pj.con.add(pj.painelPersonagemInventario);
        pj.con.add(pj.painelPersonagemBotaoVoltarInventario);
        pj.con.add(pj.painelImagemComodo);
        pj.con.add(pj.painelBotaoProximoInGame);
        pj.con.add(pj.painelTextoPadrao);

        pj.con.repaint();

        telaApartamento();
    }

    public void telaApartamento(){
        Comodo apartamento = Comodo.fromNome("apartamento");
        System.out.println("Caminho cena apartamento: " + apartamento.getCaminhoImagem1());

        ImageIcon cenaApartamento = new ImageIcon(getClass().getResource(apartamento.getCaminhoImagem1()));
        System.out.println(Comodo.APARTAMENTO.getCaminhoImagem1());

        Image imagem = cenaApartamento.getImage().getScaledInstance(escalaXY, escalaXY, Image.SCALE_SMOOTH);
        ImageIcon imagemIcon = new ImageIcon(imagem);

        JLabel labelCena = new JLabel(imagemIcon);
        labelCena.setVisible(true);

        pj.painelImagemComodo.add(labelCena, BorderLayout.CENTER);

        pj.painelImagemComodo.revalidate();
        pj.painelImagemComodo.repaint();

        pj.con.revalidate();
        pj.con.repaint();
    }

    public void telaSala(){

    }

    public void telaCozinha(){
        
    }

    public void telaQuarto(){

    }

    public void telaBanheiro(){

    }

    public void telaAutoestima(){

    }

    public void telaChefe(){

    }

    public void usarHabilidade(){
        pj.csh.tocarClickSound();
        protagonista.utilizarPoder();
        pj.numeroEnergiaPersonagemLabel.setText("" + protagonista.energia);
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
