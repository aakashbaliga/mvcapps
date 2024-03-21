package life;
import CALab.*;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class LifeFactory extends GridFactory {
    @Override
    public Society makeModel() {
        return new Society();
    }

    @Override
    public View makeView(Model m) {
        return new GridView((Grid) m);
    }

    @Override
    public String[] getHelp() {
        return new String[]{
                "RUN1: Runs 1 cell",
                "RUN50: Runs 50 cells",
                "POPULATE: Randomly sets a value for each cell",
                "CLEAR: Resets each cell to dead."
        };
    }
}
