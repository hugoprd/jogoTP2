import javax.swing.*;
import javax.swing.border.Border;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;

public class Controle extends JFrame{
    //private static FloatControl volumeControl;
    //private static Clip clip;

    public static void controlVolume(JPanel painel){
        // botão de aumentar volume
        JButton aumentarVolume = new JButton("AUMENTAR VOLUME");

        Border blackline = BorderFactory.createLineBorder(Color.black);

        JPanel buttonPanelS = new JPanel();
        buttonPanelS.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanelS.setBorder(blackline);
        buttonPanelS.setBackground(Color.black);

        aumentarVolume.setForeground(Color.white);
        aumentarVolume.setBackground(Color.black);
        aumentarVolume.setOpaque(true);
        aumentarVolume.addActionListener(e -> {
            alterarVolume(2.0f);
            Frame.tocarSoundEffect(Frame.soundEffect, true);
        }); // multiplica o volume por 2
        Frame.configurarBotao(aumentarVolume);
        buttonPanelS.add(aumentarVolume);

        // botão de diminuir volume
        JButton diminuirVolume = new JButton("DIMINUIR VOLUME");
        diminuirVolume.setForeground(Color.white);
        diminuirVolume.setBackground(Color.black);
        diminuirVolume.setOpaque(true);
        diminuirVolume.addActionListener(e -> {
            alterarVolume(0.5f);
            Frame.tocarSoundEffect(Frame.soundEffect, true);
        }); // reduz o volume pela metade
        Frame.configurarBotao(diminuirVolume);
        buttonPanelS.add(diminuirVolume);

        try{
            //AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
            //clip = AudioSystem.getClip();
            //clip.open(audioStream);

            // obter o controle de volume
            //volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // tocar o áudio
            //clip.start();
            ///clip.close();
            //clip.loop(Clip.LOOP_CONTINUOUSLY); // toca em loop contínuo
        } catch (Exception e) {
            e.printStackTrace();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int largura = (int) screenSize.getWidth();
        int altura = (int) screenSize.getHeight() / 2;

        JPanel aux = new JPanel();
        aux.setBackground(Color.black);
        aux.setPreferredSize(new Dimension(largura, altura));
        
        painel.add(aux, BorderLayout.NORTH);

        painel.add(buttonPanelS, BorderLayout.CENTER);

        painel.setVisible(true);
    }

    private static void alterarVolume(float fator) {
        if(Frame.volumeControl != null){
            // Obter o volume atual
            float volumeAtual = Frame.volumeControl.getValue();
            float novoVolume = Math.min(Frame.volumeControl.getMaximum(), 
                Math.max(Frame.volumeControl.getMinimum(), 
                volumeAtual + (float) (Math.log(fator) / Math.log(2) * 10)));

            Frame.volumeControl.setValue(novoVolume);
            System.out.println("Volume ajustado para: " + novoVolume + " dB");
        }
    }
}
