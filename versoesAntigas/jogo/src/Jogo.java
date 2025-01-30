import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Jogo extends JFrame{
    private static JTextArea textoArea;
    private static int delay = 50;

    //private static JPanel jogo = new JPanel(new BorderLayout());

    private static final File somPadrao = new File("lib/textoPadrao.wav");

    //public static CardLayout cardLayout = new CardLayout();
    //public static JPanel cardPanel = new JPanel(cardLayout);

    //public static JButton botaoProximo = new JButton("PROXIMO");

    public static JLabel textoLabel = new JLabel();

    //private static final Map<String, Integer> PAINEIS = new LinkedHashMap<>();

    public enum PersonagemJogavel{
        KALROK("kalrok", 54, 50, new File("lib/textoKalrok.wav")),
        LOHAN("lohan", 24, 35, new File("lib/textoLohan.wav"));

        private final String nome;
        private final int idade;
        private final int energia;
        private ArrayList<Item> listaItens = new ArrayList<>();
        private final File som;

        PersonagemJogavel(String nome, int idade, int energia, File som){
            this.nome = nome;
            this.idade = idade;
            this.energia = energia;
            this.som = som;
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
        APARTAMENTO("apartamento", "lib/cenaApartamento.png"),
        SALA("sala", "lib/cenaSala.png"),
        QUARTO("quarto", "lib/cenaQuarto.png"),
        COZINHA("cozinha", "lib/cenaCozinha.png"),
        BANHEIRO("banheiro", "lib/cenaBanheiro.png");

        private final String nome;
        private final String caminhoImagem;
        private ArrayList<Item> listaItens = new ArrayList<>();
        private JPanel painel = new JPanel(new BorderLayout());

        Comodo(String nome, String caminhoImagem){
            this.nome = nome;
            this.caminhoImagem = caminhoImagem;
        }

        public String getNome(){
            return nome;
        }

        public String getCaminhoImagem(){
            return caminhoImagem;
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
        AUTOESTIMAK("lib/autoestimaKalrok.png"),
        AUTOESTIMAL("lib/autoestimaLohan.png");

        private String caminhoImagem;
        private final File som = new File("lib/textoAutoestima.wav");

        Autoestima(String caminhoImagem){
            this.caminhoImagem = caminhoImagem;
        }

        public String getCaminhoImagem(){
            return caminhoImagem;
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

    /*public static void pegarImagemCena(){
        ImageIcon icon = new ImageIcon("autoestimaKalrok.png");
        Image img = icon.getImage();
        Image imgRedimensionada = img.getScaledInstance(800, 600, Image.SCALE_SMOOTH); // Tamanho da imagem
        ImageIcon imagemFinal = new ImageIcon(imgRedimensionada);
    }*/
    
    public static void jogar(String nome){
        System.out.println("o metodo jogar foi executado");
        // ============== CONFIG PERSONAGEM =============
        PersonagemJogavel protagonista = PersonagemJogavel.fromNome(nome);

        String fraseInicial = String.format("bem-vindo %s... você tem %d anos e %d de energia ainda, certo? vamos.. acorde. levante!", protagonista.getNome(), protagonista.getIdade(), protagonista.getEnergia());

        System.out.println("o metodo jogar foi executado");

        // PARA O TEXTO 
        SwingUtilities.invokeLater(() -> {
            //textoLabel = new JLabel(fraseInicial, SwingConstants.CENTER);
            textoLabel.setFont(new Font("Courier New", Font.PLAIN, 18));
            textoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            textoLabel.setForeground(Color.WHITE);
            textoLabel.setText(fraseInicial); // Limpa o texto antes de começar
            Frame.jogo.add(textoLabel, BorderLayout.CENTER);

            Frame.jogo.revalidate();
            Frame.jogo.repaint();
            Frame.jogo.setVisible(true);
        });

        System.out.println("o text foi setado");

        //textoLabel.setText(fraseInicial);

        SwingUtilities.invokeLater(() -> {
            Frame.jogo.setVisible(true);
            Frame.jogo.revalidate();
            Frame.jogo.repaint();
        });

        System.out.println("a visibilidade foi setada");

        efeitoDigitacao(fraseInicial, textoLabel);
        System.out.println("o metodo exibirTextoInicio foi executado");
    }

    public static void exibirTextoInicio(String texto){
        efeitoDigitacao(texto, textoLabel);
    }

    public static void exibirTexto(String texto){
        
    }

    private static void efeitoDigitacao(String texto, JLabel label){
        Timer timer = new Timer(delay, null); // Define o timer com o delay fornecido
        final int[] index = {0}; // Índice para rastrear o caractere atual

        timer.addActionListener(e -> {
            if (index[0] < texto.length()){
                textoLabel.setText(textoLabel.getText() + texto.charAt(index[0])); // Adiciona caractere
                index[0]++;
            } else {
                ((Timer) e.getSource()).stop(); // Para o timer ao final do texto
            }
        });

        textoLabel.setText(""); // Limpa o texto inicial do label
        timer.start(); // Inicia o efeito de digitação
    }
}