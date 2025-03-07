package at.aaron_frick.games.Aufgabe_1_JavaGames;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Rectangle implements Actor {


    private Direction direction;

    public enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    private float x;
    private float y;
    private float speed;
    private int size;

    public Rectangle(Direction direction) {

        Random random = new Random();
        this.x = random.nextInt(600);
        this.y = random.nextInt(500);
        this.speed = random.nextInt(20) + 10;
        this.size = random.nextInt(200) + 50;
        this.direction = direction;
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, this.size, this.size);

    }

    public void update(int delta) {
        if (direction == Direction.RIGHT) {
            this.x += (float) delta / this.speed;
            if (this.x > 800) {
                this.x = 0;
            }
        } else if (direction == Direction.LEFT) {
            this.x -= (float) delta / this.speed;
            if (this.x < 0) {
                this.x = 800;
            }
        }
    }

}

