package at.aaron_frick.games.SpaceShooter_v2;


import org.newdawn.slick.SlickException;

import java.util.Iterator;
import java.util.List;

public class CollisionHandler {
    private final List<Actor> actors;
    private final List<Bullet> bullets;
    private final List<Enemy> enemies;
    private final SpaceShooter spaceShooter;

    public CollisionHandler(List<Actor> actors, List<Bullet> bullets, List<Enemy> enemies, SpaceShooter spaceShooter) {
        this.actors = actors;
        this.bullets = bullets;
        this.enemies = enemies;
        this.spaceShooter = spaceShooter;
    }

    public void checkCollisions() throws SlickException {
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
                    spaceShooter.spawnEnemy();
                    spaceShooter.incrementScore();
                    break;
                }
            }
            
            if (bullet.getCollisionShape().getY() < -20) {
                bulletIterator.remove();
                actors.remove(bullet);
            }
        }
    }
}