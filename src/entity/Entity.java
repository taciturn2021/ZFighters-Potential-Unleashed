package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;

    public BufferedImage idleup1, idleup2, idledown1, idledown2, idleleft1, idleleft2, idleright1, idleright2; // Entity Images for standing still in each direction
    public String direction; // Direction the entity is facing
    public boolean isMoving; // Boolean to check if the entity is moving
    public int idleSpriteCounter = 0; // Counter to switch between idle sprites
    public int idleSpriteNum = 1; // Number to determine which idle sprite to display

}
