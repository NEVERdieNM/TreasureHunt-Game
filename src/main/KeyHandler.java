package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean wPressed, sPressed, aPressed, dPressed, spacePressed;
    //DEBUG
    public boolean showCoordinates, showDrawTime;

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W){
            wPressed = true;
        }
        if(keyCode == KeyEvent.VK_S){
            sPressed = true;
        }
        if(keyCode == KeyEvent.VK_A){
            aPressed = true;
        }
        if(keyCode == KeyEvent.VK_D){
            dPressed = true;
        }
        if(keyCode == KeyEvent.VK_SPACE){
            spacePressed = true;
        }
        if(keyCode == KeyEvent.VK_K){
            if(showCoordinates == false){
                showCoordinates = true;
            }else if(showCoordinates == true){
                showCoordinates = false;
            }
        }
        if(keyCode == KeyEvent.VK_L){
            if(showDrawTime == false){
                showDrawTime = true;
            }else if(showDrawTime == true){
                showDrawTime = false;
            }
        }
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W){
            wPressed = false;
        }
        if(keyCode == KeyEvent.VK_S){
            sPressed = false;
        }
        if(keyCode == KeyEvent.VK_A){
            aPressed = false;
        }
        if(keyCode == KeyEvent.VK_D){
            dPressed = false;
        }
        if(keyCode == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    
    

}
