package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;

import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) { return cells[row][col]; }
    public abstract Cell makeCell(boolean uniform);

    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() { this(20); }

    protected void populate() {
        for (int i=0;i<dim;i++) {
            for (int j=0;j<dim;j++) {
                Cell cell = makeCell(false);
                cells[i][j] = cell;
                cells[i][j].row = i;
                cells[i][j].col = j;
            }
        }

        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                cells[i][j].neighbors = this.getNeighbors(cells[i][j], 1);
            }
        }
        notifyObservers();
    }

    // called when Populate button is clicked
    public void repopulate(boolean randomly) {
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                cells[i][j].reset(randomly);
            }
        }
        notifyObservers();
    }

    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */

        Set<Cell> neighbors = new HashSet<Cell>();
        int currRow = (asker.row - radius + dim) % dim;
        int startCol = (asker.col - radius + dim) % dim;
        int currCol = startCol;

        while(currRow != (asker.row + radius + 1) % dim){
            while(currCol != (asker.col + radius + 1) % dim){
                if(currRow != asker.row || currCol != asker.col)
                    neighbors.add(cells[currRow][currCol]);
                currCol = (currCol + 1) % dim;
            }
            currCol = startCol;
            currRow = (currRow + 1) % dim;
        }
        return neighbors;
    }

    public void observe() {
        // call each cell's observe method and notify subscribers
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                cells[i][j].observe();
            }
        }
    }

    public void interact() {
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                cells[i][j].interact();
            }
        }
        notifyObservers();
    }

    public void update() {
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                cells[i][j].update();
            }
        }
        notifyObservers();
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}