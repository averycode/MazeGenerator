import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Maze {

    public static final int WIDTH = 600;
    public static final int HEIGHT = WIDTH;
    public static final int CELLSIZE = 20;

    public static Cell[][] grid = new Cell[WIDTH/CELLSIZE][WIDTH/CELLSIZE];

    public Maze() {
        createAndShowGui();
    }

    public void createAndShowGui() {
        JFrame frame = new JFrame("Maze");
        MazePanel mazePanel = new MazePanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mazePanel);
        mazePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
        frame.setVisible(true);
    }

    public void setup(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = new Cell(i * CELLSIZE, j * CELLSIZE);
            }
        }
    }

    public boolean allVisited() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (!grid[i][j].isVisited()){
                    return false;
                }
            }
        }
        return true;
    }

    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }
}
