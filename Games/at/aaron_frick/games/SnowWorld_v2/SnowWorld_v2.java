package at.aaron_frick.games.SnowWorld_v2;

import org.newdawn.slick.*;
import java.util.ArrayList;
import java.util.List;

public class SnowWorld_v2 extends BasicGame {

    private List<Actor> actors;
    private AngelCodeFont font;

    public SnowWorld_v2(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        AngelCodeFont font = new AngelCodeFont("testdata/demo2.fnt","testdata/demo2_00.tga");

        this.actors = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            this.actors.add(new Snowflake(Snowflake.Size.BIG));
            this.actors.add(new Snowflake(Snowflake.Size.MEDIUM));
            this.actors.add(new Snowflake(Snowflake.Size.SMALL));


        }
        this.actors.add(new Text("Welcome to SnowWorld v2",275,90));

    }


        @Override
        public void update (GameContainer gameContainer,int delta) throws SlickException {


            font.drawString(80, 5, "A Font Example", Color.blue);

            for (Actor flake : this.actors) {
                flake.update(delta);
            }

        }

        @Override
        public void render (GameContainer gameContainer, Graphics graphics) throws SlickException {



            for (Actor flake : this.actors) {
                flake.render(graphics);
            }

        }

        public static void main (String[]argv){
            try {
                AppGameContainer container = new AppGameContainer(new SnowWorld_v2("SnowWorld_v2"));
                container.setDisplayMode(800, 600, false);
                container.start();
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
    }
