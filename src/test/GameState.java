package test;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.ArrayList;
import java.util.Random;

public class GameState extends BasicGameState {

    private ArrayList<Circle> balls;
    private Circle mouseBall;
    private int timePassed;
    private Random random;
    private int points = 0, misses = 0;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame)
            throws SlickException {

        balls = new ArrayList<Circle>();
        mouseBall = new Circle(0,0,10);
        timePassed = 0;
        random = new Random();
        gameContainer.setAlwaysRender(true);
        gameContainer.setTargetFrameRate(60);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame sbg, int delta)
            throws SlickException {
        if(gameContainer.getInput().isKeyPressed(Input.KEY_SPACE) || misses == 10){
            sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
        }
        mouseBall.setCenterX(gameContainer.getInput().getMouseX());
        mouseBall.setCenterY(gameContainer.getInput().getMouseY());

        timePassed += delta;
        if (timePassed > 1000){
            timePassed = 0;
            balls.add(new Circle(200+random.nextInt(400),0,5));
        }

        for(Circle c : balls){
            c.setCenterY(c.getCenterY()+(delta)/2);
        }

        for(int i = balls.size()-1; i >= 0; i--){
            Circle c = balls.get(i);
            if ( c.getCenterY() > 610){
                balls.remove(i);
                misses++;
            }else if(c.intersects(mouseBall)){
                balls.remove(i);
                points++;
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics)
            throws SlickException {

        graphics.setColor(Color.yellow);
        graphics.fill(mouseBall);

        graphics.setColor(Color.green);
        graphics.drawString("Balls caught: " + points, 20, 50);

        graphics.setColor(Color.red);
        for(Circle c : balls){
            graphics.fill(c);
        }
        graphics.drawString("Balls missed: " + misses, 20, 70);
    }

    @Override
    public int getID() {
        return 1;
    }
}
