package entity;

import java.awt.image.BufferedImage;

public class Entity {
    protected int worldX, worldY; // Position of entity in the world
    protected int speed;

    protected BufferedImage idleup1, idleup2, idledown1, idledown2, idleleft1, idleleft2, idleright1, idleright2; // Entity Images for standing still in each direction
    protected BufferedImage up1,up2,up3,up4,down1,down2,down3,down4,left1,left2,left3,left4,right1,right2,right3,right4; // Entity Images for moving in each direction
    protected String direction; // Direction the entity is facing
    protected boolean isMoving; // Boolean to check if the entity is moving
    protected int idleSpriteCounter = 0; // Counter to switch between idle sprites
    protected int idleSpriteNum = 1; // Number to determine which idle sprite to display
    protected int walkSpriteCounter = 0; // Counter to switch between walk sprites
    protected int walkSpriteNum = 1; // Number to determine which walk sprite to display

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }
}
