package life;
import CALab.*;
import mvc.*;

public class LifePanel extends GridPanel {
    public LifePanel(AppFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        GridFactory f = new LifeFactory();
        GridPanel p = new GridPanel(f);
        p.show();
    }
}
