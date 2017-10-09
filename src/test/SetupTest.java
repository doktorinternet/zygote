package test;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class SetupTest extends StateBasedGame {

    public SetupTest(String title) {
        super(title);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new SetupTest("Setup Test"));
        app.setDisplayMode(800, 600, false);
        app.start();
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new GameState());
        this.addState(new GameOverState());

    }
}
