package mvc;

public interface AppFactory {
    public String getTitle();

    public Model makeModel();

    public String about();

    public String[] getHelp();

    public String[] getEditCommands();
}
