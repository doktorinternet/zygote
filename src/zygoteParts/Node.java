package zygoteParts;

import environment.Position;
import org.newdawn.slick.geom.Shape;
import resource.Rhythm;
import resource.Sound;

public class Node {

    public Position position;
    public Position [] sockets;
    int connectors;
    int direction;
    Sound [] sounds;
    Sound sound;
    Rhythm rhythm;
    Shape representation;

    // Default
    public Node(){}

    public Rhythm rhythmOf(){
        return rhythm;
    }

    public Node(Shape representation){
        this.representation = representation;
    }

    /** Overridden in core
     *
     * Params
     * Rhythm, sound
     *
     *
     *  return boolean?
     *
    */
    void beat(int limit){
        for(int i = 0; i < limit; i++){
            position = new Position(position.x+i, position.y+i);
            if(i==limit){
                for(; i > 0; i--){
                    position = new Position(position.x+i, position.y+i);
                }
            }
        }
    }
}
