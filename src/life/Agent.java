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
        if (status == 0 && ambience == 3) {
            status = 1; // Cell becomes alive if it has exactly 3 neighbors
        } else if (status == 1 && (ambience < 2 || ambience > 3)) {
            status = 0; // Cell dies if it has fewer than 2 neighbors or more than 3 neighbors
        }
    }

    // Arav Panchmatia 
    @Override
    public void nextState() {
        status = (status == 1) ? 0 : 1;
    }

    // Anson Lau
    @Override
    public void reset(boolean randomly) {
        status = (randomly && Math.random() < 0.5) ? 1 : 0;
    }



    // Arav Panchmatia
    @Override
    public Color getColor() {
        return (status == 1) ? Color.GREEN : Color.RED;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
