package at.aaron_frick.games.SpaceShooter;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy {
    private float x,y;
    private float speed;
    private Image enemyImage;

    public Enemy(float x, float y, float speed) throws SlickException {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.enemyImage = new Image("testdata/enemy.png");
    }

    public void update(int delta) {
        y += speed * delta / 1000.0f;
    }

    public void render(Graphics graphics) {
        enemyImage.draw(x, y);
    }

    public float getX() { return x; }
    public float getY() { return y; }
}
