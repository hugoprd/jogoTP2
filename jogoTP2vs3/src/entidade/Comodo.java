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
    protected ArrayList<Item> itens = new ArrayList<>();

    //PainelJogo pj;
    
    protected BufferedImage img1;

    Toolkit toolkit = Toolkit.getDefaultToolkit();

    Dimension screenSize = toolkit.getScreenSize();

    public Comodo(String nome, String caminhoImagem1){ //PainelJogo pj){
        //this.pj = pj;

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

    @Override
    public void interageComPersonagem(Personagem personagem){
        throw new UnsupportedOperationException("Unimplemented method 'interageComPersonagem'");
    }
    
}
