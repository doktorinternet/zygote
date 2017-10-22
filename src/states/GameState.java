package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import zygoteParts.Bone;
import zygoteParts.Constants;
import org.lwjgl.input.Mouse;
import zygoteParts.Wing;

public class GameState extends BasicGameState implements Constants {

    private Wing[] wings;
    private String mousePosition = "";
    private int timePassed;

    @Override
    public void init(GameContainer window, StateBasedGame stateBasedGame)
            throws SlickException {
        timePassed = 0;
        window.setAlwaysRender(true);
        window.setTargetFrameRate(60); // TODO delta måste med i uträkningen någonstans
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame sbg, int delta)
            throws SlickException {
        if (gameContainer.getInput().isKeyPressed(Input.KEY_2)) {
            sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
        }
        core.getShape().setCenterX(core.getPosition().getX());
        core.getShape().setCenterY(core.getPosition().getY());
        mousePosition = "Mouse X: " + Mouse.getX() + " Y: " + Mouse.getY();
        core.drag(Mouse.isButtonDown(0));
        core.spawnWing(Mouse.isButtonDown(1));

        timePassed += delta;
        timePassed = core.beat(timePassed, delta);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics)
            throws SlickException {
        graphics.drawString(mousePosition, 10, 30);
        graphics.setColor(Color.green);
        graphics.draw(core.getShape());
        graphics.fill(core.getShape());

        for (Bone bone : core.getLimbs()) {
            graphics.setColor(Color.white);
            graphics.fill(bone.getHusk());
            for (Wing wing : bone.getWings()) {
                graphics.setColor(Color.red);
                graphics.fill(wing.getShape());
            }
        }

    }

    @Override
    public int getID() {
        return 1;
    }
}
