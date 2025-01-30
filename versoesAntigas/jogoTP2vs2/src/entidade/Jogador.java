package entidade;

import main.KeyHandler;
import main.PainelJogo;

public class Jogador{
    PainelJogo pj;
    KeyHandler kh;

    public Jogador(PainelJogo pj, KeyHandler kh){
        this.pj = pj;
        this.kh = kh;
    }

    public void update(){
        if(kh.espacoApertado == true){
            // -= imagemVel;
        }
        else if(kh.enterApertado == true){
            //imagemY += imagemVel;
        }
    }
}
