import javax.swing.*;
import java.awt.*;

public class Gamepanel extends JPanel implements Runnable{
    /*
    to create a game, we need a thread
    Thread is like hame clock, like it says that our game is running
    and automatically void run will appear
    thats a game loop(game core);
     */

    final int originalTitleSize = 16;
    final int scale = 3;

    final int tileSize = originalTitleSize * scale;
    final int maxScreenCol = 18;
    final int maxScreenRow = 14;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeigh = tileSize * maxScreenRow;

    public Gamepanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeigh));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    //gameclock
    Thread gameThread;

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    //core of our game(Loop)
    @Override
    public void run() {

    }
}
