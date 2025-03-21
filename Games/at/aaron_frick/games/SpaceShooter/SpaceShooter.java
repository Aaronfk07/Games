package at.aaron_frick.games.SpaceShooter;

import at.aaron_frick.games.SpaceShooter.actors.*;
import org.newdawn.slick.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpaceShooter extends BasicGame {
    private final Random random;
    private List<Actor> actors;
    private List<Bullet> bullets;
    private List<Enemy> enemies;
    private Rocket rocket;
    private CollisionHandler collisionHandler;
    private int score;
    private int highScore;
    private boolean gameOver;
    private long gameOverTime;
    private static final String HIGHSCORE_FILE = "highscore.txt";

    public SpaceShooter(String title) {
        super(title);
        this.random = new Random();
        this.actors = new ArrayList<>();
        this.bullets = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.score = 0;
        this.gameOver = false;
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        loadHighscore();
        this.actors.add(new background("testdata/galaxy.jpg"));
        initializeStars();
        initializeEnemies();
        initializeRocket();
        this.actors.add(new Text("Welcome to Spaceshooter", 10, 10));
        this.collisionHandler = new CollisionHandler(actors, bullets, enemies, this);
    }

    private void initializeStars() throws SlickException {
        for (int i = 0; i < 100; i++) {
            this.actors.add(new Star(Star.Size.BIG));
            this.actors.add(new Star(Star.Size.MEDIUM));
            this.actors.add(new Star(Star.Size.SMALL));
        }
    }

    private void initializeEnemies() throws SlickException {
        for (int i = 0; i < 3; i++) {
            spawnEnemy();
        }
    }

    private void initializeRocket() throws SlickException {
        this.rocket = new Rocket(200, 200);
        this.actors.add(rocket);
    }

    public void spawnEnemy() throws SlickException {
        Enemy enemy = new Enemy(random.nextInt(750), -50, 5f);
        this.enemies.add(enemy);
        this.actors.add(enemy);
    }

    public void createBullet() {
        Bullet bullet = new Bullet(rocket.getX(), rocket.getY(), 10);
        this.bullets.add(bullet);
        this.actors.add(bullet);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if (gameOver) {
            if (System.currentTimeMillis() - gameOverTime > 2000) {
                if (score > highScore) {
                    saveHighscore();
                }
                gameContainer.exit();
            }
            return;
        }

        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }

        this.collisionHandler.checkCollisions();
        checkGameOver();

//        if(gameContainer.getInput().isKeyDown(Input.KEY_L)){
//            createBullet();
//        }
    }

    private void checkGameOver() {
        for (Enemy enemy : enemies) {
            if (enemy.getCollisionShape().getY() > 700) {
                gameOver = true;
                gameOverTime = System.currentTimeMillis();
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

        graphics.drawString("Score:" + score, 10, 30);
        graphics.drawString("HighScore:" + highScore, 10, 50);

        if (gameOver) {
            graphics.drawString("GAME OVER", 350, 300);
            graphics.drawString("HighScore " + highScore, 350, 320);
            graphics.drawString("Aktueller Score  " + score, 350, 350);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE && !gameOver) {
            System.out.println("Shoot");
            createBullet();
        }
    }

    private void loadHighscore() {
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(HIGHSCORE_FILE)));
            this.highScore = Integer.parseInt(fileContent);
        } catch (IOException | NumberFormatException e) {
            this.highScore = 0;
        }
    }

    private void saveHighscore() {
        try {
            Files.write(Paths.get(HIGHSCORE_FILE), String.valueOf(score).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void incrementScore() {
        this.score++;
    }


    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new SpaceShooter("SpaceShooter"));
            container.setDisplayMode(800, 600, false);
            container.setShowFPS(false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
