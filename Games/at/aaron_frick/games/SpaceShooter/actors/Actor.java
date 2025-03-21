package at.aaron_frick.games.SpaceShooter.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Actor {
    void render(Graphics graphics);
    void update(GameContainer gameContainer, int delta);

}
