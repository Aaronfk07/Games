package at.aaron_frick.Aufgabe1_Lists;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor {
    private float x;
    private float y;
    private float speed;
    private float diameter;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(600);
        this.y = random.nextInt(300);
        this.speed = random.nextInt(20) + 10;
        this.diameter = random.nextInt(100) + 50;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);

    }

    public void update(int delta) {
        this.y += (float) delta / this.speed;
        this.diameter += (float) (delta * 0.01); // Circles grow larger over time
        if (this.y >= 700) {
            this.y = 0;
        }

    }
}
