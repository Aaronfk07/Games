package at.aaron_frick.Aufgabe1_Lists.FirstGame_v2;

import org.newdawn.slick.Graphics;

public class Text {

    private String text;
    private float x;
    private float y;

    public Text(String text ,float x, float y){
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public void render(Graphics graphics){
        graphics.drawString(this.text,this.x,this.y);
    }
}
