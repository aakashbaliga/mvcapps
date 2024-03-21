package CALab;
import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Anson Lau
public class GridPanel extends AppPanel implements ActionListener {
    private JButton run1;
    private JButton run50;
    private JButton populate;
    private JButton clear;
    public GridPanel(AppFactory factory) {
        super(factory);
        run1 = new JButton("RUN1");
        run1.addActionListener(this);
        controlPanel.add(run1);

        run50 = new JButton("RUN50");
        run50.addActionListener(this);
        controlPanel.add(run50);

        clear = new JButton("CLEAR");
        clear.addActionListener(this);
        controlPanel.add(clear);

        populate = new JButton("POPULATE");
        populate.addActionListener(this);
        controlPanel.add(populate);
    }
}
