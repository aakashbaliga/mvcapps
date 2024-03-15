package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) { return cells[row][col]; }
    public abstract Cell makeCell(boolean uniform);


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() { this(20); }

    // Anson Lau
    protected void populate() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col] = makeCell(true); // Use makeCell to fill in cells
            }
        }
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cells[row][col].setNeighbors(getNeighbors(cells[row][col], 1));
                // Use getNeighbors to set the neighbors field of each cell
            }
        }
    }

    // Anson Lau
    // called when Populate button is clicked
    public void repopulate(boolean randomly) {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                if (randomly) {
                    cells[row][col].setStatus(Math.random() < 0.5 ? 0 : 1); // Randomly set the status of each cell
                } else {
                    cells[row][col].setStatus(0); // Set the status of each cell to 0 (dead)
                }
            }
        }
        notifySubscribers(); // notify subscribers
    }

    // Anson Lau
    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */

        Set<Cell> neighbors = new HashSet<>();

        for (int row = Math.max(0, asker.getRow() - radius); row <= Math.min(dim - 1, asker.getRow() + radius); row++) {
            for (int col = Math.max(0, asker.getCol() - radius); col <= Math.min(dim - 1, asker.getCol() + radius); col++) {
                if (!(row == asker.getRow() && col == asker.getCol())) {
                    neighbors.add(cells[row][col]);
                }
            }
        }
        return neighbors;
    }

    // overide these
    public int getStatus() { return 0; }
    public Color getColor() { return Color.GREEN; }

    // cell phases:

    public void observe() {
        // call each cell's observe method and notify subscribers
    }

    public void interact() {
        // ???
    }

    public void update() {
        // ???
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}