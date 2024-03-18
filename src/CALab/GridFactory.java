package CALab;
import mvc.*;

public class GridFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return new Model();
    }

    @Override
    public GridView makeView(Model m) {
        return new GridView(m);
    }

    @Override
    public String[] getEditCommands() {
        return new String[0];
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String[] getHelp() {
        return new String[0];
    }

    @Override
    public String about() {
        return null;
    }
}
