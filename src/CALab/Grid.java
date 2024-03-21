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
    public void setCells(int row, int col, Cell val){
        cells[row][col] = val;
    }
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
                Cell cell = makeCell(true);
                cell.row = row;
                cell.col = col;
                cells[row][col] = cell;
            }
        }

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.neighbors = getNeighbors(cell, 1);
            }
        }
    }

    // Anson Lau
    // called when Populate button is clicked
    public void repopulate(boolean randomly) {
        for(int i = 0; i< cells.length; i++){
            for(int j=0; j < cells[i].length; j++){
                cells[i][j].reset(randomly); // Reset cell status based on randomly parameter
            }
        }
        observe();
        notifySubscribers(); // notify subscribers
        time = 0;
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

        int currRow = (asker.row - radius + dim) % dim;
        int startCol = (asker.col - radius + dim) % dim;
        int currCol = startCol;

        while (currRow != (asker.row + radius + 1) % dim) {
            while (currCol != (asker.col + radius + 1) % dim) {
                if (currRow != asker.row || currCol != asker.col) {
                    neighbors.add(cells[currRow][currCol]);
                }
                currCol = (currCol + 1) % dim;
            }
            currCol = startCol;
            currRow = (currRow + 1) % dim;
        }

        return neighbors;
    }

    // overide these
    public int getStatus() { return 0; }
    public Color getColor() { return Color.GREEN; }

    // cell phases:

    public void observe() {
        //Aakash Baliga
        // call each cell's observe method and notify subscribers
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                (getCell(row,col)).observe();
            }
        }
        notifySubscribers();
    }

    public void interact() {
        //Aakash Baliga
        // Calls interact method for each cell
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                (getCell(row,col)).interact();
            }
        }
        notifySubscribers();
    }

    public void update() {
        //Aakash Baliga
        //Calls update method for each cell
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                (getCell(row,col)).update();
            }
        }
        notifySubscribers();
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
            notifySubscribers();
        }
    }


}
