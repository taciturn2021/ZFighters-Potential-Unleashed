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
        mapTiles = new int[gp.getMaxWorldRow()][gp.getMaxWorldCol()];
        // Initialize the tile array
        for (int i = 0; i < tile.length; i++) {
            tile[i] = new Tile();
        }
        getTileImage(); // Load the tile images
        loadMap("maps/world01.txt"); // Load the map
    }

    // Load the tile images and set the collision
    public void getTileImage() {
        try {
            tile[0].setImage(gp.loadImage("tiles/grass.png"));
            tile[1].setImage(gp.loadImage("tiles/wall.png"));
            tile[1].setCollision(true);
            tile[2].setImage(gp.loadImage("tiles/water.png"));
            tile[2].setCollision(true);
            tile[3].setImage(gp.loadImage("tiles/earth.png"));
            tile[4].setImage(gp.loadImage("tiles/tree.png"));
            tile[4].setCollision(true);
            tile[5].setImage(gp.loadImage("tiles/sand.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load the map file into an array
    public void loadMap(String path) {
        try {
            InputStream fr = getClass().getClassLoader().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fr));
            for (int row = 0; row < gp.getMaxWorldRow(); row++) {
                String line = br.readLine();
                String[] tokens = line.split(" ");
                for (int col = 0; col < gp.getMaxWorldCol(); col++) {
                    mapTiles[row][col] = Integer.parseInt(tokens[col]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Draw the tiles around the player
    public void camera(Graphics2D g2) {
        int worldCol = 0; // World column
        int worldRow = 0; // World row
        // Calculate the starting world column and row
        while (worldCol < gp.getMaxWorldCol() && worldRow < gp.getMaxWorldRow()) {
            int tileNum = mapTiles[worldRow][worldCol];
            int worldX = worldCol * gp.getTileSize(); // World X position
            int worldY = worldRow * gp.getTileSize(); // World Y position
            int screenX = worldX - gp.getPlayer().getWorldX() + gp.getPlayer().getScreenX(); // Add offset to get screen position of the tiles
            int screenY = worldY - gp.getPlayer().getWorldY() + gp.getPlayer().getScreenY(); // Add offset to get screen position of the tiles

            // Draw the tiles only if they are within the screen
            if(     worldX + gp.getTileSize()> gp.getPlayer().getWorldX() - gp.getPlayer().getScreenX()
                    && worldX - gp.getTileSize()< gp.getPlayer().getWorldX() + gp.getPlayer().getScreenX()
                    && worldY + gp.getTileSize()> gp.getPlayer().getWorldY() - gp.getPlayer().getScreenY()
                    && worldY - gp.getTileSize()< gp.getPlayer().getWorldY() + gp.getPlayer().getScreenY())
            {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.getTileSize(), gp.getTileSize(), null);
            }

            worldCol++;

            if (worldCol == gp.getMaxWorldCol()) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

    public void drawTiles(Graphics2D g2) {
        camera(g2);
    }

    // Getters and Setters


    public GamePanel getGp() {
        return gp;
    }

    public void setGp(GamePanel gp) {
        this.gp = gp;
    }

    public Tile[] getTile() {
        return tile;
    }

    public void setTile(Tile[] tile) {
        this.tile = tile;
    }

    public int[][] getMapTiles() {
        return mapTiles;
    }

    public void setMapTiles(int[][] mapTiles) {
        this.mapTiles = mapTiles;
    }
}


