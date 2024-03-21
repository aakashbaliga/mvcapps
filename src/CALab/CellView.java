package CALab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mvc.*;


public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
        setPreferredSize(new Dimension(50, 50));
        update();
    }

    public Cell getMyCell() { return myCell; }

    public CellView() { this(null); }

    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState();
        update(); // Arav Panchmatia
    }

    // called by notifySubscribers and GridView.update



    public void update(String msg, Object oldState, Object newState) {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setText("" + myCell.getStatus());
    }

    @Override
    public void update() {

    }
}
