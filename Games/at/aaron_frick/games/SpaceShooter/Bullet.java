package at.aaron_frick.games.SpaceShooter;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class Bullet implements CollisionActors {

    private float x,y;
    private float diameter;
    private final Shape shape;
    private float speed;

    public Bullet(float x, float y, float diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.shape = new Circle(x,y,diameter /2);
    }

    @Override

    public void render(Graphics graphics) {
        graphics.fillOval(this.x,this.y,this.diameter,this.diameter);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y--;
        ( shape).setCenterY(y);
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public Shape getCollisionShape() {
        return shape;
    }
}


