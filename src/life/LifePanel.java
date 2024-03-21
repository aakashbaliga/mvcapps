package life;
import CALab.*;
import mvc.*;

import javax.swing.*;
import java.awt.event.*;

public class LifePanel extends GridPanel {

    public LifePanel(LifeFactory factory) {
        super(factory);

        Society society = new Society();
        view = new GridView(society);
        add(view);

        JButton run1 = new JButton("RUN1");
        JButton run50 = new JButton("RUN50");
        JButton populate = new JButton("POPULATE");
        JButton clear = new JButton("CLEAR");

        run1.setBounds(250, 50, 100, 40);
        run50.setBounds(250, 200, 100, 40);
        populate.setBounds(250, 350, 100, 40);
        clear.setBounds(250, 500, 100, 40);

        run1.addActionListener(this);
        run50.addActionListener(this);
        populate.addActionListener(this);
        clear.addActionListener(this);

        add(run1);
        add(run50);
        add(populate);
        add(clear);
    }

    public static void main(String[] args) {
        LifeFactory f = new LifeFactory();
        LifePanel p = new LifePanel(f);
        p.display();
    }
}
