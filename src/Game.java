import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Game extends JFrame implements KeyListener {

    private Board board;
    private boolean upPress,downPressed;

    public Game(){
     setResizable(false);
     setVisible(true);
     setFocusable(true);
     setTitle("Pong");
     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

     board = new Board(this);

     add(board);
     addKeyListener(this);
     pack();

     setLocationRelativeTo(null);
        board.init();
    }

    public static void main(String[] args){new Game(); }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPress = true;

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed= true;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPress = false;

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed= false;

        }
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isUpPress() {
        return upPress;
    }
}