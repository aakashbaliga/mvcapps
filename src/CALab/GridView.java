package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridView  extends View {

    private CellView cellViews[][];

    public GridView(Model model) {
        super(model);
        Grid grid = (Grid)model;
        cellViews = new CellView[grid.dim][grid.dim];

        for (int row = 0; row < grid.dim; row++) {
            for (int col = 0; col < grid.dim; col++) {
                cellViews[row][col] = new CellView(grid.getCell(row, col));
                setLayout(new GridLayout(((Grid) model).getDim(), ((Grid) model).getDim()));
                cellViews[row][col].update();
                add(cellViews[row][col]); // Add CellView to the GridView
            }
        }
    }

    // Anson Lau
    private void setCellViews() {
        removeAll();
        int dim = ((Grid) model).getDim();

        setLayout(new GridLayout(dim, dim));
        cellViews = new CellView[dim][dim];

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                cellViews[row][col] = new CellView(((Grid) model).getCell(row, col));
                add(cellViews[row][col]);
            }
        }
        update();
    }

    public void setModel(Model model) {
        super.setModel(model);
        setCellViews();
    }

    public void update() {
        for (int row = 0; row < cellViews.length; row ++) {
            for (int col = 0; col < cellViews[row].length; col ++) {
                cellViews[row][col].update();
            }
        }
    }

}
