package entidade;

import java.io.File;

public class Autoestima implements Obstaculo{
    protected int vida;
    protected int dano;
    
    protected String caminhoImagem;
    protected String caminhoSom;
    
    protected File imagemAutoestima;
    protected File somAutoestima;

    public Autoestima(int vida, int dano, String caminhoImagem, String caminhoSom){
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

    @Override
    public void interageComPersonagem(Personagem personagem){
        throw new UnsupportedOperationException("Unimplemented method 'interageComPersonagem'");
    }
    
}
