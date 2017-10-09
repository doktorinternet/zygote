package environment;

import zygoteParts.Core;
import zygoteParts.Node;

import java.util.ArrayList;

public class Position {
    private Position [] relativePosition;
    private ArrayList<Position> relatives = new ArrayList<>();
    public int x;
    public int y;
    Node owner;
    int orientation;

    public Position(Position position, Node owner){
        this.owner = owner;
        this.x = position.x;
        this.y = position.y;
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position(int x, int y, int orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void addRelative(Position relative){
        relatives.add(relative);
    }

    Position(int x, int y, Position ... relatives){
        this.x = x;
        this.y = y;
        relativePosition = new Position[relatives.length];
        relativePosition = relatives;
    }

    public int getOrientation(){
        return orientation;
    }

    public void setOrientation(int o){
        orientation = o;
    }

    @Override
    public String toString() {
        return "This position has values x = " + x + " and y = " + y;
    }
}
