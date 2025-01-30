package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartHandlerK implements ActionListener{
    PainelJogo pj;

    public StartHandlerK(PainelJogo pj){
        this.pj = pj;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        pj.csh.tocarClickSound();
        pj.iniciarJogo("kalrok");
    }
    
}
