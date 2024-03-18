package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView  extends View {
    private CellView cellViews[][];

    public GridView(Model model) {
        super(model);
        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col)
        cellViews[row][col] = cell
        set cell.row and cell.col here
        */
        int dim = ((Grid) model).dim;
        cellViews = new CellView[dim][dim];
        for (int i=0;i<dim;i++) {
            for (int j=0;j<dim;j++) {
                CellView cell = new CellView(((Grid) model).getCell(i, j));
                cellViews[i][j] = cell;
            }
        }
    }

    public void update() {
        // call update method of each CellView
        int dim = cellViews.length;
        for (int i=0;i<dim;i++) {
            for (int j=0;j<dim;j++) {
                cellViews[i][j].update();
            }
        }
    }

}
