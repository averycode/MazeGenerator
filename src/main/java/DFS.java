import java.util.Stack;

public class DFS {

    Stack<Cell> stack = new Stack<>();
    Maze maze = new Maze();

    public DFS() {
        Cell current = Maze.grid[0][0];
        current.setVisited(true);
        stack.push(current);
        current = stack.pop();
        while (!maze.allVisited()) {
            if (!current.getNeighbours().isEmpty()) {
                Cell n = current.getRandomNeighbour();
                n.setVisited(true);
                n.removeWall(current);
                stack.push(n);
                current = n;
            } else {
                current = stack.pop();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished");
    }

}
