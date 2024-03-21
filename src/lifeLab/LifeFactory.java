package lifeLab;

import CALab.*;
import mvc.*;

public class LifeFactory extends GridFactory {
    public Model makeModel() {
        return new Society();
    }

    // source added 3/15 to support text fields
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type.equalsIgnoreCase("Run1") || type.equalsIgnoreCase("Run50")) {
            return new RunCommand(model, type);
        }
        else if (type.equalsIgnoreCase("Populate")) {
            return new PopulateCommand(model);
        }
        else if (type.equalsIgnoreCase("Clear")) {
            return new ClearCommand(model);
        }
        return null;
    }
}
