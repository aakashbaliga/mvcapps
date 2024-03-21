package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView  extends View {

    private CellView cellViews[][];
    public static int dim = 20;

    public GridView(Model model) {

        super(model);
        Grid g = (Grid)model;
        cellViews = new CellView[dim][dim];
        for (int row = 0; row < cellViews.length; row ++) {
            for (int col = 0; col < cellViews[0].length; col ++) {
                cellViews[row][col] = new CellView(g.getCell(row, col));
                setLayout(new GridLayout(dim, dim));
                cellViews[row][col].update();
                add(cellViews[row][col]);
            }
        }
    }

    private void setCellViews() {
        removeAll();
        setLayout(new GridLayout(dim, dim));
        cellViews = new CellView[dim][dim];

        for(int row = 0; row < dim; ++row) {
            for(int col = 0; col < dim; ++col) {

                cellViews[row][col] = new CellView(((Grid)model).getCell(row, col));
                add(cellViews[row][col]);
            }
        }

        this.update();
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
