package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;

    public BufferedImage idleup1, idleup2, idledown1, idledown2, idleleft1, idleleft2, idleright1, idleright2; // Entity Images for standing still in each direction
    public BufferedImage up1,up2,up3,up4,down1,down2,down3,down4,left1,left2,left3,left4,right1,right2,right3,right4; // Entity Images for moving in each direction
    public String direction; // Direction the entity is facing
    public boolean isMoving; // Boolean to check if the entity is moving
    public int idleSpriteCounter = 0; // Counter to switch between idle sprites
    public int idleSpriteNum = 1; // Number to determine which idle sprite to display
    public int walkSpriteCounter = 0; // Counter to switch between walk sprites
    public int walkSpriteNum = 1; // Number to determine which walk sprite to display
}
