package CALab;

import mvc.Command;
import mvc.Model;

// Anson Lau
public class PopulateCommand extends Command {

    public PopulateCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Grid grid = (Grid)myModel;
        grid.repopulate(true);
    }
}