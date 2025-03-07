package at.aaron_frick.games.Aufgabe_1_JavaGames;

import org.newdawn.slick.*;
import java.util.ArrayList;
import java.util.List;


public class adaptive extends BasicGame {

    private List<Actor> actors;

    public adaptive(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.actors = new ArrayList<>();
        Rectangle rectangle;

        for (int i = 0; i < 10; i++) {
            if (i%2==0){
                 rectangle = new Rectangle(Rectangle.Direction.LEFT);
            }else {
                 rectangle = new Rectangle(Rectangle.Direction.RIGHT);
            }

            this.actors.add(rectangle);
        }
        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle();
            this.actors.add(circle);
        }
        for (int i = 0; i < 10; i++) {
            Ellipse ellipse = new Ellipse();
            this.actors.add(ellipse);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

    }
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new adaptive("adaptive"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }



}


