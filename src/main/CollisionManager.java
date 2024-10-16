package main;

import entity.Entity;

public class CollisionManager {
    GamePanel gp;
    public CollisionManager(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity e){
        // Get the location of the collision box of the entity on the world map
        int entityLeftX = e.getWorldX() + e.solidArea.x;
        int entityRightX = e.getWorldX() + e.solidArea.x + e.solidArea.width;
        int entityTopY = e.getWorldY() + e.solidArea.y;
        int entityBottomY = e.getWorldY() + e.solidArea.y + e.solidArea.height;
        // Find the row and column of the entity
        int entityLeftCol = entityLeftX / gp.getTileSize();
        int entityRightCol = entityRightX / gp.getTileSize();
        int entityTopRow = entityTopY / gp.getTileSize();
        int entityBottomRow = entityBottomY / gp.getTileSize();
        // An entity can only be hitting 2 tiles at most  while moving in one direction
        int tileNum1, tileNum2;
        // Check the tiles the entity is hitting
        switch(e.getDirection()){
            case "up":
                entityTopRow = (entityTopY - e.getSpeed()) / gp.getTileSize();
                tileNum1 = gp.getTm().getMapTiles()[entityTopRow][entityLeftCol];
                tileNum2 = gp.getTm().getMapTiles()[entityTopRow][entityRightCol];
                if(gp.getTm().getTile()[tileNum1].getCollision() || gp.getTm().getTile()[tileNum2].getCollision()){
                    e.setCollisionOn(true);
                }
                break;
            case "down":
                entityBottomRow = (entityBottomY + e.getSpeed()) / gp.getTileSize();
                tileNum1 = gp.getTm().getMapTiles()[entityBottomRow][entityLeftCol];
                tileNum2 = gp.getTm().getMapTiles()[entityBottomRow][entityRightCol];
                if(gp.getTm().getTile()[tileNum1].getCollision() || gp.getTm().getTile()[tileNum2].getCollision()){
                    e.setCollisionOn(true);
                }
                break;
            case "left":
                entityLeftCol = (entityLeftX - e.getSpeed()) / gp.getTileSize();
                tileNum1 = gp.getTm().getMapTiles()[entityTopRow][entityLeftCol];
                tileNum2 = gp.getTm().getMapTiles()[entityBottomRow][entityLeftCol];
                if(gp.getTm().getTile()[tileNum1].getCollision() || gp.getTm().getTile()[tileNum2].getCollision()){
                    e.setCollisionOn(true);
                }
                break;
            case "right":
                entityRightCol = (entityRightX + e.getSpeed()) / gp.getTileSize();
                tileNum1 = gp.getTm().getMapTiles()[entityTopRow][entityRightCol];
                tileNum2 = gp.getTm().getMapTiles()[entityBottomRow][entityRightCol];
                if(gp.getTm().getTile()[tileNum1].getCollision() || gp.getTm().getTile()[tileNum2].getCollision()){
                    e.setCollisionOn(true);
                }
                break;
        }




    }
}
