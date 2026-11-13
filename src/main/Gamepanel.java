package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;

public class Gamepanel extends JPanel implements Runnable{
    /*
    to create a game, we need a thread
    Thread is like hame clock, like it says that our game is running
    and automatically void run will appear
    thats a game loop(game core);
     */

    int FPS = 60;
    final int originalTitleSize = 16;
    final int scale = 3;

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public final int tileSize = originalTitleSize * scale;
    final int maxScreenCol = 18;
    final int maxScreenRow = 14;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeigh = tileSize * maxScreenRow;

    KeyHandler keyH = new KeyHandler();
    //gameclock
    Thread gameThread;
    Player player = new Player(this, keyH);

    public Gamepanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeigh));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }


    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();

    }

    //core of our game(Loop)
    @Override
    public void run() {

        double drawnInterval = 1000000000/ FPS;
        double nextDrawn = System.nanoTime() + drawnInterval;

        while (gameThread != null){

            //1 UPDATE: update keeps the information such as character position
            update();

            //2 DRAW: draw the screen with the updated information
            repaint();

            try {
                double remainingTime = nextDrawn - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);

                nextDrawn += drawnInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        player.draw(g2);

        g2.dispose();
    }
}
