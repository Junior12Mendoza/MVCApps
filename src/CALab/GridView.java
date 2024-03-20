package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView extends View {
    private CellView cellViews[][];

    public GridView(Model model) {
        super(model);
        int dim = ((Grid) model).dim;
        cellViews = new CellView[dim][dim];
        for (int i=0;i<dim;i++) {
            for (int j=0;j<dim;j++) {
                CellView cell = new CellView(((Grid) model).getCell(i, j));
                cellViews[i][j] = cell;
                setLayout(new GridLayout(dim, dim));
                this.add(cell);
            }
        }
    }

    public void update() {
        int dim = cellViews.length;
        for (int i=0;i<dim;i++) {
            for (int j=0;j<dim;j++) {
                cellViews[i][j].update();
            }
        }
    }

}
