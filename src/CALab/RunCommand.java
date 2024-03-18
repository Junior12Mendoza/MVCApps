package CALab;
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

    }
}
