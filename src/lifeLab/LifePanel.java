package lifeLab;

import CALab.GridFactory;
import CALab.GridPanel;
import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;

public class LifePanel extends GridPanel {
    public LifePanel(AppFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        GridFactory factory = new LifeFactory();
        GridPanel panel = new GridPanel(factory);
        panel.display();
    }




}
