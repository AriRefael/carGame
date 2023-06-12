import java.awt.*;
import javax.swing.*;

public class Car {

    private int x ;
    private int y ;
    private int width;
    private int height;
    private Color color;

    Audio audio;


    public Car(int x, int y, int width, int height ,Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

    }
    public boolean checkCollision(MyRectangle other){
        boolean collision = false;

        Rectangle thisRectangle = new Rectangle(this.x , this.y ,this.width , this.height);
        Rectangle otherRectangle = new Rectangle(other.getX(), other.getY(), other.getWidth(), other.getHeight());

        if (thisRectangle.intersects(otherRectangle)){
            collision = true;
        }
        return collision;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void moveRight() throws Exception {
        this.x += 15;
        audio = new Audio();
        audio.startAudio();
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
        this.x -= 5;
    }
    public void paint(Graphics G){
        G.setColor(this.color);
        G.drawRect(this.x, this.y, this.width, this.height);


    }
}
