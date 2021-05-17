/*
Creating by Zelma Milev
*/
package AnimalKindom;

import java.awt.*;

public class WhiteTiger extends Critter {
    private int num = 0;

    public WhiteTiger() {
    }

    public String toString() {
        if (this.num == 0) {
            return "trg";
        }
        return "TGR";
    }

    public Action getMove(CritterInfo info) {

        if ((info.getFront() == Neighbor.OTHER)&&info.frontThreat()){
            this.num++;
            return Action.INFECT;
        } else if ((info.getFront() == Neighbor.WALL)
                || (info.getRight() == Neighbor.WALL)) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    public Color getColor() {
        return Color.WHITE;

    }

    // This prevents critters from trying to redefine the definition of
    // object equality, which is important for the simulator to work properly.
    public final boolean equals(Critter other) {
        return this.toString().equalsIgnoreCase(other.toString())
                && this.getColor().equals(other.getColor());
    }
}

