package CALab;
import mvc.*;

import javax.swing.*;
import java.io.*;

public abstract class GridFactory implements AppFactory {

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
        if ("RUN1".equals(type)) {
            return new RunCommand(model, 1);
        } else if ("RUN50".equals(type)) {
            return new RunCommand(model, 50);
        } else if ("POPULATE".equals(type)) {
            return new PopulateCommand(model);
        } else if ("CLEAR".equals(type)) {
            return new ClearCommand(model);
        } else {
            return null;
        }
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

    public View makeView(Model m) {
        return new GridView((Grid)m);
    }
}
