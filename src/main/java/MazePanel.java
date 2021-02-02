import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        for (int i = 0; i < Maze.grid.length; i++) {
            for (int j = 0; j < Maze.grid.length; j++) {
                Cell c = Maze.grid[i][j];
                c.draw(g);
            }
        }
        repaint();
    }
}
