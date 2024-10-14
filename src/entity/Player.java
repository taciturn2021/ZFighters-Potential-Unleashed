package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
        isMoving = false;
    }
    // Load the player images
    public void getPlayerImage(){
        try{
            idleup1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleup1.png"));
            idleup2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleup2.png"));
            idledown1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idledown1.png"));
            idledown2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idledown2.png"));
            idleleft1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleleft1.png"));
            idleleft2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleleft2.png"));
            idleright1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleright1.png"));
            idleright2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleright2.png"));
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkup-1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkup-2.png"));
            up3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkup-3.png"));
            up4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkup-4.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkdown-1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkdown-2.png"));
            down3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkdown-3.png"));
            down4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkdown-4.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkleft-1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkleft-2.png"));
            left3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkleft-3.png"));
            left4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkleft-4.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkright-1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkright-2.png"));
            right3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkright-3.png"));
            right4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/walk/walkright-4.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // Check if the player is moving
    public void setMovement(){
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            isMoving = true;
        }else{
            isMoving = false;
        }
    }

    // Set the idle image based on the direction
    public BufferedImage idle(){
        BufferedImage image = null;
            switch (direction){
                case "up":
                    if(idleSpriteNum == 1){
                        image = idleup1;
                    }else if(idleSpriteNum == 2) {
                        image = idleup2;
                    }
                    break;
                case "down":
                    if(idleSpriteNum == 1){
                        image = idledown1;
                    }else if(idleSpriteNum == 2) {
                        image = idledown2;
                    }
                    break;
                case "left":
                    if(idleSpriteNum == 1){
                        image = idleleft1;
                    }else if(idleSpriteNum == 2) {
                        image = idleleft2;
                    }
                    break;
                case "right":
                    if(idleSpriteNum == 1){
                        image = idleright1;
                    }else if(idleSpriteNum == 2) {
                        image = idleright2;
                    }
                    break;
            }

        return image;
    }
    // Set the walking image based on the direction
    public BufferedImage walking(){
        BufferedImage image = null;
        switch (direction){
            case "up":
                if(walkSpriteNum == 1){
                    image = up1;
                }else if(walkSpriteNum == 2) {
                    image = up2;
                }
                else if(walkSpriteNum == 3) {
                    image = up3;
                }
                else if(walkSpriteNum == 4) {
                    image = up4;
                }
                break;
            case "down":
                if(walkSpriteNum == 1){
                    image = down1;
                }else if(walkSpriteNum == 2) {
                    image = down2;
                }
                else if(walkSpriteNum == 3) {
                    image = down3;
                }
                else if(walkSpriteNum == 4) {
                    image = down4;
                }
                break;
            case "left":
                if(walkSpriteNum == 1){
                    image = left1;
                }else if(walkSpriteNum == 2) {
                    image = left2;
                }
                else if(walkSpriteNum == 3) {
                    image = left3;
                }
                else if(walkSpriteNum == 4) {
                    image = left4;
                }
                break;
            case "right":
                if(walkSpriteNum == 1){
                    image = right1;
                }else if(walkSpriteNum == 2) {
                    image = right2;
                }
                else if(walkSpriteNum == 3) {
                    image = right3;
                }
                else if(walkSpriteNum == 4) {
                    image = right4;
                }
                break;
        }
        return image;
    }

    public void update(){
        setMovement(); // Check if the player is moving
        if(isMoving){
            if(keyH.upPressed == true){
                direction = "up"; // Set the direction to up
                if (y - speed < 0) return; // Check if the player is at the top of the screen
                y -= speed; // Move the player up
            }else if (keyH.downPressed == true){
                direction = "down"; // Set the direction to down
                if (y + speed >= gp.getScreenHeight() - gp.getTileSize()) return; // Check if the player is at the bottom of the screen
                y += speed; // Move the player down
            }else if (keyH.leftPressed == true){
                direction = "left"; // Set the direction to left
                if (x - speed < 0) return; // Check if the player is at the left of the screen
                x -= speed; // Move the player left
            }else if (keyH.rightPressed == true){
                direction = "right"; // Set the direction to right
                if (x + speed >= gp.getScreenWidth() - gp.getTileSize()) return; // Check if the player is at the right of the screen
                x += speed; // Move the player right
            }
            walkSpriteCounter++; // Increment the spriteCounter
            if (walkSpriteCounter >= 10){ // Check if the spriteCounter is greater than 10
                if(walkSpriteNum == 1){
                    walkSpriteNum = 2;
                }
                else if(walkSpriteNum == 2){
                    walkSpriteNum = 3;
                }
                else if(walkSpriteNum == 3){
                    walkSpriteNum = 4;
                }
                else if(walkSpriteNum == 4){
                    walkSpriteNum = 1;
                }
                walkSpriteCounter = 0; // Reset the spriteCounter
            }
        }

        idleSpriteCounter++; // Increment the spriteCounter
        if (idleSpriteCounter >= 50){ // Check if the spriteCounter is greater than 10
            if(idleSpriteNum == 1){
                idleSpriteNum = 2;
            }
            else if(idleSpriteNum == 2){
                idleSpriteNum = 1;
            }
            idleSpriteCounter = 0; // Reset the spriteCounter
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null; // Get the idle image based on the direction
        if(!isMoving) image = idle(); // Get the idle image based on the direction
        if (isMoving) image = walking(); // Get the walking image based on the direction
        g2.drawImage(image, x, y, gp.getTileSize(), gp.getTileSize(), null); // Draw the player
    }


}
