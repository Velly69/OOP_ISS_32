package com.example.mazegame;

import com.example.mazegame.model.Cell;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class GameViewTest {
    private static final int COLS = 7;
    private static final int ROWS = 10;
    private static Cell[][] cells;

    @Before
    public void setUp(){
        cells = new Cell[COLS][ROWS];
        for(int x = 0; x < COLS; x++){
            for(int y = 0; y < ROWS; y++){
                cells[x][y] = new Cell(x, y);
            }
        }
    }

    @Test
    public void shouldRemoveWallBetweenCells(){
        Cell current = cells[1][1];
        Cell next = cells[1][2];
        GameView.removeTheWall(current, next);
        assertFalse(current.bottomWall);
        assertFalse(next.topWall);
    }

    @Test
    public void shouldFindNeighbours(){
        Cell example = cells[3][3];
        Cell result = GameView.getNeighbour(cells, example);
        ArrayList<Cell> canBeResult = new ArrayList<>();
        canBeResult.add(cells[3][4]);
        canBeResult.add(cells[3][2]);
        canBeResult.add(cells[2][3]);
        canBeResult.add(cells[4][3]);
        assertTrue(canBeResult.contains(result));
    }
}