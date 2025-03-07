package at.aaron_frick.games.ImageActor;

import org.newdawn.slick.Graphics;

public interface Actor {
    void render(Graphics graphics);
    void update(int delta);

}
