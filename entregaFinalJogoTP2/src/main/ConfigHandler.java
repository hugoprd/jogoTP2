package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigHandler implements ActionListener{
    PainelJogo pj;

    public ConfigHandler(PainelJogo pj){
        this.pj = pj;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        pj.csh.tocarClickSound();
        pj.abrirConfigs();
    }
    
}
