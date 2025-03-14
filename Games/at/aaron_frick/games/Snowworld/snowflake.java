package at.aaron_frick.games.Snowworld;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.Random;

public class snowflake implements Actor {

    // private Image image;
    private float x;
    private float y;
    private float speed;
    private float diameter;


    public void setRandomPosition(){
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600) - 600;
    }
    public snowflake(Size size) throws SlickException {
        //  this.image = new Image("res/icon.png");

        switch (size) {
            case SMALL:
                this.speed = 10;
                this.diameter = 4;
                break;
            case MEDIUM:
                this.speed = 5;
                this.diameter = 8;
                break;
            case BIG:
                this.speed = 2;
                this.diameter = 12;
                break;
        }

        setRandomPosition();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.diameter, this.diameter);
       // graphics.drawImage("res/icon.png",this.x,this.y,);
    }

    @Override
    public void update(int delta) {
        this.y += (float) delta / this.speed;
        if (this.y >= 600) {
           setRandomPosition();

        }


    }

    public enum Size {
        SMALL, MEDIUM, BIG,
    }
}