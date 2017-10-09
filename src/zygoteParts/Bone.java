package zygoteParts;

import environment.Position;
import org.newdawn.slick.geom.Rectangle;

import static zygoteParts.Core.NORTH;
import static zygoteParts.Core.SOUTH;
import static zygoteParts.Core.EAST;
import static zygoteParts.Core.WEST;

public class Bone {

    private Node root;
    Node [] sinew;
    private Rectangle shape;
    static int l = 150, s = 20;
    private static int [] yMeasures = {l, l, s, s};
    private static int [] xMeasures = {s, s, l, l};
    private int orientation;

    public Rectangle getHusk(){
        return shape;
    }

    Bone(Node root, Position socket){

        orientation = socket.getOrientation();
        this.root = root;
        int tempPosX = socket.x, tempPosY = socket.y;


        // Center the bones to the x and y axises in the core
        if(orientation < 3) {
            tempPosX -= xMeasures[orientation]/2;
        }

        else {
            tempPosY -= yMeasures[orientation]/2;
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

    Bone(Position coreCenter, int orientation){
        int x = coreCenter.x, y = coreCenter.y;
        switch(orientation){
            case NORTH:
                y = coreCenter.y - yMeasures[orientation];
                break;
            case WEST:
                x = coreCenter.x - xMeasures[orientation];
                break;
        }

        if(orientation < 2) {
            x -= xMeasures[orientation]/2;
        }

        else {
            y -= yMeasures[orientation]/2;
        }
        shape = new Rectangle(x,
                              y,
                              xMeasures[orientation],
                              yMeasures[orientation]);

    }

    public void setShape(int x, int y, int orientation) {
        shape = new Rectangle(x, y, xMeasures[orientation], yMeasures[orientation]);

    }
}
