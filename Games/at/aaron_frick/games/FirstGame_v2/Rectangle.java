package at.aaron_frick.games.FirstGame_v2;

import org.newdawn.slick.Graphics;

public class Rectangle {

    private Direction direction = Direction.RIGHT;

    public enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    private float x;
    private float y;
    private float speed;

    public Rectangle(int x, int y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = 1f;
    }

    public void render(Graphics graphics){
        graphics.drawRect(this.x,this.y,100,100);

    }

    public void update(int delta){

        switch (direction) {
            case RIGHT: // Moving right
                this.x += speed * delta;
                if (this.x > 600) {
                    this.x = 600;
                    direction = Direction.DOWN;
                }
                break;
            case DOWN: // Moving down
                this.y += speed * delta;
                if (this.y > 400) {
                    this.y = 400;
                    direction = Direction.LEFT;
                }
                break;
            case LEFT: // Moving left
                this.x -= speed * delta;
                if (this.x < 100) {
                    this.x = 100;
                    direction = Direction.UP;
                }
                break;
            case UP: // Moving up
                this.y -= speed * delta;
                if (this.y < 100) {
                    this.y = 100;
                    direction = Direction.RIGHT;
                }
                break;
        }

    }
}
