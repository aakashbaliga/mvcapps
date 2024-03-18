package life;
import CALab.*;

import java.awt.*;

public class Agent extends Cell {
    int status = 0;
    int ambience = 8;

    // Anson Lau
    @Override
    public void observe() {
        ambience = 0; // Reset ambience count
        for (Cell neighbor : neighbors) {
            if (neighbor.getStatus() == 1) {
                ambience++;
            }
        }
        setStatus(status); // Update status based on ambience
    }

    @Override
    public void interact() {

    }

    @Override
    public void update() {

    }

    @Override
    public void nextState() {

    }

    // Anson Lau
    @Override
    public void reset(boolean randomly) {
        if (randomly) {
            status = Math.random() < 0.5 ? 0 : 1; // Randomly assign status
        } else {
            status = 0; // Clear the cell by default
        }
        ambience = 0; // Reset ambience count
    }

    @Override
    public void setStatus(int status) {

    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
