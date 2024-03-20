package CALab;

import life.*;
import mvc.*;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Create an instance of your factory
        AppFactory factory = new LifeFactory();

        // Create an instance of your AppPanel
        AppPanel appPanel = new LifePanel(factory);

        // Create a JFrame and add the AppPanel to it
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(appPanel);
        frame.setTitle(factory.getTitle());
        frame.setSize(AppPanel.FRAME_WIDTH, AppPanel.FRAME_HEIGHT);

        // Display the JFrame
        frame.setVisible(true);

        // Optionally, you can call display() method to make the AppPanel visible
        // appPanel.display();
    }
}