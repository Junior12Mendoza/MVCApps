package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

public abstract class Cell extends Publisher implements Serializable {
    // Position of the cell in grid
    protected int row = 0, col = 0;
    protected Set<Cell> neighbors = new HashSet<Cell>();
    protected Grid myGrid = null;
    protected Cell partner = null;

    protected Color color = Color.GRAY;

    // choose a random neighbor as a partner
    public void choosePartner() {
        /*
			Set partner to null
			Convert neighbors set to a local array
			Starting at a random position in the array search for a neighbor without a partner
			Make the first such neighbor (if any) the partner and set its partner field to this
        */
        if (partner == null && neighbors != null) {
            int startingPosition = Utilities.rng.nextInt(neighbors.size() - 1);
            Cell[] neighborArray = new Cell[neighbors.size()];
            int i = 0;

            for(Cell c : neighbors){
                neighborArray[i] = c;
                i++;
            }
            for(i = 0; i < neighborArray.length; i++){
                Cell neighborCell = neighborArray[(i + startingPosition) % neighborArray.length];
                if(neighborCell.partner == null){
                    neighborCell.partner = this;
                    partner = neighborCell;
                    break;
                }
            }
        }
    }

    public void unpartner() {
        if (partner != null) {
            if (partner.partner != null) {
                partner.partner = null;
            }
            partner = null;
        }
    }

    // observer neighbors' states
    public abstract void observe();
    // interact with a random neighbor
    public abstract void interact();
    // update my state
    public abstract void update();
    // set status to status + 1 mod whatever
    public abstract void nextState();
    // set status to a random or initial value
    public abstract void reset(boolean randomly);

    public abstract Color getColor();

    public abstract int getStatus();
}
