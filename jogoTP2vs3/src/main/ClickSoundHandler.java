package main;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JOptionPane;

public class ClickSoundHandler{
    PainelJogo pj;

    public ClickSoundHandler(PainelJogo pj){
        this.pj = pj;
    }

    
    public void tocarClickSound(){
        try{
            File arquivo = new File("src/lib/sounds/clickSounds/8bitSoundEffect.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
            pj.clipClickSound = AudioSystem.getClip();
            pj.clipClickSound.open(audioStream);

            pj.clipClickSound.start();
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tocar a música: " + e.getMessage());
        }
    }
    
}
