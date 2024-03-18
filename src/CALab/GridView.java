package CALab;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView  extends View {

    private CellView cellViews[][];

    public GridView(Model model) {
        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col)
        cellViews[row][col] = cell
        set cell.row and cell.col here
        */
    }

    public void update(String msg, Object oldState, Object newState) {
        for (int row = 0; row < cellViews.length; row ++) {
            for (int col = 0; col < cellViews[row].length; col ++) {
                cellViews[row][col].update(msg, oldState, newState);
            }
        }
    }

}
