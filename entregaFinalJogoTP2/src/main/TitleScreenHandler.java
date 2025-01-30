package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenHandler implements ActionListener{
    PainelJogo pj;

    public TitleScreenHandler(PainelJogo pj){
        this.pj = pj;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        pj.csh.tocarClickSound();
        //pj.criarTelaJogo();
        pj.abrirTelaInputNome();
    }
    
}
