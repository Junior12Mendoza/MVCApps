package lifeLab;

import CALab.Cell;

import java.awt.*;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Agent extends Cell {
    private int status = 0;
    private int ambience = 8;
    private final int maxNeighbors = 8;
    public Agent(Society society, boolean uniform) {
        myGrid = society;

    }
    public void observe() {
        ambience = 0;
        Set<Cell> neighbors = myGrid.getNeighbors(this, 1);
        Iterator<Cell> iterator = neighbors.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getStatus() == 1) {
                ambience++;
            }
        }
    }

    public void interact() {
    }

    public void update() {
        if (ambience == 3) {
            status = 1;
        }
        else {
            status = 0;
        }
    }

    public void nextState() {
        status = (status + 1) % 2;
    }

    public void reset(boolean randomly) {
        if (randomly) {
            Random rand = new Random();
            status = rand.nextInt(2);
        }
        else {
            status = 0;
        }

    }

    @Override
    public Color getColor() {
        if (status == 0) {
            return Color.RED;
        }
        else if (status == 1) {
            return Color.GREEN;
        }
        return Color.GRAY;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
