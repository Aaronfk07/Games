package at.aaron_frick.games.SpaceShooter;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Bullet implements Actor {

    private float x,y;
    private float diameter;

    public Bullet(float x, float y, float diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    @Override

    public void render(Graphics graphics) {
        graphics.fillOval(this.x,this.y,this.diameter,this.diameter);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y--;
    }
}
