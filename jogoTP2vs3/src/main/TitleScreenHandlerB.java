package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenHandlerB implements ActionListener{
    PainelJogo pj;

    public TitleScreenHandlerB(PainelJogo pj){
        this.pj = pj;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        pj.abrirMenu();
    }
    
}
