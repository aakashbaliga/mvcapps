// Arav Panchmatia
package CALab;

import mvc.*;

public class ClearCommand extends Command {
        Grid myGrid;
        public ClearCommand(Grid grid) {
            myGrid = grid;
        }

        public void execute() {
            myGrid.repopulate(false);
        }
}
