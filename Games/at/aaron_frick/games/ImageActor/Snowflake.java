package at.aaron_frick.games.ImageActor;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.Random;


public class Snowflake implements Actor {

    private Image SnowflakeImage;
    private float x;
    private float y;
    private float speed;
    private float diameter;


    public void setRandomPosition() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600) - 600;
    }

    public Snowflake(Size size) throws SlickException {
        Image tmp = new Image("testdata/snowflake_png.png");
        this.SnowflakeImage = tmp.getScaledCopy(20, 20);


        switch (size) {
            case SMALL:
                this.speed = 10;
                this.diameter = 10;
                break;
            case MEDIUM:
                this.speed = 5;
                this.diameter = 20;
                break;
            case BIG:
                this.speed = 2;
                this.diameter = 30;
                break;
        }

        setRandomPosition();
    }


    @Override
    public void render(Graphics graphics) {
        this.SnowflakeImage.draw(this.x, this.y,this.diameter,this.diameter);


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
