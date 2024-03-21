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
        AppFactory factory = new LifeFactory();
        AppPanel panel = new LifePanel(factory);
        panel.display();
    }
}