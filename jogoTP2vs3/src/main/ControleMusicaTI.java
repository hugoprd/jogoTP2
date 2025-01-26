package main;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JOptionPane;

public class ControleMusicaTI{
    PainelJogo pj;

    public ControleMusicaTI(PainelJogo pj){
        this.pj = pj;
        tocarMusica();
    }

    public void tocarMusica(){
        try{
            File arquivo = new File("src/lib/sounds/musics/8bitmusicTelaInicial.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
            pj.clip = AudioSystem.getClip();
            pj.clip.open(audioStream);
            pj.clip.start();
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tocar a música: " + e.getMessage());
        }
    }
}
