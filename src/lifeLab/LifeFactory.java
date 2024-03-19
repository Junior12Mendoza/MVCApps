package lifeLab;

import CALab.*;
import mvc.*;

public class LifeFactory extends GridFactory {
    public Model makeModel() {
        return new Society();
    }

    public View makeView(Model m) {
        return new GridView((Society) m);
    }

    // source added 3/15 to support text fields
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type.equals("Run1") || type.equals("Run50")) {
            return new RunCommand(model, type);
        }
        else if (type.equals("Populate")) {
            return new PopulateCommand(model);
        }
        else if (type.equals("Clear")) {
            return new ClearCommand(model);
        }

        return null;
    }
}
