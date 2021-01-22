/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg02 - Path class
 * Your name(s):
 */

import java.awt.*;
import java.util.function.LongConsumer;

class Path {

    private Node<Location> head, tail;
    private Maze           maze;

    public Path(final Maze maze) {
        head = tail = null;
        this.maze = maze;
    }

    // TODOd: add the given location at the end of the path
    public void append(Location location) {
        Node<Location> newL = new Node(location);


        if(isEmpty()){
            head = tail = newL;
        }
        else {
            tail.setNext(newL);
            tail = newL;

        }
    }

    // TODOd: return the last location of the path (or null if the path is empty)
    public Location getLast() {
        if(isEmpty()){
            return null;
        }
        else{
            return tail.getData();
        }
    }


    // TODOd: return true/false depending whether the last location of the path corresponds to the exit location of the maze; the exit location of the maze is always at (maze's size - 1, maze's size - 1)
    public boolean isAtEnd() {
        if((getLast().getX() == maze.getSize()-1)  &&  (getLast().getY() == maze.getSize()-1)){
            return true;
        }
        else {
            return false;
        }
    }

    // TODOd: return true/false depending whether it is possible to move left from the last location of the path; note that you can query maze to check if a location is a wall or not
    public boolean canMoveLeft() {
        Location a = new Location(getLast().getX() - 1, getLast().getY());
        return !maze.isWall(a);
    }

    // TODOd: return true/false depending whether it is possible to move right from the last location of the path; note that you can query maze to check if a location is a wall or not
    public boolean canMoveRight() {
        Location a = new Location(getLast().getX() + 1, getLast().getY());
        return !maze.isWall(a);
    }

    // TODOd: return true/false depending whether it is possible to move up from the last location of the path; note that you can query maze to check if a location is a wall or not
    public boolean canMoveUp() {
        Location a = new Location(getLast().getX(), getLast().getY() - 1);
        return !maze.isWall(a);
    }

    // TODOd: return true/false depending whether it is possible to move down from the last location of the path; note that you can query maze to check if a location is a wall or not
    public boolean canMoveDown() {
        Location a = new Location(getLast().getX(), getLast().getY() + 1);
        return !maze.isWall(a);
    }

    public boolean isEmpty() {
        return head == null;
    }

    // TODOd: returns true/false depending whether the given location is already in the path
    boolean contains(Location location) {
        Node<Location> current = head;
        while(current != null){
            if(current.getData().equals(location)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // TODOd: returns a cloned path from the callee path object

    @Override
    public Object clone() throws CloneNotSupportedException {
        Path a = new Path(maze);
        Node<Location> current = head;
        while(current != null){
            a.append(new Location(current.getData().getX(), current.getData().getY()));
            current = current.getNext();
        }
        return a;

    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        int cellWidth = MazeGUI.WIDTH / this.maze.getSize();
        int cellHeight = MazeGUI.HEIGHT / this.maze.getSize();
        Node<Location> current = head;
        while (current != null) {
            Location location = current.getData();
            g.fillRect(location.getX() * cellWidth + 1, location.getY() * cellHeight + 1, cellWidth - 2, cellHeight - 2);
            current = current.getNext();
        }
    }
}
