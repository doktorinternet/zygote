package states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState {
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame)
            throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i)
            throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics)
            throws SlickException {
        graphics.drawString("Game Over!", gameContainer.getWidth()/2, gameContainer.getHeight()/2);
    }

    @Override
    public int getID() {
        return 2;
    }
}
