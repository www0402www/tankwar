import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankGame {
    public static void main(String[] args) {
        GameClient gameClient = new GameClient(800, 800);
        JFrame frame = new JFrame();
        frame.add(gameClient);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();



        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                gameClient.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                gameClient.keyReleased(e);
            }
        });
    }
}




