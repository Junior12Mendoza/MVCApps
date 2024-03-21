package lifeLab;

import CALab.*;

import java.awt.*;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Agent extends Cell {
    private int status = 0;
    private int ambience = 0;
    private final int maxNeighbors = 8;
    public Agent(Society society, boolean uniform) {
        myGrid = society;
        this.neighbors = myGrid.getNeighbors(this, 1);
    }
    public void observe() {
        int temp = 0;
        Set<Cell> neighbors = myGrid.getNeighbors(this, 1);
        Iterator<Cell> iterator = neighbors.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getColor().equals(Color.GREEN)) {
                temp++;
            }
        }
        ambience = temp % 9;
    }

    public void interact() {
    }

    public void update() {
        if (status == 0 && Society.rebirth.contains(ambience)) {
            status = 1;
        } else if (status == 1 && Society.death.contains(ambience)) {
            status = 0;
        }
        notifyObservers();
    }

    public void nextState() {
        status = (status + 1) % 2;
        notifyObservers();
        myGrid.changed();
    }

    public void reset(boolean randomly) {
        if (randomly) {
            Random rand = new Random();
            status = rand.nextInt(2);
        }
        else {
            status = 0;
            ambience = 0;
        }
        notifyObservers();
        myGrid.changed();
    }

    @Override
    public Color getColor() {
        if (status == 0){
            return Color.RED;
        }
        else if (status == 1){
            return Color.GREEN;
        }
        else{
            return Color.BLUE;
        }
    }

    @Override
    public int getStatus() {
        return status;
    }
}