import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Hold the board for pong to take place. Along with that it holds the paddle, ball, and the timer.
public class Board extends JPanel implements ActionListener {

    final int WIDTH = 800;
    final int HEIGHT = 600;

    private final int EDGESPACE= 50;
    private final int DECORSIZE= 25;

    private  int pScore= 0, cScore = 0;


    Paddle cPaddle;
    Paddle pPaddle;
    Ball bBall;
    Timer timer;
    Game game;


    public Board(Game game){

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        pPaddle = new Paddle(this, game);
        bBall = new Ball(this);
        cPaddle = new Paddle (this, game);


    }

    public void init(){
        bBall.setPosition(WIDTH/2, HEIGHT/2);
        pPaddle.setPosition(EDGESPACE, HEIGHT/2);
        cPaddle.setPosition(WIDTH-EDGESPACE, HEIGHT/2);
        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.BOLD, 72));
        printSimpleString(Integer.toString(pScore), getWidth()/2,0,DECORSIZE*2,g);

        pPaddle.paint(g);
        cPaddle.paint(g);
        bBall.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bBall.CheckCollision(cPaddle);
        bBall.CheckCollision(pPaddle);
        bBall.move();
        cPaddle.move(bBall);
        pPaddle.move();

        repaint();
    }

    private void printSimpleString(String s, int width, int Xpos, int Ypos, Graphics g){
        int stringLen= (int)g.getFontMetrics().getStringBounds(s, g).getWidth();
        int start = width/2 - stringLen/2;
        g.drawString(s,start+Xpos, Ypos);
    }

    public int getpScore() {
        return pScore;
    }

    public void setpScore(int pScore) {
        this.pScore = pScore;
    }

    public int getcScore() {
        return cScore;
    }

    public void setcScore(int cScore) {
        this.cScore = cScore;
    }
}
