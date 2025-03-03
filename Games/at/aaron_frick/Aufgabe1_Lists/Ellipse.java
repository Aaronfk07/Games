package at.aaron_frick.Aufgabe1_Lists;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Ellipse implements Actor {


    private float x,y;
    private float speed;
    private float width,height;

    public Ellipse() {
        Random random = new Random();
        this.x = random.nextInt(600);
        this.y = random.nextInt(300);
        this.speed = random.nextInt(20)+10;
        this.width = random.nextInt(100)+50;
        this.height = random.nextInt(50)+10;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x,this.y,this.width,this.height);
    }

    @Override
    public void update(int delta) {
        this.x += (float)delta/this.speed;
        if(this.x > 800){
            this.x = 0;
        }
        this.y += (float)delta/this.speed;
        if(this.y > 800){
            this.y = 0;
        }

    }
}
