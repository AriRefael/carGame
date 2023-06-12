import java.awt.*;

public class MyRectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    public MyRectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public void moveLeft(){
        this.x -= 1;
    }
    public void paint(Graphics G){
        G.setColor(Color.black);
        G.fillRect(this.x , this.y , this.width , this.height);

    }
}
