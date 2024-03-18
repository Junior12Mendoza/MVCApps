package CALab;
import lifeLab.Society;
import mvc.*;
public class RunCommand extends Command{
    protected String type;
    public RunCommand(Model model) {
        super(model);
    }
    public RunCommand(Model model, String type) {
        this(model);
        this.type = type;
    }

    @Override
    public void execute() {
        Grid grid = (Grid) model;
        if (this.type == "Run1") {
            grid.updateLoop(1);
        }
        else if (this.type == "Run50") {
            grid.updateLoop(50);
        }
    }
}
