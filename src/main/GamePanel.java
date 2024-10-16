package main;

import entity.Player;
import tile.TileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    private final int originalTileSize = 16; // 16x16 Tile
    private final int scaling = 3; // 3x scaling

    private final int tileSize = originalTileSize * scaling; // 48x48 Tile
    private final int maxScreenCol = 16; // 16 Tiles Horizontal
    private final int maxScreenRow = 12; // 12 Tiles Vertical
    private final int screenWidth = tileSize * maxScreenCol; // 768px
    private final int screenHeight = tileSize * maxScreenRow; // 576px
    // FPS SETTINGS
    private final int FPS = 60; // Frames per second
    // WORLD SETTINGS
    private final int maxWorldCol = 50; // 40 Tiles Horizontal
    private final int maxWorldRow = 50; // 30 Tiles Vertical
    private final int worldWidth = tileSize * maxWorldCol;
    private final int worldHeight = tileSize * maxWorldRow;


    private KeyHandler keyH = new KeyHandler(); // KeyHandler object to handle keyboard inputs
    private Thread gameThread; // Game Thread (Thread is used to create Time in the game, like a clock i.e. the game runs in sync with real time)
    private Player player = new Player(this, keyH); // Create a Player object
    private TileManager tm = new TileManager(this); // Create a TileManager object
    private CollisionManager cm = new CollisionManager(this); // Create a CollisionManager object

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); // Add KeyListener to the GamePanel
        this.setFocusable(true); // Set the GamePanel to be focusable
    }

    // Start Game Thread
    public void startGameThread(){
        gameThread = new Thread(this); // this refers to the current instance of GamePanel
        gameThread.start(); // Start the thread
    }

    // To Implement Game Loop (when gameThread is running it executes the run method)
    @Override
    public void run() {
        // Variables to control the frame rate
        double drawInterval = 1000000000.0 / FPS; // Calculate the time interval between each frame (1 second divided by FPS) (0.0166 seconds)
        double delta = 0; // Initialize delta to 0
        long lastTime = System.nanoTime(); // Get the current time in nanoseconds
        long currentTime;

        // FPS Variables
        long timer = 0; // timer to check FPS
        int drawCount = 0; // Count the number of frames drawn

        while(gameThread != null){
            currentTime = System.nanoTime(); // Get the current time in nanoseconds
            delta += (currentTime - lastTime) / drawInterval; // Calculate the time passed since the last frame
            timer += (currentTime - lastTime); // Calculate the time passed since the last frame ( FOR FPS )
            lastTime = currentTime; // Update the lastTime to the currentTime


            if(delta >= 1){
                //Update information e.g. Character position
                update();
                //Draw the screen with updated information i.e. Render the game
                repaint(); // Calls paintComponent method
                delta-- ; // Decrement the delta
                drawCount++; // Increment the drawCount
            }

            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount); // Print the FPS
                drawCount = 0; // Reset the drawCount
                timer = 0; // Reset the timer
            }

        }
    }

    //Update information e.g. Character position
    public void update(){
        player.update(); // Update the player position

    }

    // Draw the screen with updated information ie Render the game
    public void paintComponent(Graphics g){
        super.paintComponent(g); // Call the paintComponent method of the parent class
        Graphics2D g2 = (Graphics2D) g; // Cast Graphics to Graphics2D for more advanced rendering

        // Draw tiles before the player to make the player appear on top of the tiles
        tm.drawTiles(g2); // Draw the tiles
        player.draw(g2); // Draw the player

        g2.dispose(); // Release system resources
    }
    public BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(getClass().getClassLoader().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Getters and Setters

    public int getTileSize() {
        return tileSize;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getMaxScreenCol() {
        return maxScreenCol;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public int getMaxWorldCol() {
        return maxWorldCol;
    }

    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public Player getPlayer() {
        return player;
    }

    public CollisionManager getCm() {
        return cm;
    }

    public int getScaling() {
        return scaling;
    }

    public int getOriginalTileSize() {
        return originalTileSize;
    }

    public int getFPS() {
        return FPS;
    }

    public Thread getGameThread() {
        return gameThread;
    }

    public void setGameThread(Thread gameThread) {
        this.gameThread = gameThread;
    }

    public KeyHandler getKeyH() {
        return keyH;
    }

    public void setKeyH(KeyHandler keyH) {
        this.keyH = keyH;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public TileManager getTm() {
        return tm;
    }

    public void setTm(TileManager tm) {
        this.tm = tm;
    }

    public void setCm(CollisionManager cm) {
        this.cm = cm;
    }
}
