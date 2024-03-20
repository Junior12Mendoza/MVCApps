package lifeLab;

import CALab.Cell;

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
        System.out.println("ambience of " + this.row + " " + this.col + " is: " + ambience);
        ambience = temp % 9;
        //update();
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
        //changeColor();
        notifyObservers();
    }

    public void changeColor() {
        if (status == 0){
            color = Color.RED;
        }
        else{
            color = Color.GREEN;
        }
    }

    public void nextState() {
        //if (getColor()) {

        //}
        status = (status + 1) % 2;
        //changeColor();
        //this.observe();
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
        return ambience;
    }
}
