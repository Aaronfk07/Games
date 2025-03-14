package at.aaron_frick.games.SpaceShooter;


import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class SpaceShooter extends BasicGame {

    private List<Actor> actors;
    private Rocket rocket;
    private background background;

    public SpaceShooter(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.actors = new ArrayList<>();
        this.actors.add(new background("testdata/galaxy.jpg"));

        for (int i = 0; i < 100; i++) {
            this.actors.add(new Star(Star.Size.BIG));
            this.actors.add(new Star(Star.Size.MEDIUM));
            this.actors.add(new Star(Star.Size.SMALL));


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
            Bullet b1 = new Bullet(rocket.getX() , rocket.getY(), 10);
            this.actors.add(b1);

        }

    }

    public static void main (String[]argv){
            try {
                AppGameContainer container = new AppGameContainer(new SpaceShooter("SpaceShooter"));
                container.setDisplayMode(800, 600, false);
                container.start();
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
    }
