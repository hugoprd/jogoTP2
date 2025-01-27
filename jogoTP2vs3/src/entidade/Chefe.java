package entidade;

import java.io.File;

public class Chefe implements Obstaculo{
    protected int dano;
    
    protected String caminhoSom;
    protected String caminhoImagem;
    
    protected File somChefe;
    protected File imagemChefe;

    public Chefe(int dano, String caminhoSom, String caminhoImagem){
        setDano(dano);
        setCaminhoSom(caminhoSom);
        setCaminhoImagem(caminhoImagem);
        setSom(getCaminhoSom());
        setImagem(getCaminhoImagem());
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
            this.somChefe = new File(caminhoSom);

            return true;
        }
        catch(Exception e){
            throw e;
        }
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
        return imagemChefe;
    }

    public void setImagem(String caminhoImagem){
        try{
            this.imagemChefe = new File(caminhoImagem);
        }
        catch(Exception e){
            e.setStackTrace(null);
        }
    }

    @Override
    public void interageComPersonagem(Personagem personagem){
        throw new UnsupportedOperationException("Unimplemented method 'interageComPersonagem'");
    }
    
}
