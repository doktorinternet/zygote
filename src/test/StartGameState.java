package test;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class StartGameState extends BasicGameState {
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame sbg, int i) throws SlickException {
        if(gameContainer.getInput().isKeyPressed(Input.KEY_SPACE)){
            sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("Welcome to Zygote", gameContainer.getWidth()/2, gameContainer.getHeight()/2);
    }

    @Override
    public int getID() {
        return 0;
    }
}
