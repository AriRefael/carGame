import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {

    private Car player;
    private CarImage playerImage;

    public Movement(Car player, CarImage playerImage){
        this.player = player;
        this.playerImage = playerImage;

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key){
            case KeyEvent.VK_UP:
                player.moveUp();
                playerImage.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                player.moveDown();
                playerImage.moveDown();
                break;
            case KeyEvent.VK_RIGHT:
                try {
                    player.moveRight();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                playerImage.moveRight();
                break;
            case KeyEvent.VK_BACK_QUOTE:
                player.moveBack();
                playerImage.moveBack();
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
