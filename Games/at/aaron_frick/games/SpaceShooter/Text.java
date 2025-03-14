package at.aaron_frick.games.SpaceShooter;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;


public class Text implements Actor {
    private String text;
    private float x;
    private float y;


    public Text(String text , float x, float y){
        this.text = text;
        this.x = x;
        this.y = y;

    }

    public void render(Graphics graphics){
       graphics.drawString(this.text,this.x,this.y);

    }

    @Override
    public void update(GameContainer gameContainer,int delta) {

    }
}
