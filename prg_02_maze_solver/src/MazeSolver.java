/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg02 - MazeSolver class
 * Your name(s): Daniel Martinez, Mary Lewis
 */

import java.awt.*;

class MazeSolver {

    private Maze maze;
    private MazeGUI gui;

    MazeSolver(int size) {
        this.maze = new Maze(size);
        this.gui = new MazeGUI(maze);
    }

    void repaint(Path path) {
        gui.setPath(path);
        gui.repaint();
        try {
            Thread.sleep(50);
        } catch (Exception ex) {

        }
    }

    // TODO: implement the exhaustive search algorithm to find a solution to the maze puzzle
    private Path solve() throws CloneNotSupportedException {
        Stack stack = new Stack();
        Path path = new Path(maze);
        path.append(new Location());
        stack.push(path);

        while (!stack.isEmpty()) {
            Path currentPath = stack.pop();
            repaint(currentPath);
            if (currentPath.isAtEnd()) {
                return path;
            } else {
                     {
                        if (currentPath.canMoveLeft()) {
                            Path clone = (Path) currentPath.clone();
                            clone.append(new Location(currentPath.getLast().getX() - 1, currentPath.getLast().getY()));
                            if (!currentPath.contains(new Location(currentPath.getLast().getX() - 1, currentPath.getLast().getY()))) {
                                stack.push(clone);
                            }
                        } if (currentPath.canMoveUp()) {
                            Path clone = (Path) currentPath.clone();
                            clone.append(new Location(currentPath.getLast().getX(), currentPath.getLast().getY() - 1));
                            if (!currentPath.contains(new Location(currentPath.getLast().getX(), currentPath.getLast().getY() - 1))) {
                                stack.push(clone);
                            }

                        }
                         if(currentPath.canMoveDown()) {
                             Path clone = (Path) currentPath.clone();
                             clone.append(new Location(currentPath.getLast().getX(), currentPath.getLast().getY() + 1));
                             if (!currentPath.contains(new Location(currentPath.getLast().getX(), currentPath.getLast().getY() + 1))) {
                                 stack.push(clone);
                             }

                         }if (currentPath.canMoveRight()) {
                            Path clone = (Path) currentPath.clone();
                            clone.append(new Location(currentPath.getLast().getX() + 1, currentPath.getLast().getY()));
                            if (!currentPath.contains(new Location(currentPath.getLast().getX() + 1, currentPath.getLast().getY()))) {
                                stack.push(clone);
                            }

                        }

                    }

                    }

            }

        return path;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        MazeSolver mazeSolver = new MazeSolver(50);
        Path path = mazeSolver.solve();
        if (path != null)
            System.out.println("Found a solution!");
        else
            System.out.println("A solution does not exist!");
    }
}