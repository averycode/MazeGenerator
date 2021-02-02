import java.awt.*;
import java.util.*;
import java.util.List;

public class Cell {

    private int x, y;
    private boolean visited;

    private boolean[] walls = {true, true, true, true};  //oben, rechts, unten, links
    private List<Cell> neighbours;

    private Random random = new Random();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
        neighbours = new ArrayList<Cell>();
    }

    public void draw(Graphics g){

        if (this.isVisited()) {
            g.setColor(Color.WHITE);
            g.fillRect(this.getX(), this.getY(), Maze.CELLSIZE, Maze.CELLSIZE);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(this.getX(), this.getY(), Maze.CELLSIZE, Maze.CELLSIZE);
        }

        g.setColor(Color.BLACK);
        if (walls[0]) {
            g.drawLine(x,y,x + Maze.CELLSIZE, y);
        }

        if (walls[1]) {
            g.drawLine(x + Maze.CELLSIZE,y,x + Maze.CELLSIZE, y + Maze.CELLSIZE);
        }

        if (walls[2]) {
            g.drawLine(x,y + Maze.CELLSIZE,x + Maze.CELLSIZE, y + Maze.CELLSIZE);
        }

        if (walls[3]) {
            g.drawLine(x,y,x, y + Maze.CELLSIZE);
        }
    }

    @Override
    public String toString() {
        return "Cell";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean[] getWalls() {
        return walls;
    }

    public void setWalls(int index, boolean wall) {
        this.walls[index] = wall;
    }

    public List<Cell> getNeighbours() {
        Set<Cell> set = new HashSet<>();
        int x = this.getX() / Maze.CELLSIZE;
        int y = this.getY() / Maze.CELLSIZE;

        int oben = y - 1;
        int unten = y + 1;
        int links = x - 1;
        int rechts = x + 1;

        if (oben < 0) oben = 0;
        if (unten > Maze.grid.length - 1) unten = Maze.grid.length - 1;
        if (links < 0) links = 0;
        if (rechts > Maze.grid.length - 1) rechts = Maze.grid.length - 1;

        if (!Maze.grid[x][oben].isVisited() && Maze.grid[x][oben] != this) set.add(Maze.grid[x][oben]);
        if (!Maze.grid[x][unten].isVisited() && Maze.grid[x][unten] != this) set.add(Maze.grid[x][unten]);
        if (!Maze.grid[links][y].isVisited() && Maze.grid[links][y] != this) set.add(Maze.grid[links][y]);
        if (!Maze.grid[rechts][y].isVisited() && Maze.grid[rechts][y] != this) set.add(Maze.grid[rechts][y]);

        ArrayList<Cell> neighbours = new ArrayList<>(set);

        return neighbours;
    }

    public void addNeighbour(Cell cell) {
        this.neighbours.add(cell);
    }

    public Cell getRandomNeighbour() {
        int len = this.getNeighbours().size();
        return this.getNeighbours().get(random.nextInt(len));
    }

    public void removeWall(Cell neighbour) {
        int nx = neighbour.getX();
        int ny = neighbour.getY();
        if (this.x == nx) {
            if (ny > this.y) {
                this.setWalls(2, false);
                neighbour.setWalls(0, false);
            } else {
                this.setWalls(0, false);
                neighbour.setWalls(2, false);
            }
        } else if (this.y == ny) {
            if (nx > this.x) {
                this.setWalls(1, false);
                neighbour.setWalls(3, false);
            } else {
                this.setWalls(3, false);
                neighbour.setWalls(1, false);
            }
        }
    }

    public void setNeighbours(List<Cell> neighbours) {
        this.neighbours = neighbours;
    }
}
