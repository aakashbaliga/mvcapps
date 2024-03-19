package CALab;
import mvc.*;

import javax.swing.*;
import java.io.*;

public abstract class GridFactory implements AppFactory {
    @Override
    public abstract Grid makeModel();

    @Override
    public View makeView(Model m) {
        return new GridView(m);
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
            switch (type) {
                case "RUN1": {
                    return new RunCommand((Grid)model, 1);
                }
                case "RUN50": {
                    return new RunCommand((Grid)model, 50);
                }
                case "POPULATE": {
                    return new PopulateCommand(model);
                }
                case "CLEAR": {
                    return new ClearCommand((Grid)model);
                }

            }
            return null;

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
