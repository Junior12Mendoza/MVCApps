package CALab;

import mvc.*;

public abstract class GridFactory implements AppFactory {
    public abstract Model makeModel();

    public View makeView(Model m) {
        return new GridView(m);
    }

    public String[] getEditCommands() {
        return new String[]{"Run1","Run50","Populate","Clear"};
    }


    public String getTitle() {
        return "Life Lab Simulator";
    }

    public String[] getHelp() {
        return new String[]{"Click Run1 to run 1 cycle",
                "Click Run50 to run the next 50 cycles",
                "Click Populate to repopulate the grid",
                "Click Clear to reset the grid"
        };
    }

    public String about() {
        return "Life Lab version 1.0. Copyright 2020 by Cyberdellic Designs";
    }
}
