package CALab;
import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class GridPanel extends AppPanel implements ActionListener {

    public GridPanel(AppFactory factory) {
        super(factory);
        view = new GridView(model);
    }
}
