package CALab;
import mvc.*;

import javax.swing.*;
import java.io.*;

public abstract class GridFactory implements AppFactory {
    @Override
    public abstract Grid makeModel();


    public GridView makeView(Grid g) {
        return new GridView(g);
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{
                "RUN1",
                "RUN50",
                "POPULATE",
                "CLEAR"
        };
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        return switch (type) {
            case "RUN1" -> new RunCommand((Grid) model, 1);
            case "RUN50" -> new RunCommand((Grid) model, 50);
            case "POPULATE" -> new PopulateCommand(model);
            case "CLEAR" -> new ClearCommand((Grid) model);
            default -> null;
        };

    }

    @Override
    public String getTitle() {
        return "CALab";
    }

    @Override
    public abstract String[] getHelp();

    @Override
    public String about() {
        return "CALab. Aakash Baliga, Anson Lau, Arav Panchmatia, 2024";
    }
}
