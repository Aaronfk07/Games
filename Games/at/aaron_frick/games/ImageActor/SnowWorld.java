package at.aaron_frick.games.ImageActor;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class SnowWorld extends BasicGame {


    private List<Actor> snowflakes;

    public SnowWorld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.snowflakes = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            this.snowflakes.add(new Snowflake(Snowflake.Size.BIG));
            this.snowflakes.add(new Snowflake(Snowflake.Size.MEDIUM));
            this.snowflakes.add(new Snowflake(Snowflake.Size.SMALL));


        }
    }


        @Override
        public void update (GameContainer gameContainer,int delta) throws SlickException {

            for (Actor flake : this.snowflakes) {
                flake.update(delta);
            }

        }

        @Override
        public void render (GameContainer gameContainer, Graphics graphics) throws SlickException {

            for (Actor flake : this.snowflakes) {
                flake.render(graphics);
            }
        }

        public static void main (String[]argv){
            try {
                AppGameContainer container = new AppGameContainer(new SnowWorld("ImageActor"));
                container.setDisplayMode(800, 600, false);
                container.start();
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
    }
