package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartHandlerL implements ActionListener{
    PainelJogo pj;

    public StartHandlerL(PainelJogo pj){
        this.pj = pj;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        pj.iniciarJogo("lohan");
    }
    
}
