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

    Thread gameThread; // Game Thread (Thread is used to create Time in the game, like a clock i.e. the game runs in sync with real time)

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    // Start Game Thread
    public void startGameThread(){
        gameThread = new Thread(this); // this refers to the current instance of GamePanel
        gameThread.start(); // Start the thread
    }

    // To Implement Game Loop
    @Override
    public void run() {
        while(gameThread != null){
            System.out.println("Game Loop is running");

            //Update information e.g. Character position
            update();


            //Draw the screen with updated information i.e. Render the game
            repaint(); // Calls paintComponent method
        }
    }

    //Update information e.g. Character position
    public void update(){}

    // Draw the screen with updated information ie Render the game
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g; // Cast Graphics to Graphics2D for more advanced rendering

        g2.setColor(Color.WHITE);  // Set the color to white
        g2.fillRect(100, 100, tileSize, tileSize); // Draws a rectangle on the screen and fills with specified color (Draw a white square acting as the player)

        g2.dispose(); // Release system resources
    }
}
