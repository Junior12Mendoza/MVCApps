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
        setLayout(new GridLayout(dim, dim));
        for (int i=0;i<dim;i++) {
            for (int j=0;j<dim;j++) {
                CellView cell = new CellView(((Grid) model).getCell(i, j));
                cellViews[i][j] = cell;
                this.add(cell);
            }
        }
        setLayout(new GridLayout(dim, dim));
    }

    public void update() {
        int dim = cellViews.length;
        for (int i=0;i<dim;i++) {
            for (int j=0;j<dim;j++) {
                cellViews[i][j].update();
            }
        }
    }

    @Override
    public void setModel(Model newModel) {
        model.unsubscribe(this);
        model = newModel;
        model.subscribe(this);

        Grid g = (Grid)model;
        int dim = cellViews.length;
        // Set each of the cellViews
        for (int i=0;i<dim;i++) {
            for (int j=0;j<dim;j++) {
                cellViews[i][j].setCell(g.cells[i][j]);
            }
        }
        repaint();
    }
}
