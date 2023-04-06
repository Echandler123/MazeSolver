/**
 * Solves the given maze using DFS or BFS
 * @author Ms. Namasivayam
 * @version 03/10/2023
 */
import java.util.Stack;
import java.util.ArrayList;

public class MazeSolver {
    private Maze maze;

    public MazeSolver() {
        this.maze = null;
    }

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    /**
     * Starting from the end cell, backtracks through
     * the parents to determine the solution
     * @return An arraylist of MazeCells to visit in order
     */
    public ArrayList<MazeCell> getSolution() {
        // TODO: Get the solution from the maze
        Stack<MazeCell> solution = new Stack<MazeCell>();
        MazeCell Current = maze.getEndCell();
        solution.push(Current);
        while(!Current.equals(maze.getStartCell()))
        {
            solution.push(Current);
            Current = Current.getParent();
        }
        ArrayList<MazeCell> SolutionArray = new ArrayList<MazeCell>();
        while(solution.size() != 0)
        {
            SolutionArray.add(solution.pop());
        }
        // Should be from start to end cells
        return SolutionArray;
    }

    /**
     * Performs a Depth-First Search to solve the Maze
     * @return An ArrayList of MazeCells in order from the start to end cell
     */
    public ArrayList<MazeCell> solveMazeDFS() {
        // TODO: Use DFS to solve the maze
        // Explore the cells in the order: NORTH, EAST, SOUTH, WEST
        Stack<MazeCell> SolvedDfs = new Stack<MazeCell>();
        MazeCell next = maze.getStartCell();
        SolvedDfs.add(next);
        int row = next.getRow();
        int col = next.getCol();
        while(!next.equals(maze.getEndCell()))
        {

            if(maze.isValidCell(row,col))
            {
                row--;
                next = maze.getCell(row,col);
            }
            else

        }
        return null;
    }

    /**
     * Performs a Breadth-First Search to solve the Maze
     * @return An ArrayList of MazeCells in order from the start to end cell
     */
    public ArrayList<MazeCell> solveMazeBFS() {
        // TODO: Use BFS to solve the maze
        // Explore the cells in the order: NORTH, EAST, SOUTH, WEST
        return null;
    }

    public static void main(String[] args) {
        // Create the Maze to be solved
        Maze maze = new Maze("Resources/maze3.txt");

        // Create the MazeSolver object and give it the maze
        MazeSolver ms = new MazeSolver();
        ms.setMaze(maze);

        // Solve the maze using DFS and print the solution
        ArrayList<MazeCell> sol = ms.solveMazeDFS();
        maze.printSolution(sol);

        // Reset the maze
        maze.reset();

        // Solve the maze using BFS and print the solution
        sol = ms.solveMazeBFS();
        maze.printSolution(sol);
    }
}
