import object.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class GameClient extends JComponent {
    private int screenWidth;
    private int screenHeight;
    private Tank playerTank;
    private ArrayList<Tank> enemyTanks = new ArrayList<>();
    private ArrayList<Wall> walls = new ArrayList<>();


    public GameClient(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        init();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void init() {
        Image[] brickImage = {Tools.getImage("brick.png")};
        Image[] iTankImage = new Image[8];
        Image[] eTankImage = new Image[8];

        String[] sub = {"U.png", "D.png", "L.png", "R.png", "LU.png", "RU.png", "LD.png", "RD.png"};
        for (int i = 0; i < iTankImage.length; i++) {
            iTankImage[i] = Tools.getImage("itank" + sub[i]);
            eTankImage[i] = Tools.getImage("etank" + sub[i]);

        }
        playerTank = new Tank(100, 100, Direction.DOWN, iTankImage);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                enemyTanks.add(new Tank(260 + j * 80, 350 + 80 * i, Direction.UP, true, eTankImage));
            }
        }
        walls.add(new Wall(175, 200, true, 15, brickImage));
        walls.add(new Wall(100, 200, false, 14, brickImage));
        walls.add(new Wall(700, 200, false, 14, brickImage));
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, screenWidth, screenHeight);

        playerTank.draw(g);
        for (Tank tank : enemyTanks) {
            tank.draw(g);
        }for(Wall wall:walls){
            wall.draw(g);
        }

    }

    public void keyPressed(KeyEvent e) {
        boolean[] dirs = playerTank.getDirs();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0] = true;
                break;
            case KeyEvent.VK_DOWN:
                dirs[1] = true;
                break;
            case KeyEvent.VK_LEFT:
                dirs[2] = true;
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        boolean[] dirs = playerTank.getDirs();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0] = false;
                break;
            case KeyEvent.VK_DOWN:
                dirs[1] = false;
                break;
            case KeyEvent.VK_LEFT:
                dirs[2] = false;
                break;
            case KeyEvent.VK_RIGHT:
                dirs[3] = false;
                break;

        }
    }
}
