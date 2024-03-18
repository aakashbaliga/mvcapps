// Arav Panchmatia
package mvc;

import CALab.Grid;

public abstract class Command {

    Model myModel;
    public Command(Model model) {
        myModel = model;
    }

    protected Command() {
    }

    public void execute() {

    }
}
