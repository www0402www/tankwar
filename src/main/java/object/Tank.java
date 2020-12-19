package object;

import javax.swing.*;
import java.awt.*;

public class Tank {

    private int x;
    private int y;
    private int speed;
    private Direction direction;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public Tank(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        speed = 5;
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public Image getImage() {
        if (direction == Direction.UP)
            return new ImageIcon("assets/images/itankU.png").getImage();
        if (direction == Direction.DOWN)
            return new ImageIcon("assets/images/itankD.png").getImage();
        if (direction == Direction.LEFT)
            return new ImageIcon("assets/images/itankR.png").getImage();
        if (direction == Direction.RIGHT)
            return new ImageIcon("assets/images/itankL.png").getImage();

        return null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
public void move(){
        switch (direction){
            case UP:
                y-=speed;
                break;
            case DOWN:
                y+=speed;
                break;
            case LEFT:
                x-=speed;
                break;
            case RIGHT:
                x+=speed;
                break;
        }
}
    }


