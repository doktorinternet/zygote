package zygoteParts;

import environment.Position;
import org.newdawn.slick.geom.Rectangle;

import java.util.ArrayList;

/**
 *
 *  Bone class supposed to act as connectors between nodes, mostly there for anchoring wings to core.
 *
 */

public class Bone implements Constants{

    private CircleNode root;
    CircleNode[] sinew;
    private Rectangle shape;
    private static int length = 150, thickness = 20;
    private static int[] yMeasures = {length, length, thickness, thickness};
    private static int[] xMeasures = {thickness, thickness, length, length};
    private int orientation;
    private ArrayList<Wing> wings = new ArrayList<>();
    private Position position;

    public Rectangle getHusk() {
        return shape;
    }

    Bone(CircleNode root, Position socket) {

        orientation = socket.getOrientation();
        this.root = root;
        int tempPosX = socket.getX(), tempPosY = socket.getY();


        // Center the bones to the x and y axises in the core
        if (orientation < 3) {
            tempPosX -= xMeasures[orientation] / 2;
        } else {
            tempPosY -= yMeasures[orientation] / 2;
        }

//        if( tempPosX < root.getShape().getCenterX()){
//            tempPosX -= xMeasures[orientation];
//        }
//        if( tempPosY < root.getShape().getCenterY()){
//            tempPosY -= xMeasures[orientation];
//        }
        shape = new Rectangle(tempPosX,
                tempPosY,
                xMeasures[orientation],
                yMeasures[orientation]); // TODO add variants in sizes for bones

    }

    void addWing(CircleNode parent){
        wings.add(new Wing(parent, this));
    }

    void flapWings(int timePassed, int delta){
        if(wings.size()>0){

        }
    }

    Bone(Position coreCenter, int orientation) {
        int x = coreCenter.getX(), y = coreCenter.getY();
        switch (orientation) {
            case NORTH:
                y = coreCenter.getY() - yMeasures[orientation];
                break;
            case WEST:
                x = coreCenter.getX() - xMeasures[orientation];
                break;
        }

        if (orientation < 2) {
            x -= xMeasures[orientation] / 2;
        } else {
            y -= yMeasures[orientation] / 2;
        }
        position = new Position(x, y);
        setShape(position.getX(), position.getY(), orientation);
    }

    public void setShape(int x, int y, int orientation) {
        shape = new Rectangle(x, y, xMeasures[orientation], yMeasures[orientation]);
    }

    void beat(int orientation){
        switch(orientation){
            case NORTH:
                shape.setLocation(position.getX(), position.getY());
            case SOUTH:
                shape.setLocation(position.getX(), position.getY());
            case WEST:
                shape.setLocation(position.getX(), position.getY());
            case EAST:
                shape.setLocation(position.getX(), position.getY());
        }

    }

    public ArrayList<Wing> getWings() {
        return wings;
    }
}
