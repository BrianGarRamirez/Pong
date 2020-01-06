import java.awt.*;

public class Ball {
    private int x,y, diameter=29;
    private final int SPEED = 4;

    private double dx = SPEED;
    private double dy = SPEED;

    Board board;

    public Ball(Board board){
        x=30;
        y=30;

        //'this' keyword references the object that is executing or calling the this reference

        this.board = board;
    }

    public void move(){

      // LEFT AND RIGHT
      if( x <= 0){
          board.setcScore(board.getcScore() +1);
          dx*=-1;
      }
        if(x +diameter >= board.getWidth()){
            board.setpScore(board.getcScore() +1);
            dx*=-1;
        }
      if(y<=0 || y + diameter >= board.getHeight()){
          dy*=-1;
      }

      x +=dx;
      y+=dy;
    }

    public void setPosition(int x, int y){

        this.x=x-diameter/2;
        this.y=y-diameter/2;

    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,diameter, diameter);
    }
    double MAXANGLE = 5*Math.PI/12;

    public void CheckCollision(Paddle other) {
        if (getBounds().intersects(other.getBounds())) {
            if (x < board.getWidth() / 2) {
                dx *= -1;
            }
            if (x > board.getWidth() / 2) {
                dx *= -1;
            }

        }
    }


    public void paint(Graphics g){
        g.fillOval(x,y, diameter, diameter);
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

    public int getDiam() {
        return diameter;
    }
}
