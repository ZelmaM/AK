/*
Creating by Zelma Milev
*/
package AnimalKindom;

import java.awt.*;

public class NinjaCat extends Critter {
    private int num = 0;
    private Color color;
    private Action action;

    public NinjaCat() {
    }

    //  🐱
    public String toString() {
        return (num % 2 == 0) ? "\uD83D\uDC31" : "♣";
    }

    public Action getMove(CritterInfo info) {
        this.num++;

//        if (info.getFront() == Neighbor.OTHER) {
        if ((info.getFront() == Neighbor.OTHER) && info.frontThreat()) {
            this.action = Action.INFECT;

        } else if (info.getFront() == Neighbor.OTHER) {
            if ((info.getLeft() == Neighbor.OTHER)|| (info.getRight() == Neighbor.OTHER)){
                this.action = Action.INFECT;
            } else
                this.action = Action.LEFT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            this.action = Action.HOP;
        } else if ((info.getFront() == Neighbor.WALL)
                || (info.getRight() == Neighbor.WALL)) {
            this.action = Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            this.action = Action.RIGHT;
        } else {
            this.action = Action.LEFT;
        }
        return action;
    }

    public Color getColor() {
        setColor();
        return this.color;

    }

    private void setColor() {
        if (this.num == 0) {
            this.color = Color.PINK;

        } else
            switch (action) {
                case HOP:
                    this.color = Color.ORANGE;
                    break;
                case LEFT:
                    this.color = Color.BLUE;
                    break;
                case RIGHT:
                    this.color = Color.MAGENTA;
                    break;
                case INFECT:
                    this.color = Color.YELLOW;
                    break;
            }
    }

    // This prevents critters from trying to redefine the definition of
    // object equality, which is important for the simulator to work properly.
    public final boolean equals(Critter other) {
        return other.toString().equals("\uD83D\uDC31") || other.toString().equals("♣");
    }
}
