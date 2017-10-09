package zygoteParts;

import environment.Position;
import org.newdawn.slick.geom.Circle;
import resource.Rhythm;

public class Core extends Node implements Heavy{

     final static int NORTH = 0;
    final static  int SOUTH = 1;
    final static  int EAST = 2;
    final static  int WEST = 3;


    public Circle shape;
    private float minSize = 150/2, maxSize = minSize * 1.2f; // Diameter/2 = Radius for circle
    private int downBeats;
    Bone [] limbs;

    // TODO FIX A LOT OF TEMPORARY VALUES EVERYWHERE!!! D:
    int type = 4; // 1-4
    int bpm = 120;

    public Core(int x, int y){

        position = new Position(x, y);
        shape = new Circle(position.x,position.y,minSize);
        representation = shape;
        rhythm = new Rhythm(bpm); // TODO add variants in lifespan velocity
        limbs = new Bone[type]; // TODO add core variants with more/less bone connectors

        for( int i = 0; i < type; i++ ) {
            limbs[i] = new Bone(this.position, i);
        }

    }

    public Bone [] getLimbs(){
        return limbs;
    }

    void setType(int type){ this.type = type;}

    public Circle getShape() {
        return shape;
    }

    void reCenter(){
        shape.setCenterX(position.x);
        shape.setCenterY(position.y);
    }

    public void beatUp(){
        downBeats = 0;
        reCenter();
        shape.setRadius(maxSize);
        reCenter();
    }

    public void beatDown(int delta){
        reCenter();
        float r = shape.getRadius();
        shape.setRadius(r * (1f-(float)delta/2500f)); // delta 16 = 60 fps, 32 = 30 fps;
        reCenter();
    }

    public int beat(int timePassed, int delta){
        if (timePassed > rhythm.millisPerBeat()){ //
            timePassed = 0;
            beatUp();
        }
        if(downBeats % 2 == 0){
            beatDown(delta);
        }
        downBeats++;
        return timePassed;
    }

    private Position setupSocketPositions(int orientation) {
        switch(orientation){
            case NORTH:
                return new Position((int)shape.getCenterX(),
                        (int)getSocketPosition(shape.getCenterY(),true),
                        orientation);
            case SOUTH:
                return new Position((int)shape.getCenterX(),
                        (int)getSocketPosition(shape.getCenterY(),false),
                        orientation);
            case EAST:
                return new Position((int)getSocketPosition(shape.getCenterX(),true),
                        (int)shape.getCenterY(),
                        orientation);
            case WEST:
                return new Position((int)getSocketPosition(shape.getCenterX(),false),
                        (int)shape.getCenterY(),
                        orientation);
            default:
                return null;
        }
    }

    private float getSocketPosition(float centerAxis, boolean positive){
        float radius = shape.getRadius();
        if(positive)
            return centerAxis + (radius/4f)*3f;
        else
            return centerAxis - (radius/4f)*3f;

    }

    private void sleep(){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            System.exit(0);
        }
    }
}