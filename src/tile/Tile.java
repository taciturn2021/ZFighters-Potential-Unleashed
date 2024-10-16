package tile;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image;
    public boolean collision = false;



    public void setImage(BufferedImage image){
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean getCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
}


