package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

public abstract class Cell extends Publisher implements Serializable {

    protected int row = 0, col = 0;
    protected Set<Cell> neighbors = new HashSet<Cell>();
    protected Grid myGrid = null;
    protected Cell partner = null;

    protected Color color = null;

    protected String status = null;


    // choose a random neighbor as a partner
    public void choosePartner() {
        if (partner == null && neighbors != null) {
            Cell[] localNeighbors = new Cell[neighbors.size()];
            localNeighbors = neighbors.toArray(localNeighbors);
            boolean picked = false;
            while (!picked) {
                Random rand = new Random();
                int random = rand.nextInt(localNeighbors.length);
                if (localNeighbors[random].partner == null) {
                    this.partner = localNeighbors[random];
                    this.partner.partner = this;
                    picked = true;
                }

            }
			/*
			Set partner to null
			Convert neighbors set to a local array
			Starting at a random position in the array search for a neighbor without a partner
			Make the first such neighbor (if any) the partner and set its partner field to this
			*/
        }

    }

    public void unpartner() {
        if (partner != null) {
            if (partner.partner != null) {
                partner.partner = null;
            }
            partner = null;
        }
    }

    // Anson Lau
    // Set neighbors of the cell
    public void setNeighbors(Set<Cell> neighbors) {
        this.neighbors = neighbors;
    }

    // Get the row of the cell
    public int getRow() {
        return row;
    }

    // Get the column of the cell
    public int getCol() {
        return col;
    }

    // observer neighbors' states
    public abstract void observe();
    // interact with a random neighbor
    public abstract void interact();
    // update my state
    public abstract void update();
    // set status to status + 1 mod whatever
    public abstract void nextState();
    // set status to a random or initial value
    public abstract void reset(boolean randomly);
    public abstract Color getColor();
    public abstract int getStatus();
    public abstract int getAmbience();
}