package at.aaron_frick.games.Aufgabe_1_JavaGames;

import org.newdawn.slick.Graphics;

public interface Actor {
    void render(Graphics graphics);
    void update(int delta);
}
