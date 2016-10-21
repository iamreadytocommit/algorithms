package me.forklift.y2016;

public class Maze {
    private static final int PATHWAY = 1;
    private static final int VISITED = 2;
    private static final int NOWAY = 3;

    private static final int SIZE_OF_MAZE = 7;
    private static final int[][] MAZE = { 
            { 1, 0, 0, 0, 0, 0, 1 }, 
            { 1, 1, 0, 1, 1, 1, 1 }, 
            { 1, 1, 0, 1, 0, 0, 0 },
            { 1, 1, 0, 1, 0, 0, 0 }, 
            { 1, 1, 0, 1, 1, 0, 1 }, 
            { 1, 1, 1, 1, 0, 0, 1 }, 
            { 1, 1, 1, 1, 0, 0, 1 } 
    };

    private void printMaze() {
        for (int x = 0; x < SIZE_OF_MAZE; x++) {
            for (int y = 0; y < SIZE_OF_MAZE; y++) {
                System.out.print(MAZE[x][y] + " ");
            }
            System.out.println();
        }
    }

    private boolean findPath(int x, int y) {

        if (isExitPoint(x, y))
            return true;
        else if (x < 0 || y < 0 || x >= SIZE_OF_MAZE || y >= SIZE_OF_MAZE)
            return false;
        else if (MAZE[x][y] != PATHWAY)
            return false;
        else {
            // mark current cell as a VISITED
            MAZE[x][y] = VISITED;

            // try to find exit for four direction
            if (findPath(x, y + 1))
                return true;
            else if (findPath(x + 1, y))
                return true;
            else if (findPath(x, y - 1))
                return true;
            else if (findPath(x - 1, y))
                return true;

            //if there is noway, mark current cell as a NOWAY.
            MAZE[x][y] = NOWAY;
            return false;
        }

    }

    private boolean isExitPoint(int x, int y) {
        if (x == SIZE_OF_MAZE - 1 && y == SIZE_OF_MAZE)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        Maze maze = new Maze();

        maze.printMaze();

        if (maze.findPath(0, 0)) {
            System.out.println("found way..");
        } else {
            System.out.println("couldn't find way.");
        }

        maze.printMaze();
    }
}
