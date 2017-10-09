package environment;

import zygoteParts.Node;

public class Position {
    Position [] relativePosition;
    public int x;
    public int y;
    Node owner;

    public Position(int orientation, Node owner){
        this.owner = owner;


    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    Position(int x, int y, Position ... relatives){

    }

}
