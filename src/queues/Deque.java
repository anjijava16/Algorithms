import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sunilpatil on 9/14/16.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return N;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException();
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            Node oldFirst = first;
            first = node;
            first.after = oldFirst;
            oldFirst.before = first;
        }

        N++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException();

        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            Node oldLast = last;
            last = node;
            oldLast.after = last;
            last.before = oldLast;
        }

        N++;
    }

    // remove and return the item from the front
    public Item removeFirst() {

        if (isEmpty())
            throw new NoSuchElementException();
        Item returnItem = first.item;
        first = first.after;
        if (first == null)
            last = null;
        else
            first.before = null;

        N--;
        return returnItem;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (last == null)
            throw new NoSuchElementException("");
        Item returnItem = last.item;
        last = last.before;
        if (last == null)
            first = null;
        else
            last.after = null;

        N--;
        return returnItem;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class Node {
        private Item item;
        private Node before;
        private Node after;

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", after=" + after +
                    '}';
        }
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item returnItem = current.item;
            current = current.after;
            return returnItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }



    // unit testing
    public static void main(String[] args) {

    }
}
