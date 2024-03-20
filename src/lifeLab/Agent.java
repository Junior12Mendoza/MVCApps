package lifeLab;

import CALab.*;

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
        if (Society.rebirth.contains(ambience)) {
            status = 1;
        }
        else {
            status = 0;
        }
        notifyObservers();
    }

    public void nextState() {
        status = (status + 1) % 2;
        if (status == 0){
            color = Color.RED;
        }
        else{
            color = Color.GREEN;
        }
    }

    public void reset(boolean randomly) {
        if (randomly) {
            Random rand = new Random();
            status = rand.nextInt(2);
        }
        else {
            status = 0;
        }
        notifyObservers();
    }

    @Override
    public Color getColor() { return color; }

    @Override
    public int getStatus() {
        return ambience;
    }
}
