package zygoteParts;

import environment.Position;
import org.newdawn.slick.geom.Circle;
import resource.Rhythm;

public class Core extends Node implements Heavy{

    public Circle shape;
    private float minSize = 200/2, maxSize = minSize * 1.2f; // Radius for circles, 200 d, 100 r
    private int downBeats;
    Bone [] limbs;
    int type;

    public Core(int x, int y){
        position = new Position(x, y);
        shape = new Circle(position.x,position.y,minSize);
        representation = shape;
        rhythm = new Rhythm(120); // TODO add variants in lifespan velocity
        limbs = new Bone[2]; // TODO add core variants with more/less bone connectors
        sockets = new Position[2];
        for( int i = 0; i < sockets.length; i++ ) {
            limbs[i] = new Bone(this, sockets[i] = new Position(i, this));
        }
    }

    public Bone [] getLimbs(){
        return limbs;
    }

    private Position setupSocketPositions(int amount) {
        return new Position((int)shape.getCenterX(), (int)shape.getCenterY());
    }

    private void sleep(){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            System.exit(0);
        }
    }

    public void beatUp(){
        System.out.println("beatDown iterated " + downBeats + " times");
        downBeats = 0;
        reCenter();
        shape.setRadius(maxSize);
        reCenter();
    }

    void reCenter(){
        shape.setCenterX(position.x);
        shape.setCenterY(position.y);
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
        System.out.println("In method beat " + downBeats);
        if(downBeats % 2 == 0){
            beatDown(delta);
        }
        downBeats++;
        return timePassed;
    }
}