package main;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

public class ControleMusicaTJ{
    PainelJogo pj;

    public ControleMusicaTJ(PainelJogo pj){
        this.pj = pj;
        tocarMusica();
    }

    public void tocarMusica(){
        try{
            File arquivo = new File("src/lib/sounds/musics/8bitNoirTheme.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
            pj.clip2 = AudioSystem.getClip();
            pj.clip2.open(audioStream);

            pj.volumeControl = (FloatControl) pj.clip2.getControl(FloatControl.Type.MASTER_GAIN);

            pj.clip2.start();
            pj.clip2.loop(50);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tocar a música: " + e.getMessage());
        }
    }
}
