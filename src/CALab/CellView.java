package CALab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mvc.*;


public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) {
            c.subscribe(this);
        }
        this.addActionListener(this);
        update();
    }

    public Cell getMyCell() { return myCell; }

    public Color getColor() {
        if (myCell.getStatus() == 1) {
            return Color.GREEN;
        }
        else {
            return Color.RED;
        }
    }

    public CellView() { this(null); }

    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState();
        update(); // Arav Panchmatia
    }

    // called by notifySubscribers and GridView.update



    public void update() {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setText("" + myCell.getAmbience());
    }
}
