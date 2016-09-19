import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * Basic idea with RandomizedQueue is, Array based queue.
 * Since its randomized Queue we dont have to worry about
 * Created by sunilpatil on 9/14/16.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException();
        if (items.length <= size)
            resize(size * 2);
        items[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0)
            throw new NoSuchElementException();

        int randomItemIndex = StdRandom.uniform(size);
        Item returnItem = items[randomItemIndex];
        items[randomItemIndex] = items[size - 1];
        items[size - 1] = null;
        size = size - 1;
        return returnItem;
    }

    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (size == 0)
            throw new NoSuchElementException();

        int randomItemIndex = StdRandom.uniform(size);

        return items[randomItemIndex];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<>();
    }

    private class RandomizedQueueIterator<Item> implements Iterator<Item> {
        private int currentIndex;
        private int[] shuffledList = new int[size];

        RandomizedQueueIterator() {
            for (int i = 0; i < size; i++)
                shuffledList[i] = i;
            StdRandom.shuffle(shuffledList);
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return (Item) items[shuffledList[currentIndex++]];
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
