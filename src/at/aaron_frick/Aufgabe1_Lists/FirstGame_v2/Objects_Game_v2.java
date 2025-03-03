package at.aaron_frick.Aufgabe1_Lists.FirstGame_v2;

import org.newdawn.slick.*;


public class Objects_Game_v2 extends BasicGame {

    private Rectangle rectangle;
    private Circle circle;
    private Oval oval;
    private Text text;

    public Objects_Game_v2(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.rectangle = new Rectangle(100, 100, 5);
        this.circle = new Circle(100,100,5,100);
        this.oval = new Oval(100,70,5);
        this.text = new Text("Hallo Dies ist ein Cooles Spiel",80,90);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        this.rectangle.update(delta);
        this.circle.update(delta);
        this.oval.update(delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        this.rectangle.render(graphics);
        this.circle.render(graphics);
        this.oval.render(graphics);
        this.text.render(graphics);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Objects_Game_v2("MOIN"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
