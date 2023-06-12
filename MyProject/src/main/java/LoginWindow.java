import javax.swing.*;
import java.awt.*;


public class LoginWindow extends JPanel {
    public static final int Window_Width = 990;
    public static final int Window_Height = 560;

    private Main main1;


    private ImageIcon openPicture;

    public LoginWindow (){

        JFrame main = new JFrame();
        main.setSize(Window_Width,Window_Height);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLocationRelativeTo(null);
        main.setResizable(false);
        main.setLayout(null);



        this.setBounds(0, 0, Window_Width ,Window_Height);
        this.setLayout(null);


        JLabel label = new JLabel();
        openPicture = new ImageIcon("openImage.png");
        label.setIcon(openPicture);
        label.setBounds(0, 0, Window_Width, Window_Height-37);
        label.setVisible(true);
        main.add(label);

        JButton button = new JButton("play");
        button.setBounds(Window_Width / 2 -75 , Window_Height -110,150, 40);
        button.setBackground(Color.YELLOW);
        main.add(button);
        main.setVisible(true);

        button.addActionListener((event) -> {
            button.setVisible(false);
            main1 = new Main();
            main.dispose();
        });



    }

   /* public void dispose(){
        this.main1.dispose();
    }*/

    protected void paintComponent(Graphics G) {
        super.paintComponent(G);
        this.openPicture.paintIcon(this, G , 0 , 0 );
    }
}
