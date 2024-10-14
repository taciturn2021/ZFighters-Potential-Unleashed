package tile;

import main.GamePanel;

import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gp;
    Tile[] tile; // Array of tiles
    int mapTiles[][]; // 2D array to store the map tiles

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTiles = new int[gp.getMaxScreenRow()][gp.getMaxScreenCol()];
        // Initialize the tile array
        for (int i = 0; i < tile.length; i++) {
            tile[i] = new Tile();
        }
        getTileImage(); // Load the tile images
        loadMap(); // Load the map
    }

    // Load the tile images
    public void getTileImage() {
        try {
            tile[0].setImage(gp.loadImage("tiles/grass.png"));
            tile[1].setImage(gp.loadImage("tiles/wall.png"));
            tile[2].setImage(gp.loadImage("tiles/water.png"));
            tile[3].setImage(gp.loadImage("tiles/tree.png"));
            tile[4].setImage(gp.loadImage("tiles/earth.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        try {
            InputStream fr = getClass().getClassLoader().getResourceAsStream("maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fr));
            for (int row = 0; row < gp.getMaxScreenRow(); row++) {
                String line = br.readLine();
                String[] tokens = line.split(" ");
                for (int col = 0; col < gp.getMaxScreenCol(); col++) {
                    mapTiles[row][col] = Integer.parseInt(tokens[col]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawTiles(Graphics2D g2) {
        int x = 0;
        int y = 0;
        for (int row = 0; row < gp.getMaxScreenRow(); row++) {
            for (int col = 0; col < gp.getMaxScreenCol(); col++) {
                int tileType = mapTiles[row][col];
                g2.drawImage(tile[tileType].image, x, y,gp.getTileSize(), gp.getTileSize(), null);
                x += gp.getTileSize();
            }
            x = 0;
            y += gp.getTileSize();

        }
    }
}

