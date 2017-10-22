package zygoteParts;

import environment.Position;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.geom.Circle;
import resource.Rhythm;

public class CircleNode implements Constants {

    private Position position;

    private static Rhythm rhythm;
    private Circle shape;

    int downBeats = 0;
    int other = 1;

    private float maxSize;

    private float minSize;

    // Default
    public CircleNode() {
    }

    public CircleNode(Circle representation) {
        this.shape = representation;
    }

    public Rhythm rhythmOf() {
        return rhythm;
    }

    public void drag(boolean mb1Held) {
        if (mb1Held) {
            shape.setCenterX(Mouse.getX());
            shape.setCenterY(HEIGHT - Mouse.getY());
        }
    }

    public int beat(int timePassed, int delta) {
        if (timePassed > rhythm.millisPerBeat()) { //
            timePassed = 0;
            beatUp(maxSize);
        }
        if (downBeats % 2 == 0) {
            beatDown(delta);
        }
        downBeats++;
        return timePassed;
    }

    public void beatUp(float maxSize) {
        downBeats = 0;
        reCenter();
        shape.setRadius(maxSize);
        reCenter();
    }

    public void beatDown(int delta) {
        reCenter();
        float r = shape.getRadius();
        shape.setRadius(r * (1f - (float) delta / 2500f)); // delta 16 = 60 fps, 32 = 30 fps;
        reCenter();
    }

    void reCenter() {
        shape.setCenterX(position.getX());
        shape.setCenterY(position.getY());
    }

    public Circle getShape() {
        return shape;
    }

    public void setShape(Circle shape) {
        this.shape = shape;
    }

    public float getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(float maxSize) {
        this.maxSize = maxSize;
    }

    public float getMinSize() {
        return minSize;
    }

    public void setMinSize(float minSize) {
        this.minSize = minSize;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Rhythm getRhythm() {
        return rhythm;
    }

    public void setRhythm(Rhythm rhythm) {
        this.rhythm = rhythm;
    }
}
