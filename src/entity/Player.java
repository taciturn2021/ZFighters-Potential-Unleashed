package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    private boolean isFlying; // Check if the player is flying
    private final int screenX, screenY; // Position of player on the screen
    private BufferedImage flyup1, flyup2, flyup3, flydown1, flydown2, flydown3, flyleft1, flyleft2, flyleft3, flyright1, flyright2, flyright3; // Entity Images for flying in each direction
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        // Center the player on the screen
        screenX = gp.getScreenWidth() / 2 - (gp.getTileSize()/2);
        screenY = gp.getScreenHeight() / 2 - (gp.getTileSize()/2);
        // Create a new rectangle for collision detection
        solidArea = new Rectangle(8,16,16,20);
        // Set the player's initial values and load images
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = gp.getTileSize() * 32; // Set the player's initial world X position
        worldY = gp.getTileSize() * 21; // Set the player's initial world Y position
        speed = 4;
        direction = "down";
        isMoving = false;
        isFlying = false;
    }
    // Load the player images
    public void getPlayerImage(){
        try{
            idleup1 = gp.loadImage("player/idle/idleup1.png");
            idleup2 = gp.loadImage("player/idle/idleup2.png");
            idledown1 = gp.loadImage("player/idle/idledown1.png");
            idledown2 = gp.loadImage("player/idle/idledown2.png");
            idleleft1 = gp.loadImage("player/idle/idleleft1.png");
            idleleft2 = gp.loadImage("player/idle/idleleft2.png");
            idleright1 = gp.loadImage("player/idle/idleright1.png");
            idleright2 = gp.loadImage("player/idle/idleright2.png");
            up1 = gp.loadImage("player/walk/walkup-1.png");
            up2 = gp.loadImage("player/walk/walkup-2.png");
            up3 = gp.loadImage("player/walk/walkup-3.png");
            up4 = gp.loadImage("player/walk/walkup-4.png");
            down1 = gp.loadImage("player/walk/walkdown-1.png");
            down2 = gp.loadImage("player/walk/walkdown-2.png");
            down3 = gp.loadImage("player/walk/walkdown-3.png");
            down4 = gp.loadImage("player/walk/walkdown-4.png");
            left1 = gp.loadImage("player/walk/walkleft-1.png");
            left2 = gp.loadImage("player/walk/walkleft-2.png");
            left3 = gp.loadImage("player/walk/walkleft-3.png");
            left4 = gp.loadImage("player/walk/walkleft-4.png");
            right1 = gp.loadImage("player/walk/walkright-1.png");
            right2 = gp.loadImage("player/walk/walkright-2.png");
            right3 = gp.loadImage("player/walk/walkright-3.png");
            right4 = gp.loadImage("player/walk/walkright-4.png");
            flyup1 = gp.loadImage("player/fly/flyup-1.png");
            flyup2 = gp.loadImage("player/fly/flyup-2.png");
            flyup3 = gp.loadImage("player/fly/flyup-3.png");
            flydown1 = gp.loadImage("player/fly/flydown-1.png");
            flydown2 = gp.loadImage("player/fly/flydown-2.png");
            flydown3 = gp.loadImage("player/fly/flydown-3.png");
            flyleft1 = gp.loadImage("player/fly/flyleft-1.png");
            flyleft2 = gp.loadImage("player/fly/flyleft-2.png");
            flyleft3 = gp.loadImage("player/fly/flyleft-3.png");
            flyright1 = gp.loadImage("player/fly/flyright-1.png");
            flyright2 = gp.loadImage("player/fly/flyright-2.png");
            flyright3 = gp.loadImage("player/fly/flyright-3.png");
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
    public void setFlying() {
        keyH.setCollisionOn(collisionOn);
        if (keyH.flyPressed) {
            isFlying = true;
        } else {
            isFlying = false;
        }
    }

    // Set the idle image based on the direction
    public BufferedImage idle(){
        BufferedImage image = null;
            switch (direction){
                case "up":
                    if(idleSpriteNum == 1){
                        if(isFlying) image = flyup1;
                        else image = idleup1;
                    }else if(idleSpriteNum == 2) {
                        if(isFlying) image = flyup2;
                        else image = idleup2;
                    }
                    break;
                case "down":
                    if(idleSpriteNum == 1){
                        if(isFlying) image = flydown1;
                        else image = idledown1;
                    }else if(idleSpriteNum == 2) {
                        if(isFlying) image = flydown2;
                        else image = idledown2;
                    }
                    break;
                case "left":
                    if(idleSpriteNum == 1){
                        if(isFlying) image = flyleft1;
                        else image = idleleft1;
                    }else if(idleSpriteNum == 2) {
                        if(isFlying) image = flyleft2;
                        else image = idleleft2;
                    }
                    break;
                case "right":
                    if(idleSpriteNum == 1){
                        if(isFlying) image = flyright1;
                        else image = idleright1;
                    }else if(idleSpriteNum == 2) {
                        if(isFlying) image = flyright2;
                        else image = idleright2;
                    }
                    break;
            }

        return image;
    }
    // Set the moving image based on the direction
    public BufferedImage walking(){
        BufferedImage image = null;
        switch (direction){
            case "up":
                if(walkSpriteNum == 1){
                    if (isFlying) image = flyup1;
                    else image = up1;
                }else if(walkSpriteNum == 2) {
                    if(isFlying) image = flyup2;
                    else image = up2;
                }
                else if(walkSpriteNum == 3) {
                    if(isFlying) image = flyup2;
                    else image = up3;
                }
                else if(walkSpriteNum == 4) {
                    if(isFlying) image = flyup3;
                    else image = up4;
                }
                break;
            case "down":
                if(walkSpriteNum == 1){
                    if(isFlying) image = flydown1;
                    else image = down1;
                }else if(walkSpriteNum == 2) {
                    if (isFlying) image = flydown2;
                    else image = down2;
                }
                else if(walkSpriteNum == 3) {
                    if (isFlying) image = flydown2;
                    else image = down3;
                }
                else if(walkSpriteNum == 4) {
                    if(isFlying) image = flydown3;
                    else image = down4;
                }
                break;
            case "left":
                if(walkSpriteNum == 1){
                    if(isFlying) image = flyleft1;
                    else image = left1;
                }else if(walkSpriteNum == 2) {
                    if(isFlying) image = flyleft2;
                    else image = left2;
                }
                else if(walkSpriteNum == 3) {
                    if(isFlying) image = flyleft2;
                    else image = left3;
                }
                else if(walkSpriteNum == 4) {
                    if(isFlying) image = flyleft3;
                    else image = left4;
                }
                break;
            case "right":
                if(walkSpriteNum == 1){
                    if(isFlying) image = flyright1;
                    else image = right1;
                }else if(walkSpriteNum == 2) {
                    if(isFlying) image = flyright2;
                    else image = right2;
                }
                else if(walkSpriteNum == 3) {
                    if(isFlying) image = flyright2;
                    else image = right3;
                }
                else if(walkSpriteNum == 4) {
                    if(isFlying) image = flyright3;
                    else image = right4;
                }
                break;
        }
        return image;
    }

    // Check the direction the player is facing
    public void checkDirection(){
        if(keyH.upPressed == true){
            direction = "up"; // Set the direction to up
        }else if (keyH.downPressed == true){
            direction = "down"; // Set the direction to down
        }else if (keyH.leftPressed == true){
            direction = "left"; // Set the direction to left
        }else if (keyH.rightPressed == true){
            direction = "right"; // Set the direction to right
        }
    }
    // Move the player
    public void movePlayer(){
        switch (direction){
            case "up":
                worldY -= speed; // Move the player up
                break;
            case "down":
                worldY += speed; // Move the player down
                break;
            case "left":
                worldX -= speed; // Move the player left
                break;
            case "right":
                worldX += speed; // Move the player right
                break;
        }
    }

    public void update(){
        setMovement(); // Check if the player is moving (to switch between idle and walking animations)
        setFlying(); // Check if the player is flying
        if(isMoving){
            if (!isFlying) speed = 4; // Set the speed to 4 if the player is not flying
            else speed = 8; // Set the speed to 8 if the player is flying
            checkDirection(); // Check the direction player is facing
            collisionOn = false; // Set collisionOn to false
            gp.getCm().checkTile(this); // Check for collision
            if(!collisionOn || isFlying) movePlayer(); // Move the player if there is no collision

            // Walking / Flying Animations
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

        // Idle Animations
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

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null; // Get the idle image based on the direction
        if(!isMoving) image = idle(); // Get the idle image based on the direction
        if (isMoving) image = walking(); // Get the walking image based on the direction
        if (isFlying) {
            g2.drawImage(image, screenX, screenY, gp.getTileSize()+(gp.getTileSize()/2), gp.getTileSize()+(gp.getTileSize()/2), null);
            return;
        }
        g2.drawImage(image, screenX, screenY, gp.getTileSize(), gp.getTileSize(), null); // Draw the player
    }


}
