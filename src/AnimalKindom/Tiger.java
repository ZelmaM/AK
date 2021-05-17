/*
Creating by Zelma Milev
*/
package AnimalKindom;

import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {
    private int num = 0;
    private Color color;
    Random random = new Random();

    public Tiger() {
    }

    public String toString() {
        return "TGR";
    }

    public Action getMove(CritterInfo info) {
        this.num++;

        if ((info.getFront() == Neighbor.OTHER)&&info.frontThreat()) {
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
        setColor();
        return this.color;

    }
    private void setColor() {
        if (this.num==0) {
            this.color = getRandColor();
        } else if (this.num % 3 == 0) {
            Color c = getRandColor();
            while (this.color == c) {
                c = getRandColor();
            } this.color = c;
            }
    }

    private Color getRandColor() {
        switch (random.nextInt(3)) {
            case 1:
                return Color.RED;
            case 2:
                return Color.GREEN;
            default:
                return Color.BLUE;
        }
    }

    // This prevents critters from trying to redefine the definition of
    // object equality, which is important for the simulator to work properly.
    public final boolean equals(Critter other) {
        return this.toString().equals(other.toString());
    }
}
