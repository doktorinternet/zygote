import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import states.GameOverState;
import states.GameState;
import states.StartGameState;

public class Main extends StateBasedGame{


    public Main(String title) {
        super(title);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Main("Zygote V0.1"));
        app.setDisplayMode(800, 600, false);
        app.start();
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        //this.addState(new StartGameState());
        this.addState(new GameState());
        //this.addState(new GameOverState());
    }
}
