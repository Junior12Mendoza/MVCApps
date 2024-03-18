package CALab;

import mvc.*;

public class GridFactory implements AppFactory{
    public Model makeModel() { // Todo: Grid is abstract what do we put here?
        return new Model();
    }
    public View makeView(Model m) {
        return new GridView((Grid) m);
    }

    public String[] getEditCommands() {
        return new String[]{"Run", "Populate", "Clear"};
    }

    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "Run1")
            return new RunCommand(model);
        if (type == "Run50") // Todo: Handle the case where we need to run 50 times
            return new RunCommand(model);
        if (type == "Populate")
            return new PopulateCommand(model);
        if (type == "Clear")
            return new ClearCommand(model);
        return null;
    }

    public String getTitle() {
        return "Cellular Automata Simulator";
    }

    public String[] getHelp() {
        return new String[]{"Click Run1 to run 1 time", "Click Run50 to run 50 times", "Click Populate to randomize the state of all cells in the grid", "Click Clear to clear the grid"};
    }

    public String about() {
        return "CA version 1.0. Copyright 2024 by us";
    }
}
