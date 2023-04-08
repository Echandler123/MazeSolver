//Elijah Chandler 4/7/23
/**
 * Solves the given maze using DFS or BFS
 * @author Ms. Namasivayam
 * @version 03/10/2023
 */
import java.util.LinkedList;
import java.util.Queue;
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
    /* Adds the cells from the end cell to the beginning cell to a stack then adds those cell to an arraylist in the
    order start to end */
    public ArrayList<MazeCell> getSolution() {
        // TODO: Get the solution from the maze
        Stack<MazeCell> solution = new Stack<MazeCell>();
        MazeCell Current = maze.getEndCell();
        while(!Current.equals(maze.getStartCell())) {
            solution.push(Current);
            Current = Current.getParent();
        }
        solution.push(maze.getStartCell());
        ArrayList<MazeCell> SolutionArray = new ArrayList<MazeCell>();
        while(solution.size() != 0) {
            SolutionArray.add(solution.pop());
        }
        // Should be from start to end cells
        return SolutionArray;
    }

    /**
     * Performs a Depth-First Search to solve the Maze
     * @return An ArrayList of MazeCells in order from the start to end cell
     */
    /* Starting with the beginning cell as the current cell each neighbor of that cell is checked to see if it is a
    valid cell then if it is, it is added to the stack then moves on to the next cell by using the most last cell in
    the stack as the new current cell */
    public ArrayList<MazeCell> solveMazeDFS() {
        // TODO: Use DFS to solve the maze
        // Explore the cells in the order: NORTH, EAST, SOUTH, WEST
        Stack<MazeCell> SolvedDfs = new Stack<MazeCell>();
        MazeCell next = maze.getStartCell();
        while(!next.equals(maze.getEndCell())) {
            int row = next.getRow();
            int col = next.getCol();
            if (maze.isValidCell(row - 1, col)) {
                maze.getCell(row - 1, col).setExplored(true);
                SolvedDfs.push(maze.getCell(row - 1, col));
                maze.getCell(row - 1, col).setParent(next);
            }
            if (maze.isValidCell(row, col - 1)) {
                maze.getCell(row, col - 1).setExplored(true);
                SolvedDfs.push(maze.getCell(row, col - 1));
                maze.getCell(row, col - 1).setParent(next);
            }
            if (maze.isValidCell(row + 1, col)) {
                maze.getCell(row + 1, col).setExplored(true);
                SolvedDfs.push(maze.getCell(row + 1, col));
                maze.getCell(row + 1, col).setParent(next);
            }
            if (maze.isValidCell(row, col + 1)) {
                maze.getCell(row, col + 1).setExplored(true);
                SolvedDfs.push(maze.getCell(row, col + 1));
                maze.getCell(row, col + 1).setParent(next);
            }
            next = SolvedDfs.pop();
        }
        return getSolution();
    }

    /**
     * Performs a Breadth-First Search to solve the Maze
     * @return An ArrayList of MazeCells in order from the start to end cell
     */
    /* Starting with the beginning cell as the current cell each neighbor of that cell is checked to see if it is a
    valid cell then if it is, it is added to the queue then moves on to the next cell by using the most recent cell in
    the queue as the new current cell */
    public ArrayList<MazeCell> solveMazeBFS() {
        // TODO: Use BFS to solve the maze
        // Explore the cells in the order: NORTH, EAST, SOUTH, WEST
        Queue<MazeCell> SolvedBfs = new LinkedList<MazeCell>();
        MazeCell next = maze.getStartCell();
        while(!next.equals(maze.getEndCell())) {
            int row = next.getRow();
            int col = next.getCol();
            if (maze.isValidCell(row - 1, col)) {
                maze.getCell(row - 1, col).setExplored(true);
                SolvedBfs.add(maze.getCell(row - 1, col));
                maze.getCell(row - 1, col).setParent(next);
            }
            if (maze.isValidCell(row, col - 1)) {
                maze.getCell(row, col - 1).setExplored(true);
                SolvedBfs.add(maze.getCell(row, col - 1));
                maze.getCell(row , col - 1).setParent(next);
            }
            if (maze.isValidCell(row + 1, col)) {
                maze.getCell(row + 1, col).setExplored(true);
                SolvedBfs.add(maze.getCell(row + 1, col));
                maze.getCell(row + 1, col).setParent(next);
            }
            if (maze.isValidCell(row, col + 1)) {
                maze.getCell(row, col + 1).setExplored(true);
                SolvedBfs.add(maze.getCell(row, col + 1));
                maze.getCell(row, col + 1).setParent(next);
            }
            next = SolvedBfs.remove();
        }
        return getSolution();
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
