package at.aaron_frick.games.snowworld;

import org.newdawn.slick.Graphics;

public interface Actor {
    void render(Graphics graphics);
    void update(int delta);
}
