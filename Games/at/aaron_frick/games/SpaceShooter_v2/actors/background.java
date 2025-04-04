package at.aaron_frick.games.SpaceShooter_v2.actors;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class background implements Actor {
    private Image background;
    private float y;
    private float speed = 0.05f;

    public background(String path) throws SlickException {
        background = new Image(path);
        y = 0;
    }

    public void update(GameContainer gameContainer,int delta) {
        y += speed * delta;
        if (y >= background.getHeight()) {
            y = 0;
        }
    }

    public void render(Graphics g) {
        g.drawImage(background, 0, y);
        g.drawImage(background, 0, y - background.getHeight());
    }

}
