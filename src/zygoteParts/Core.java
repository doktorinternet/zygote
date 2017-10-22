package zygoteParts;

import environment.Position;
import helpers.InputHelper;
import org.newdawn.slick.geom.Circle;
import resource.Rhythm;

public class Core extends CircleNode implements Heavy {

    Bone[] limbs;
    int CREDITS = 501;

    // TODO FIX A LOT OF TEMPORARY VALUES EVERYWHERE!!! D:
    int type = 4; // 1-4
    int bpm = 120;

    public Core(int x, int y) {

        setMinSize(150/2);
        setMaxSize(getMinSize()*GROWTH);
        setPosition(new Position(x, y));
        setShape(new Circle(getPosition().getX(), getPosition().getY(), getMinSize()));
        setRhythm(new Rhythm(bpm)); // TODO add variants in lifespan velocity
        limbs = new Bone[type]; // TODO add core variants with more/less bone connectors

        for (int i = 0; i < type; i++) {
            limbs[i] = new Bone(getPosition(), i);
        }

    }

    public Bone[] getLimbs() {
        return limbs;
    }

    void setType(int type) {
        this.type = type;
    }

    void reCenter() {
        getShape().setCenterX(getPosition().getX());
        getShape().setCenterY(getPosition().getY());
    }

    @Override
    public int beat(int timePassed, int delta) {
        if (timePassed > getRhythm().millisPerBeat()) {
            timePassed = 0;
            beatUp(getMaxSize());
            if(other % 2 == 0){
                for (Bone b : limbs) {
                    for (Wing wing : b.getWings()) {
                        wing.beatUp(wing.getMaxSize());
                    }
                }
            }
            other++;

        }
        if (downBeats % 2 == 0) {
            beatDown(delta);
        }else{
            for (Bone b : limbs) {
                for (Wing wing : b.getWings()) {
                    wing.beatDown(delta);
                }
            }
        }
        downBeats++;
        return timePassed;
    }

    private Position setupSocketPositions(int orientation) {
        switch (orientation) {
            case NORTH:
                return new Position((int) getShape().getCenterX(),
                        (int) getSocketPosition(getShape().getCenterY(), true),
                        orientation);
            case SOUTH:
                return new Position((int) getShape().getCenterX(),
                        (int) getSocketPosition(getShape().getCenterY(), false),
                        orientation);
            case EAST:
                return new Position((int) getSocketPosition(getShape().getCenterX(), true),
                        (int) getShape().getCenterY(),
                        orientation);
            case WEST:
                return new Position((int) getSocketPosition(getShape().getCenterX(), false),
                        (int) getShape().getCenterY(),
                        orientation);
            default:
                return null;
        }
    }

    private float getSocketPosition(float centerAxis, boolean positive) {
        float radius = getShape().getRadius();
        if (positive)
            return centerAxis + (radius / 4f) * 3f;
        else
            return centerAxis - (radius / 4f) * 3f;

    }

    private void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.exit(0);
        }
    }

    int getLimb(Position rightMouseButtonClick) {
        int ret = 0;
        int[][] areas = new int[limbs.length - 1][2];
        for (int i = 0; i < limbs.length - 1; i++) {
            int index = 0;
            areas[i][index] = (int) limbs[i].getHusk().getHeight();
            areas[i][index + 1] = (int) limbs[i].getHusk().getWidth();
        }
        for (int i = 0; i < areas.length - 1; i++) {
            for (int j = 0; j < areas[i].length - 1; j = j + 2) {
                if (    rightMouseButtonClick.getX() + -10 >= areas[i][j] ||
                        rightMouseButtonClick.getX() + -10 <= areas[i][j] &&
                        rightMouseButtonClick.getY() + -10 >= areas[i][j + 1] ||
                        rightMouseButtonClick.getY() + -10 <= areas[i][j + 1])
                {
                    ret = i;
                }
            }
        }
        return ret;
    }

    public void spawnWing(boolean buttonDown) {
        if (buttonDown) {
            Position mPos = InputHelper.getMPosDraw();
            for (int i = 0; i < limbs.length - 1; i++) {
                if (i == getLimb(mPos) && CREDITS > 500) {
                    limbs[i].addWing(this);
                    System.out.println("created a wing");
                    CREDITS -= 500;
                }
            }
        }
    }
}