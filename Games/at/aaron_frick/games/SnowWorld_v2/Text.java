package at.aaron_frick.games.SnowWorld_v2;

import org.newdawn.slick.*;


public class Text implements Actor {

    private AngelCodeFont font;
    private String text;
    private float x;
    private float y;


    public Text(String text ,float x, float y){
        this.text = text;
        this.x = x;
        this.y = y;

    }

//    public void init(GameContainer gameContainer) throws SlickException {
//        font = new AngelCodeFont("testdata/demo2.fnt","testdata/demo2_00.tga");
//    }

    public void render(Graphics graphics){
       graphics.drawString(this.text,this.x,this.y);
      //  graphics.setColor(Color.blue);
        font.drawString(80, 5, "A Font Example", Color.blue);

    }

    @Override
    public void update(int delta) {

    }
}
