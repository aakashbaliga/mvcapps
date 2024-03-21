package CALab;

import mvc.*;

public class RunCommand extends Command {

  Grid myGrid;
  int count;

  public RunCommand(Model model, int ct) {
    super(model);

    count = ct;
  }
  
  public void execute() {
    myGrid = (Grid)myModel;
    myGrid.updateLoop(count);
  }
}
