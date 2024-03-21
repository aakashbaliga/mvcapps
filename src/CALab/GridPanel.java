package CALab;
import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class GridPanel extends AppPanel implements ActionListener {
    public GridPanel(AppFactory factory) {
        super(factory);
        JButton run1 = new JButton("RUN1");
        JButton run50 = new JButton("RUN50");
        JButton populate = new JButton("POPULATE");
        JButton clear = new JButton("CLEAR");

        run1.addActionListener(this);
        controlPanel.add(run1);
        run50.addActionListener(this);
        controlPanel.add(run50);

        clear.addActionListener(this);
        controlPanel.add(clear);
        populate.addActionListener(this);
        controlPanel.add(populate);

    }
}
