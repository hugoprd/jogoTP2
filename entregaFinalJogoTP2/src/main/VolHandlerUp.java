package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VolHandlerUp implements ActionListener{
    PainelJogo pj;

    public VolHandlerUp(PainelJogo pj){
        this.pj = pj;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        pj.csh.tocarClickSound();
        System.out.println("ajustando volume..");
        pj.ajustarVolume(2);
    }
    
}
