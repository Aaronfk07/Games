package at.aaron_frick.games.FirstGame_v1;

import org.newdawn.slick.*;

public class Objects_Game extends BasicGame {

    private float Circle_X;
    private float Circle_Y;
    private float Oval_X;
    private float Oval_Y;

    private float Rectangle_X;
    private float Rectangle_Y;
    private float speed;
    private float CircleSpeed;
    private float OvalSpeed;

    private Direction Recdirection;
    private Direction Cirdirection;
    private Direction Ovaldirection;

    public Objects_Game(String title) {
        super(title);
        this.Recdirection = Direction.RIGHT;
        this.Cirdirection = Direction.DOWN;
        this.Ovaldirection = Direction.RIGHT;
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Objects_Game("Rectangle"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.Circle_X = 0;
        this.Circle_Y = 100;

        this.Oval_X = 100;
        this.Oval_Y = 0;

        this.Rectangle_X = 100;
        this.Rectangle_Y = 100;

        this.speed = 1f;
        this.CircleSpeed = 1f;
        this.OvalSpeed = 1f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        switch (Recdirection) {
            case RIGHT: // Moving right
                this.Rectangle_X += speed * delta;
                if (this.Rectangle_X > 600) {
                    this.Rectangle_X = 600;
                    Recdirection = Direction.DOWN;
                }
                break;
            case DOWN: // Moving down
                this.Rectangle_Y += speed * delta;
                if (this.Rectangle_Y > 400) {
                    this.Rectangle_Y = 400;
                    Recdirection = Direction.LEFT;
                }
                break;
            case LEFT: // Moving left
                this.Rectangle_X -= speed * delta;
                if (this.Rectangle_X < 100) {
                    this.Rectangle_X = 100;
                    Recdirection = Direction.UP;
                }
                break;
            case UP: // Moving up
                this.Rectangle_Y -= speed * delta;
                if (this.Rectangle_Y < 100) {
                    this.Rectangle_Y = 100;
                    Recdirection = Direction.RIGHT;
                }
                break;
        }

        switch (Cirdirection) {
            case DOWN:
                this.Circle_Y += CircleSpeed * delta;
                if (this.Circle_Y >= 400) {
                    this.Circle_Y = 400;
                    Cirdirection = Direction.UP;
                }
                break;
            case UP:
                this.Circle_Y -= CircleSpeed * delta;
                if (this.Circle_Y <= 100) {
                    this.Circle_Y = 100;
                    Cirdirection = Direction.DOWN;
                }
                break;


        }
        switch (Ovaldirection) {

            case RIGHT:
                this.Oval_X += OvalSpeed * delta;
                if (this.Oval_X >= 600) {
                    this.Oval_X = 600;
                    Ovaldirection = Direction.LEFT;
                }
                break;
            case LEFT:
                this.Oval_X -= OvalSpeed * delta;
                if (this.Oval_X <= 100) {
                    this.Oval_X = 100;
                    Ovaldirection = Direction.RIGHT;
                }
                break;


        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.Rectangle_X, this.Rectangle_Y, 100, 100);
        graphics.drawString("This is the Coolest Game", 80, 80);
        graphics.drawOval(this.Circle_X, this.Circle_Y, 100, 100, 50);
        graphics.drawOval(this.Oval_X, this.Oval_Y, 100, 50, 100);
    }

    public enum Direction {
        RIGHT, DOWN, LEFT, UP
    }
}
