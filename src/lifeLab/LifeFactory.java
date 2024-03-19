package lifeLab;

import CALab.ClearCommand;
import CALab.GridFactory;
import CALab.PopulateCommand;
import CALab.RunCommand;
import mvc.Command;
import mvc.Model;
import mvc.View;
import stopLight.ChangeCommand;
import stopLight.Stoplight;
import stopLight.StoplightView;

public class LifeFactory extends GridFactory {
    public Model makeModel() {
        return new Society();
    }

    public View makeView(Model m) {
        return new LifeView((Society) m);
    }

    // source added 3/15 to support text fields
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "Run1" || type == "Run50") {
            return new RunCommand(model, type);
        }
        else if (type == "Populate") {
            return new PopulateCommand(model);
        }
        else if (type == "Clear") {
            return new ClearCommand(model);
        }

        return null;
    }


}
