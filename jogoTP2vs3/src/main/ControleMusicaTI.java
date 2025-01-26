package main;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

public class ControleMusicaTI{
    PainelJogo pj;
    Clip clip;
    FloatControl volumeControl;

    public ControleMusicaTI(PainelJogo pj){
        this.pj = pj;
        tocarMusica();
    }

    public void tocarMusica(){
        try{
            File arquivo = new File("/lib/sounds/musics/8bitmusicTelaInicial.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tocar a música: " + e.getMessage());
        }
    }

    public void ajustarVolume(float valor){
        if(volumeControl != null){
            float volumeAtual = volumeControl.getValue();
            float novoVolume = volumeAtual + valor;

            novoVolume = Math.min(novoVolume, volumeControl.getMaximum());
            novoVolume = Math.max(novoVolume, volumeControl.getMinimum());

            volumeControl.setValue(novoVolume);
        }
    }
}
