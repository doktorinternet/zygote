package zygoteParts;

import environment.Position;
import org.newdawn.slick.geom.Circle;

public class Wing extends CircleNode implements Light, Constants {
    private CircleNode parent;
    CircleNode olderSibling;
    CircleNode youngerSibling;
    private Bone backBone;

    public Wing(CircleNode parent, Bone limb) {
//        setRhythm(parent.getRhythm());
        setMinSize(75 / 2); // TODO create variable
        setMaxSize(getMinSize()*GROWTH);

        backBone = limb;
        setParent(parent);
        setPosition(new Position(backBone.getHusk().getCenterY(),
                backBone.getHusk().getCenterX()));
        setShape(new Circle(getPosition().getX(), getPosition().getY(), getMinSize()));
    }

    /*public void setParent(CircleNode parent) {
        this.parent = parent;
        if(parent.equals(core)){
            setBack(core.getLimbs());
        }
    }*/

    void setOlderSibling() {
    }

    void setYoungerSibling() {
    }

    public void setParent(CircleNode parent) {
        this.parent = parent;
    }


//    private boolean setBack(Bone[] limbs, int limb) {
//        for(int i = 0; i < limbs.length-1; i++){
//            if(i == limb){
//                this.backBone = limbs[i];
//                return true;
//            }
//        }
//        return false;
//    }

}
