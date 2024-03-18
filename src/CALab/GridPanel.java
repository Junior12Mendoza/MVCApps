package CALab;

import java.awt.*;
import javax.swing.*;

import mvc.*;


public class GridPanel extends AppPanel {
    private JButton run;
    private JButton run50;
    private JButton populate;
    private JButton clear;
    public GridPanel(AppFactory factory) {
        super(factory);
        run = new JButton("Run1");
        run.addActionListener(this);
        controlPanel.add(run);
        run50 = new JButton("Run50");
        run50.addActionListener(this);
        controlPanel.add(run50);
        populate = new JButton("Populate");
        populate.addActionListener(this);
        controlPanel.add(populate);
        clear = new JButton("Clear");
        clear.addActionListener(this);
        controlPanel.add(clear);
    }

    public static void main(String[] args) {
        AppFactory factory = new GridFactory();
        AppPanel panel = new GridPanel(factory);
        panel.display();
    }

}
