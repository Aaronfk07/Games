package at.aaron_frick.games.UserInput;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class SnowWorld_v3 extends BasicGame {

    private List<Actor> actors;
    private Rocket rocket;

    public SnowWorld_v3(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.actors = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            this.actors.add(new Snowflake(Snowflake.Size.BIG));
            this.actors.add(new Snowflake(Snowflake.Size.MEDIUM));
            this.actors.add(new Snowflake(Snowflake.Size.SMALL));


        }
        this.actors.add(new Text("Welcome to SnowWorld v2",275,90));
        Rocket rocket = new Rocket(200,200);
        this.rocket = rocket;
        this.actors.add(rocket);

    }


        @Override
        public void update (GameContainer gameContainer,int delta) throws SlickException {


            for (Actor actor : this.actors) {
                actor.update(gameContainer,delta);
            }

        }

        @Override
        public void render (GameContainer gameContainer, Graphics graphics) throws SlickException {

            for (Actor actor : this.actors) {
                actor.render(graphics);
            }

        }

    @Override
    public void keyPressed(int key, char c) {
        System.out.println(key);

        if(key == Input.KEY_SPACE || key == Input.MOUSE_LEFT_BUTTON){
            System.out.println("Shoot");
            bullet b1 = new bullet(rocket.getX() , rocket.getY(), 10);
            this.actors.add(b1);

        }

    }

    public static void main (String[]argv){
            try {
                AppGameContainer container = new AppGameContainer(new SnowWorld_v3("SnowWorld_v3"));
                container.setDisplayMode(800, 600, false);
                container.start();
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
    }
