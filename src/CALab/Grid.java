package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;

import lifeLab.Agent;
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
                cell.row = i;
                cell.col = j;
            }
        }

        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                cells[i][j].neighbors = this.getNeighbors(cells[i][j], 1);
            }
        }
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

    /*
    return the set of all cells that can be reached from the asker in radius steps.
    If radius = 1 this is just the 8 cells touching the asker.
    Tricky part: cells in row/col 0 or dim - 1.
    The asker is not a neighbor of itself.
    */
    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */
        /*
        Set<Cell> neighbors = asker.neighbors;
        Queue<Cell> q = new LinkedList<>();
        q.offer(asker);
        while (!q.isEmpty()) {
            Cell current = q.poll();
            Set<Cell> nextNeighbors = current.neighbors;
            Iterator<Cell> neighborsIterator = nextNeighbors.iterator();
            while (neighborsIterator.hasNext()) {
                Cell neighbor = neighborsIterator.next();
                if (neighbor != asker && !neighbors.contains(neighbor)) {
                    neighbors.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }
        return neighbors;*/

        Set<Cell> neighbors = new HashSet<Cell>();
        int currRow = (asker.row - radius) % dim;
        int startCol = (asker.col - radius) % dim;
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
        return null;

        /*
        Set<Cell> neighbors = new HashSet<>();
        Set<Cell> nextNeighbors = asker.neighbors;
        Set<Cell> temp = new HashSet<>();
        int i = 0;
        while (i < radius) {
            Iterator<Cell> nextIterator = nextNeighbors.iterator();
            temp = new HashSet<>();
            while (nextIterator.hasNext()) {
                Cell neighbor = nextIterator.next();
                addNeighbors(neighbor, neighbors, temp);
            }
            nextNeighbors = temp;
            i++;
        }
        return neighbors;
        */
    }
    /*
    private void addNeighbors(Cell asker, Set<Cell> neighbors, Set<Cell> temp) {
        Set<Cell> askerNeighbors = asker.neighbors;
        Iterator<Cell> cellsIterator = askerNeighbors.iterator();
        while (cellsIterator.hasNext()) {
            Cell cur = cellsIterator.next();
            if (!neighbors.contains(cur)) {
                neighbors.add(cur);
                temp.add(cur);
            }
        }
    }*/

    public void observe() {
        // call each cell's observe method and notify subscribers
        // Starting Junior's part
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                cells[i][j].observe();
            }
        }
        notifyObservers();
    }

    public void interact() {
        // Starting Junior's part
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                cells[i][j].interact();
            }
        }
        notifyObservers();
    }

    public void update() {
        // Starting Junior's part
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                cells[i][j].update();
            }
        }
        notifyObservers(); // Ending Junior's part
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