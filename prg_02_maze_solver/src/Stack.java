/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg02 - Stack class
 * Your name(s):
 */

public class Stack {

    private Node<Path> top;

    public Stack() {
        top = null;
    }

    public void push(final Path path) {
        Node<Path> newNode = new Node<>(path);
        newNode.setNext(top);
        top = newNode;
    }

    public Path pop() {
        if (isEmpty())
            return null;
        Path path = top.getData();
        Node<Path> temp = top;
        top = top.getNext();
        temp.setNext(null);
        return path;
    }

    public Path peek() {
        if (isEmpty())
            return null;
        return top.getData();
    }

    public int size() {
        int count = 0;
        Node<Path> current = top;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // top to bottom (left to right)
    @Override
    public String toString() {
        String out = "(top)";
        Node<Path> current = top;
        while (current != null) {
            out += " " + current.toString();
            current = current.getNext();
        }
        out += " (bottom)";
        return out;
    }
}