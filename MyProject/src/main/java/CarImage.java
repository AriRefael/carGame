import javax.swing.*;
import java.awt.*;

public class CarImage {
    private int x;
    private int y;
    private ImageIcon car;


    public CarImage(int x, int y ,ImageIcon car){
        this.x = x;
        this.y = y;
        this.car = car;


    }
    public void paint(Graphics G){
        car.paintIcon(null , G , this.x ,this.y);
    }

    public void moveRight(){
        this.x += 15;
    }
    public void moveUp(){
        this.y -= 15;
        this.x += 7;
    }
    public void moveDown(){
        this.y += 15;
        this.x += 7;
    }
    public void moveBack(){
        this.x -= 15;
    }
    public void moveLeft(){
        this.x -= 1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
