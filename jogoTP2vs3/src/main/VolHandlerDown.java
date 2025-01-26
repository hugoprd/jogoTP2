package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VolHandlerDown implements ActionListener{
    PainelJogo pj;

    public VolHandlerDown(PainelJogo pj){
        this.pj = pj;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        pj.ajustarVolume(1);
    }
    
}
