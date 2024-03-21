// Arav Panchmatia
package mvc;

import CALab.Grid;

public abstract class Command {
    public Model myModel;

    public Command(Model model) {
        myModel = model;
    }

    public abstract void execute();
}
