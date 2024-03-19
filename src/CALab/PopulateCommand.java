package CALab;
import mvc.*;
public class PopulateCommand extends Command{
    public PopulateCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Grid grid = (Grid) model;
        System.out.println("populate command");
        grid.repopulate(true);
    }
}
