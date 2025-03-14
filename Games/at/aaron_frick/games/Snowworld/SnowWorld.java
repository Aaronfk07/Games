package at.aaron_frick.games.Snowworld;


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
            this.snowflakes.add(new snowflake(snowflake.Size.BIG));
            this.snowflakes.add(new snowflake(snowflake.Size.MEDIUM));
            this.snowflakes.add(new snowflake(snowflake.Size.SMALL));
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Actor flake : this.snowflakes) {
            flake.update(delta);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (Actor flake : this.snowflakes) {
            flake.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new SnowWorld("SnowWorld"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}