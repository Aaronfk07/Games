package at.aaron_frick.games.SpaceShooter;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Enemy implements CollisionActors {
    private float x,y;
    private float speed;
    private Image enemyImage;
    private final Shape shape;

    public Enemy(float x, float y, float speed) throws SlickException {
        Random random = new Random();
        this.x = x;
        this.y = y;
        this.speed = speed;
        Image tmp = new Image("testdata/enemy1.png");
        this.enemyImage = tmp.getScaledCopy(100,100);
        this.shape = new Rectangle(x,y, enemyImage.getWidth(), enemyImage.getHeight());

    }

    public void update( GameContainer gameContainer, int delta) {
        y += speed * delta / 1000.0f;
        (shape).setY(y);
    }

    public void render(Graphics graphics) {
        enemyImage.draw(x, y);
    }

    public float getX() { return x; }
    public float getY() { return y; }

    @Override
    public Shape getCollisionShape() {
        return shape;
    }
}
