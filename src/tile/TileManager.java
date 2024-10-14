package tile;

import main.GamePanel;

import java.awt.*;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    Tile[] tile; // Array of tiles

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10]; // Initialize the tile array
        for (int i = 0; i < tile.length; i++){
            tile[i] = new Tile();
        }
        getTileImage(); // Load the tile images
    }
    // Load the tile images
    public void getTileImage(){
        try{
            tile[0].setImage(gp.loadImage("tiles/grass.png"));
            tile[1].setImage(gp.loadImage("tiles/wall.png"));
            tile[2].setImage(gp.loadImage("tiles/water.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void drawTiles(Graphics2D g2){
        int row = 0;
        int col = 0;
        int x = 0;
        int y = 0;

        while (col < gp.getMaxScreenCol() && row < gp.getMaxScreenRow()){
            if(row == 0 || col == 0 || row == gp.getMaxScreenRow() - 1 || col == gp.getMaxScreenCol() - 1){
                g2.drawImage(tile[1].image, x, y,gp.getTileSize(), gp.getTileSize(), null);
            }else{
            g2.drawImage(tile[0].image, x, y,gp.getTileSize(), gp.getTileSize(), null);
            }
            x += gp.getTileSize();
            col++;
            if(col == gp.getMaxScreenCol()){
                col = 0;
                row++;
                x = 0;
                y += gp.getTileSize();
            }
        }
    }
}
