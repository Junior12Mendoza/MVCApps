package CALab;

import java.awt.*;
import javax.swing.*;

import mvc.*;

public class GridPanel extends AppPanel {
    private JButton run1;
    private JButton run50;
    private JButton populate;
    private JButton clear;
    public GridPanel(AppFactory factory) {
        super(factory);
        run1 = new JButton("RUN1");
        run1.addActionListener(this);
        controlPanel.add(run1);

        run50 = new JButton("RUN50");
        run50.addActionListener(this);
        controlPanel.add(run50);

        populate = new JButton("POPULATE");
        populate.addActionListener(this);
        controlPanel.add(populate);

        clear = new JButton("CLEAR");
        clear.addActionListener(this);
        controlPanel.add(clear);
    }
}
