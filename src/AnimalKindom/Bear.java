/*
Creating by Zelma Milev
*/
package AnimalKindom;

import java.awt.*;
import java.util.Random;

public class Bear extends Critter {
    private Boolean polar;
    private String sign = "/";
    Random random = new Random();

    public String toString() {
        return sign;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

//    public Bear(Boolean polar) {
//        this.polar = polar;
//    }

    public Bear() {
        this.polar = random.nextBoolean();
    }


    public Action getMove(CritterInfo info) {
        if (getSign().equals("/")) {
            setSign("\\");
        } else {
            setSign("/");
        }

        if ((info.getFront() == Neighbor.OTHER)&&info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront()==Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

    public Color getColor() {
        if (this.polar) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }

    }
    // This prevents critters from trying to redefine the definition of
    // object equality, which is important for the simulator to work properly.
    public final boolean equals(Critter other) {

        return other.toString().equals("/") || other.toString().equals("\\");
//        return this.toString().equals(other.toString());
    }
}


