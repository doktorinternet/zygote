package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import zygoteParts.Bone;
import zygoteParts.Core;


public class GameState extends BasicGameState {

    private Core core;
    private int timePassed;

    @Override
    public void init(GameContainer window, StateBasedGame stateBasedGame)
            throws SlickException {
        core = new Core(window.getWidth()/2, window.getHeight()/2);
        timePassed = 0;
        window.setAlwaysRender(true);
        window.setTargetFrameRate(60); // TODO delta måste med i uträkningen någonstans
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame sbg, int delta)
            throws SlickException {
        if(gameContainer.getInput().isKeyPressed(Input.KEY_2)){
            sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
        }
        core.shape.setCenterX(core.position.x);
        core.shape.setCenterY(core.position.y);

        timePassed += delta;
        timePassed = core.beat(timePassed, delta);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics)
            throws SlickException {

        graphics.setColor(Color.green);
        graphics.draw(core.shape);
        graphics.fill(core.shape);

        graphics.setColor(Color.white);
        for (Bone bone : core.getLimbs()){
            graphics.fill(bone.getHusk());
        }

    }

    @Override
    public int getID() {
        return 1;
    }
}
