import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static final int Window_Width = 1200;
    public static final int Window_Height = 600;

    public Main() {
        WindowGame windowGame = new WindowGame(0, 0, Window_Width, Window_Height, this);
        this.setSize(Window_Width, Window_Height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(windowGame);


    }

    public static void main(String[] args) {

        LoginWindow login = new LoginWindow();

    }


}
