package life;
import CALab.*;
import mvc.*;

import javax.swing.*;
import java.awt.event.*;

public class LifePanel extends GridPanel {
    public LifePanel(AppFactory factory) {
        super(factory);
    }



    public static void main(String[] args) {
        AppFactory f = new LifeFactory();
        AppPanel p = new LifePanel(f);
        p.display();
    }
}
