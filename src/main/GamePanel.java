package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 Tile
    final int scaling = 3; // 3x scaling

    final int tileSize = originalTileSize * scaling; // 48x48 Tile
    final int maxScreenCol = 16; // 16 Tiles Horizontal
    final int maxScreenRow = 12; // 12 Tiles Vertical
    final int screenWidth = tileSize * maxScreenCol; // 768px
    final int screenHeight = tileSize * maxScreenRow; // 576px

    // FPS SETTINGS
    final int FPS = 60; // Frames per second

    KeyHandler keyH = new KeyHandler(); // KeyHandler object to handle keyboard inputs
    Thread gameThread; // Game Thread (Thread is used to create Time in the game, like a clock i.e. the game runs in sync with real time)

    // Set player default position
    int playerX = 100; // Player X position
    int playerY = 100; // Player Y position
    int playerSpeed = 4; // The speed at which the player moves


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
        if(keyH.upPressed == true){
            if (playerY - playerSpeed < 0) return; // Check if the player is at the top of the screen
            playerY -= playerSpeed; // Move the player up
        }if (keyH.downPressed == true){
            if (playerY + playerSpeed >= screenHeight - tileSize) return; // Check if the player is at the bottom of the screen
            playerY += playerSpeed; // Move the player down
        }if (keyH.leftPressed == true){
            if (playerX - playerSpeed < 0) return; // Check if the player is at the left of the screen
            playerX -= playerSpeed; // Move the player left
        }if (keyH.rightPressed == true){
            if (playerX + playerSpeed >= screenWidth - tileSize) return; // Check if the player is at the right of the screen
            playerX += playerSpeed; // Move the player right
        }
    }

    // Draw the screen with updated information ie Render the game
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g; // Cast Graphics to Graphics2D for more advanced rendering

        g2.setColor(Color.WHITE);  // Set the color to white
        g2.fillRect(playerX, playerY, tileSize, tileSize); // Draws a rectangle on the screen and fills with specified color (Draw a white square acting as the player)

        g2.dispose(); // Release system resources
    }
}
