import java.awt.*;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.setup();
        new DFS();

        try {
            new Screenshot(maze.frame);
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }
}
