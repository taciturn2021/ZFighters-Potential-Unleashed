package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed; // Boolean variables to check if the keys are pressed
    public boolean flyPressed;



    @Override
    // AUTO GENERATED METHODS BY KEYLISTENER CLASS
    public void keyTyped(KeyEvent e) { // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // Get the key code of the key pressed

        // Check if the key pressed is W, A, S or D (Movement keys)
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_SPACE){
            flyPressed = !flyPressed; // Toggle the flyPressed variable
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); // Get the key code of the key pressed

        // Check if the key released is W, A, S or D (Movement keys)
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }

    }
}
