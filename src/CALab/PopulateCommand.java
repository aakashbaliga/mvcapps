package CALab;

import mvc.Command;
import mvc.Model;

public class PopulateCommand extends Command {

    public PopulateCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        if (model instanceof Grid) {
            Grid grid = (Grid) model;
            grid.repopulate(true); // Repopulate the grid with random values
        }
    }
}