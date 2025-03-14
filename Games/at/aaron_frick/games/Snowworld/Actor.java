package at.aaron_frick.games.Snowworld;

import org.newdawn.slick.Graphics;

public interface Actor {
    void render(Graphics graphics);
    void update(int delta);
}
