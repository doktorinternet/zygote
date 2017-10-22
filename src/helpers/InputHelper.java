package helpers;

import environment.Position;
import org.lwjgl.input.Mouse;
import zygoteParts.Constants;

public class InputHelper implements Constants{

    public static Position getMPosDraw(){
        return new Position(Mouse.getX(), HEIGHT-Mouse.getY());
    }

}
