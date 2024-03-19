package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView  extends View {

    private CellView cellViews[][];
    public static int dim = 20;

    public GridView(Model model) {
        cellViews = new CellView[dim][dim];
        for (int row = 0; row < cellViews.length; row ++) {
            for (int col = 0; col < cellViews[0].length; col ++) {
                cellViews[row][col] = new CellView(((Grid) model).getCell(row, col));
            }
        }
    }

    public void update(String msg, Object oldState, Object newState) {
        for (int row = 0; row < cellViews.length; row ++) {
            for (int col = 0; col < cellViews[row].length; col ++) {
                cellViews[row][col].update(msg, oldState, newState);
            }
        }
    }

}
