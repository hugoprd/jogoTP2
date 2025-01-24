package entidade;

import main.PainelJogo;
import main.App;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;

public class Comodo implements Obstaculo{
    protected String nome;
    protected String caminhoImagem1;
    protected String caminhoImagem2;
    protected ArrayList<Item> itens = new ArrayList<>();

    PainelJogo pj;
    
    public BufferedImage img1, img2;

    public int spriteCont = 0;
    public int spriteNum = 1;

    Toolkit toolkit = Toolkit.getDefaultToolkit();

    Dimension screenSize = toolkit.getScreenSize();

    int x = 500;
    int y = 0;

    public Comodo(String nome, String caminhoImagem1, String caminhoImagem2, PainelJogo pj){
        this.pj = pj;

        setNome(nome);
        setCaminhoImagem1(caminhoImagem1);
        setCaminhoImagem2(caminhoImagem2);
        setImagens(getCaminhoImagem1(), getCaminhoImagem2());
        setValoresPadrao();
        getImagem();
    }

    public void setValoresPadrao(){
        this.x = 500;
        this.y = 0;
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

    public String getCaminhoImagem2(){
        return caminhoImagem1;
    }

    public boolean setCaminhoImagem2(String caminhoImagem2){
        if(caminhoImagem2.length() > 0){
            this.caminhoImagem2 = caminhoImagem2;

            return true;
        }

        return false;
    }

    public void getImagem(){
        try{
            System.out.println("carregando as imagens");
            img1 = ImageIO.read(getClass().getResourceAsStream(getCaminhoImagem1()));
            img2 = ImageIO.read(getClass().getResourceAsStream(getCaminhoImagem2()));
            System.out.println("imagens carregadas");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setImagens(String caminhoImagem1, String caminhoImagem2){
        try{
            img1 = ImageIO.read(getClass().getResourceAsStream(caminhoImagem1));
            img2 = ImageIO.read(getClass().getResourceAsStream(caminhoImagem2));
        }
        catch(Exception e){
            //e.setStackTrace(null);
        }
    }

    public void update(){
        spriteCont++;
        if(spriteCont > 12){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCont = 0;
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage imagem = img1;

        g2.drawImage(imagem, x, y, pj.tileSize, pj.tileSize, null);
    }

    @Override
    public void interageComPersonagem(Personagem personagem){
        throw new UnsupportedOperationException("Unimplemented method 'interageComPersonagem'");
    }
    
}
