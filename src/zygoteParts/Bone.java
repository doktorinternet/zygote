package zygoteParts;

import environment.Position;
import org.newdawn.slick.geom.Rectangle;

public class Bone {

    private Node root;
    Node [] sinew;
    private Rectangle shape;

    public Rectangle getHusk(){
        return shape;
    }

    Bone(Node root, Position position ){
        this.root = root;
        shape = new Rectangle(position.x, position.y, 40, 10); // TODO add variants in sizes for bones
    }

}
