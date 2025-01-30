package main;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JOptionPane;

public class SomAutoestimaHandler{
    PainelJogo pj;

    public SomAutoestimaHandler(PainelJogo pj){
        this.pj = pj;
    }

    
    public void tocarSomTexto(){
        try{
            File arquivo = new File("src/lib/sounds/textSounds/somTextoAutoestima.wav");
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
