package environment;

import zygoteParts.CircleNode;

import java.util.ArrayList;

public class Position {
    private Position[] relativePosition;
    private ArrayList<Position> relatives = new ArrayList<>();
    private int x;
    private int y;
    CircleNode owner;
    int orientation;

    public Position(Position position, CircleNode owner) {
        this.owner = owner;
        this.x = position.x;
        this.y = position.y;
    }

    public Position(float x, float y) {
        this.x = (int)x;
        this.y = (int)y;
    }

    public Position(int x, int y, int orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void addRelative(Position relative) {
        relatives.add(relative);
    }

    Position(int x, int y, Position... relatives) {
        this.x = x;
        this.y = y;
        relativePosition = new Position[relatives.length];
        relativePosition = relatives;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int o) {
        orientation = o;
    }

    @Override
    public String toString() {
        return "This position has values x = " + x + " and y = " + y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
