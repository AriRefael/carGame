import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class WindowGame extends JPanel {


    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 600;
    private MyRectangle[] myRectangles;

    private CarImage[] obstaclesPlayer;
    private MyRectangle[] obstacles;
    private ImageIcon obstaclesIcon;
    private Car player;
    private ImageIcon iconPlayer;
    private CarImage playerImage;

    private JLabel finish;
    private JButton playAgain;

    private Main main;
    //מיקום הרכב על הכביש
    private int x = 30, y = WINDOW_HEIGHT / 2 - 55, width = 150, height = 70;

    public WindowGame(int x, int y, int width, int height, Main main) {
        this.setBounds(0, 0, width, height);
        this.setLayout(null);
        this.setBackground(Color.black);

        this.main = main;

        this.player = new Car(this.x, this.y, this.width, this.height, Color.black);
        this.iconPlayer = new ImageIcon("big3.png");
        this.playerImage = new CarImage(this.x, this.y, iconPlayer);

        this.obstacles = new MyRectangle[1000];
        this.obstaclesIcon = new ImageIcon("carNew1.png");
        this.obstaclesPlayer = new CarImage[1000];

        Random rnd = new Random();

        int location[] = {27, 135, 255, 381, 495};

        for (int i = 0; i < obstacles.length; i++) {

            int random = rnd.nextInt(location.length);
            int loc = location[random];
            CarImage carImage = new CarImage(1200, loc, obstaclesIcon);
            obstaclesPlayer[i] = carImage;
            MyRectangle myRectangle = new MyRectangle(1200, loc, 10, 52);
            obstacles[i] = myRectangle;

        }

        this.gameLoop();


    }

    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        //נתיבים

        myRectangles = new MyRectangle[70];
        G.setColor(Color.white);
        int x = 10;
        int y = WINDOW_HEIGHT / 5 - 20;
        int width = 100;
        int height = 10;

        for (int i = 0; i < myRectangles.length; i++) {
            G.fillRect(x, y, width, height);
            x += 150;
            if (x > 1200) {
                x = 10;
                y += WINDOW_HEIGHT / 5;
            }
        }
        //שורת התחלה
        myRectangles = new MyRectangle[24];
        x = 180;
        y = 0;
        width = 25;
        height = 25;

        for (int i = 0; i < myRectangles.length; i++) {
            G.setColor(Color.WHITE);
            G.fillRect(x, y, width, height);
            y += 50;
            if (y > 600) {
                x = 205;
                y = 25;
            }

        }

        //סוף משחק
        finish = new JLabel("YOU WIN!", JLabel.CENTER);
        finish.setBounds(0, 100, WINDOW_WIDTH, 100);
        finish.setFont(new Font("Arial", Font.BOLD, 40));
        this.add(finish);
        finish.setBackground(Color.red);
        finish.setForeground(Color.WHITE);
        finish.setVisible(false);

        //שחק מחדש
        playAgain = new JButton("PLAY AGAIN");
        playAgain.setBounds(WINDOW_WIDTH / 2 - 60, WINDOW_HEIGHT / 2 - 30, 150, 60);
        playAgain.setBackground(Color.red);
        playAgain.setVisible(false);


        this.player.paint(G);
        this.playerImage.paint(G);


        //מכשולים
        for (int i = 0; i < obstacles.length; i++) {
            G.setColor(Color.black);
            this.obstacles[i].paint(G);
            this.obstaclesPlayer[i].paint(G);

        }

    }

    //תזוזה של הרכב
    public void gameLoop() {
        new Thread(() -> {
            Movement movement = new Movement(player, playerImage);
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(movement);
            first:
            while (true) {
                try {

                    repaint();
                    Thread.sleep(1);
                    limit();
                    moveObstacles();

                    for (int i = 0; i < obstacles.length; i++) {
                        if (player.checkCollision(obstacles[i])){
                            player.setX(30);
                            player.setY(WINDOW_HEIGHT / 2 -55);
                            playerImage.setX(30);
                            playerImage.setY(WINDOW_HEIGHT / 2 -55);


                        }

                    }


                    if (is_win()) {
                        finish.setVisible(true);
                        this.add(playAgain);
                        playAgain.setVisible(true);
                        Audio audio = new Audio();
                        audio.stopAudio();

                        playAgain.addActionListener(e -> {
                            Main main1 = new Main();
                            main.dispose();
                        });
                        break;
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    //הגבלת קווים
    public void limit() {
        if (player.getY() < 0) {
            player.moveDown();
            playerImage.moveDown();
        }
        if (player.getY() > 565 - player.getHeight()) {
            player.moveUp();
            playerImage.moveUp();
        }
    }

    public boolean is_win() {
        return player.getX() > (1200 - 165);


    }
    public void moveObstacles(){
       new  Thread( () ->{
           while (true){
               for (int i = 0; i < obstacles.length; i++) {
                   try {
                       obstacles[i].moveLeft();
                       obstaclesPlayer[i].moveLeft();
                       Thread.sleep(2000);
                   }
                   catch (Exception e){
                       e.printStackTrace();
                   }


               }
           }



       }).start();
    }



}
