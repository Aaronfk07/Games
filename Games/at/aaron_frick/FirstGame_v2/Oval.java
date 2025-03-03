package at.aaron_frick.FirstGame_v2;

import org.newdawn.slick.Graphics;

public class Oval {

    private Direction direction = Direction.RIGHT;

    public enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    private float x;
    private float y;
    private float speed;

    public Oval(int x, int y, float speed) {
        this.x = 100;
        this.y = 0;
        this.speed = 1f;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, 100, 70);

    }

    public void update(int delta) {
        switch (direction) {

            case RIGHT:
                this.x += speed * delta;
                if (this.x >= 600) {
                    this.x = 600;
                    direction = Direction.LEFT;
                }
                break;
            case LEFT:
                this.x -= speed * delta;
                if (this.x <= 100) {
                    this.x = 100;
                    direction = Direction.RIGHT;
                }
                break;


        }


        }
    }

