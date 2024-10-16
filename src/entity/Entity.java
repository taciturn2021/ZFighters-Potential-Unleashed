package entity;

import java.awt.*;
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

    public Rectangle solidArea; // Rectangle to check for collision
    public boolean collisionOn = false; // Boolean to check if the entity can collide with other entities


    //Getters and Setters
    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public String getDirection() {
        return direction;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public int getIdleSpriteCounter() {
        return idleSpriteCounter;
    }

    public void setIdleSpriteCounter(int idleSpriteCounter) {
        this.idleSpriteCounter = idleSpriteCounter;
    }

    public int getIdleSpriteNum() {
        return idleSpriteNum;
    }

    public void setIdleSpriteNum(int idleSpriteNum) {
        this.idleSpriteNum = idleSpriteNum;
    }

    public int getWalkSpriteCounter() {
        return walkSpriteCounter;
    }

    public void setWalkSpriteCounter(int walkSpriteCounter) {
        this.walkSpriteCounter = walkSpriteCounter;
    }

    public int getWalkSpriteNum() {
        return walkSpriteNum;
    }

    public void setWalkSpriteNum(int walkSpriteNum) {
        this.walkSpriteNum = walkSpriteNum;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public boolean isCollisionOn() {
        return collisionOn;
    }

    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
    }
}
