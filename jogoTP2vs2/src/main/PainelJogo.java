package main;

import javax.swing.JPanel;

import entidade.Comodo;
import entidade.Jogador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class PainelJogo extends JPanel implements Runnable{
    // =============== TELA CONFIGS ===============
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    Dimension screenSize = toolkit.getScreenSize();

    public final int originalTileSize = 128;
    public final int scale = 4;
    public final int tileSize = originalTileSize * scale;

    public final int maxScreenCol = 3; // 3 colunas
    public final int maxScreenRow = 3; // 3 linhas

    public final int screenWidth = screenSize.width; // largura da tela baseada na tela do usuário
    public final int screenHeight = screenSize.height; // altura da tela baseada na tela do usuário

    Thread gameThread;

    KeyHandler kh = new KeyHandler();

    final int FPS = 60;

    // =============== JOGADOR ===============
    Jogador jogador = new Jogador(this, kh);

    // =============== COMODO ===============
    Comodo apartamento = new Comodo("apartamento", "/lib/apartamento/cenaApartamento1.png", "/lib/apartamento/cenaApartamento2.png", this);

    // =============== DEFINIÇÃO PADRÃO PARA AS IMAGENS DO CENTRO ===============

    public PainelJogo(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        //long tempoAtual = System.nanoTime(); // 1000000000 (1 bilhão) de nano segundos = 1 segundo
        double intervaloD = 1000000000/FPS; // 1 milissegundo dividido pelo FPS (60) ->
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){
            //System.out.println("O loop do jogo está funcionando!\n");

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / intervaloD;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.printf("FPS: %d\n", drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    // ===============----------=============== MÉTODOS PARA ATUALIZAÇÃO ===============----------===============
    public void update(){
        apartamento.update();
        //jogador.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        apartamento.draw(g2);

        g2.dispose();
    }
    // ===========================================================================================================
}
