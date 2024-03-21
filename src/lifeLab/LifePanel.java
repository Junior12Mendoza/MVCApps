package lifeLab;

import CALab.GridFactory;
import CALab.GridPanel;
import mvc.AppFactory;

public class LifePanel extends GridPanel {
    public LifePanel(AppFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        GridFactory factory = new LifeFactory();
        GridPanel panel = new LifePanel(factory);
        panel.display();
    }




}
