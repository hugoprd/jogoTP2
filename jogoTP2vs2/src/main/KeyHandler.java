package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    public boolean espacoApertado, enterApertado;

    @Override
    public void keyTyped(KeyEvent e){
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e){
        int codigo = e.getKeyCode();

        if(codigo == KeyEvent.VK_ENTER){
            enterApertado = true;
        }

        if(codigo == KeyEvent.VK_SPACE){
            espacoApertado = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int codigo = e.getKeyCode();

        if(codigo == KeyEvent.VK_ENTER){
            enterApertado = false;
        }

        if(codigo == KeyEvent.VK_SPACE){
            espacoApertado = false;
        }
    }
    
}
