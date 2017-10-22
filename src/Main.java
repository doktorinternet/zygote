import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import states.GameState;
import zygoteParts.Constants;

public class Main extends StateBasedGame implements Constants {


    public Main(String title) {
        super(title);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Main("Zygote V0.1"));
        app.setDisplayMode(WIDTH, HEIGHT, false);
        app.start();

    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        //this.addState(new StartGameState());
        this.addState(new GameState());
        //this.addState(new GameOverState());
    }
}
