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
    }

    @Override
    public void interact() {

    }

    // Arav Panchmatia
    @Override
    public void update() {
        if (status == 0) {
            if (ambience == 2 || ambience == 3) {
                status = 1;
            }
            else {
                status = 0;
            }
        }
        else {
            if (ambience < 2 || ambience > 3) {
                status = 0;
            }
            else {
                status = 1;
            }
        }
    }

    // Arav Panchmatia 
    @Override
    public void nextState() {
        if (status == 0) {
            if (ambience == 3) {
                status = 1; // Dead cell comes back to life if it has 3 living neighbors
            }
        }
        else {
            if (ambience < 2 || ambience > 3) {
                status = 0; // Living cell dies if it has too few or too many living neighbors
            }
        }
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

    // Arav Panchmatia
    @Override
    public void setStatus(int status) {
        if (status == 0 || status == 1) {
            this.status = status;
        }
        else {
            throw new IllegalArgumentException("Status must be 0 (dead) or 1 (alive)");
        }
    }

    // Arav Panchmatia
    @Override
    public Color getColor() {
        if (status == 1) {
            return Color.GREEN; // Alive
        }
        else {
            return Color.RED; // Dead
        }
    }

    @Override
    public int getStatus() {
        return ambience;
    }
}
