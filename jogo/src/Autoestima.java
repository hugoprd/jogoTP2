import java.io.File;

public class Autoestima implements Obstaculo{
    private int vida = 50;
    private int dano = 5;
    private final String caminhoImagem;
    private final File som = new File("lib/textoAutoestima.wav");

    public Autoestima(String caminhoImagem, File som){
        this.caminhoImagem = caminhoImagem;
    }

    public String getCaminhoImagem(){
        return caminhoImagem;
    }

    @Override
    public void interageComPersonagem(PersonagemJogavel personagem){
        System.out.println("");
    }

}
