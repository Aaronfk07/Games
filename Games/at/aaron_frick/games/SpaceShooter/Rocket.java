package at.aaron_frick.games.SpaceShooter;


import org.newdawn.slick.*;

public class Rocket implements Actor {

    private Image rocketimage;
    private float x;
    private float y;

    public Rocket(float x, float y) throws SlickException {
        Image tmp = new Image("testdata/spacecraft.png");
        this.rocketimage = tmp.getScaledCopy(100, 100);
        this.y = y;
        this.x = x;
    }


    @Override
    public void render(Graphics graphics) {
        rocketimage.draw(this.x,this.y);

    }

    @Override
    public void update(GameContainer gameContainer,int delta) {
    if(gameContainer.getInput().isKeyDown(Input.KEY_D)){
        this.x++;
    }
    if(gameContainer.getInput().isKeyDown(Input.KEY_A)){
            this.x--;
        }
    if(gameContainer.getInput().isKeyDown(Input.KEY_W)){
            this.y--;
        }
    if(gameContainer.getInput().isKeyDown(Input.KEY_S)){
            this.y++;
        }
    }


    public float getX() {
        return x +45;
    }

    public float getY() {
        return y;
    }

}
