package CALab;

import mvc.*;

public class RunCommand extends Command {

  Grid myGrid;
  int count;

  public RunCommand(Grid grid, int ct) {
    myGrid = grid;
    count = ct;
  }
  
  public void execute() {
    myGrid.updateLoop(count);
  }
}
