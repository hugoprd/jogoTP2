package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PontuacaoHandler implements ActionListener{
    PainelJogo pj;

    public PontuacaoHandler(PainelJogo pj){
        this.pj = pj;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        pj.csh.tocarClickSound();
        pj.abrirPontuacoes();
    }
    
}
