package at.aaron_frick.games.SpaceShooter;


import org.newdawn.slick.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpaceShooter extends BasicGame {

    private final Random random;
    private List<Actor> actors;
    private List<Bullet> bullets;
    private List<Enemy> enemies;
    private Rocket rocket;
    private background background;

    public SpaceShooter(String title) {
        super(title);
        this.random = new Random();
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.actors = new ArrayList<>();
        this.bullets = new ArrayList<>();
        this.enemies = new ArrayList<>();

        this.actors.add(new background("testdata/galaxy.jpg"));
        for (int i = 0; i < 100; i++) {
            this.actors.add(new Star(Star.Size.BIG));
            this.actors.add(new Star(Star.Size.MEDIUM));
            this.actors.add(new Star(Star.Size.SMALL));
        }
        for (int i = 0; i < 10; i++) {
            Enemy enemy= new Enemy(random.nextInt(600),random.nextInt(200)-100,0.2f);
            this.enemies.add(enemy);
            this.actors.add(enemy);
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
                checkCollisions();

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

        if(key == Input.KEY_SPACE) {
            System.out.println("Shoot");
            Bullet bullet = new Bullet(rocket.getX() , rocket.getY(), 10);
            this.bullets.add(bullet);
            this.actors.add(bullet);

        }

    }

    public void checkCollisions() {


        Iterator<Bullet> bulletIterator = bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            Iterator<Enemy> enemyIterator = enemies.iterator();
            while (enemyIterator.hasNext()) {
                Enemy enemy = enemyIterator.next();
                if (bullet.getCollisionShape().intersects(enemy.getCollisionShape())) {
                    bulletIterator.remove();
                    enemyIterator.remove();
                    actors.remove(bullet);
                    actors.remove(enemy);
                    break;
                }
            }
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
