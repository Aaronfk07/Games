package at.aaron_frick.games.FirstGame_v2;

import org.newdawn.slick.Graphics;

public class Circle {

    private Direction direction = Direction.DOWN;
    private float x;
    private float y;
    private float speed;

    private float diameter;

    public Circle(int x, int y, float speed, float diameter) {
        this.x = 0;
        this.y = 100;
        this.speed = 1f;
        this.diameter = 100;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);

    }

    public void update(int delta) {
        switch (direction) {
            case DOWN:
                this.y += speed * delta;
                if (this.y >= 400) {
                    this.y = 400;
                    direction = Direction.UP;
                }
                break;
            case UP:
                this.y -= speed * delta;
                if (this.y <= 100) {
                    this.y = 100;
                    direction = Direction.DOWN;
                }
                break;


        }
    }

    public enum Direction {
        RIGHT, DOWN, LEFT, UP
    }
}