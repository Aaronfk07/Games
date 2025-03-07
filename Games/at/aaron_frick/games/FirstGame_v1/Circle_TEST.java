package at.aaron_frick.games.FirstGame_v1;

import org.newdawn.slick.*;

public class Circle_TEST extends BasicGame {

    private float CircleWidth;
    private float CircleLength;

    private float circelspeed;
    private int direction; // 0 = right, 1 = down, 2 = left, 3 = up

    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int UP = 3;


    public Circle_TEST(String title) {
        super(title);
        this.direction = DOWN; // Start moving to the right
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.CircleWidth = 0;
        this.CircleLength = 0;

        this.circelspeed = 0.1f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        switch(direction){
            case DOWN:
                this.CircleLength += circelspeed * delta;
                if (this.CircleLength >= 500) {
                    this.CircleLength = 500;
                    direction = UP;
                }
                break;
            case UP:
                this.CircleLength -= circelspeed * delta;
                if (this.CircleLength <= 100) {
                    this.CircleLength = 100;
                    direction = DOWN;
                }
                break;


        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawOval(this.CircleWidth,this.CircleLength,100,100,100);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new Circle_TEST("Circle"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
    }

