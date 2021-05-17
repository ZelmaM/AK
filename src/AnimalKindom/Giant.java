/*
Creating by Zelma Milev
*/
package AnimalKindom;

import java.awt.*;

public class Giant extends Critter {
    String[] nameToString = {"fee","fie","foe","fum"};
    int num = 0;

    public String toString() {
        return nameToString[num/6];
    }

    public Action getMove(CritterInfo info) {
        num = (num+1) % 24;
        if ((info.getFront() == Neighbor.OTHER)&&info.frontThreat()){
            return Action.INFECT;
        } else if (info.getFront()==Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    public Color getColor() {
        return Color.GRAY;
    }

    // This prevents critters from trying to redefine the definition of
    // object equality, which is important for the simulator to work properly.
    public final boolean equals(Critter other) {
        for (int i = 0; i < nameToString.length; i++) {
            if (other.toString().equals(nameToString[i])) {
                return true;
            }
        }


        return false;
    }
}


