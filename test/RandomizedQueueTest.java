import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by sunilpatil on 9/16/16.
 */
public class RandomizedQueueTest {

    @Test(expected = NullPointerException.class)
    public void testInsertNull() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeEmpty() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void testSampleEmpty() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.sample();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemove() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyIteratorNext() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.iterator().next();
    }

    @Test
    public void testEnque() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("First");
        assert randomizedQueue.size() == 1;
        randomizedQueue.enqueue("Second");
        assert randomizedQueue.size() == 2;
        randomizedQueue.enqueue("Third");
        assert randomizedQueue.size() == 3;
        randomizedQueue.enqueue("Fourth");
        assert randomizedQueue.size() == 4;
        randomizedQueue.enqueue("Fifth");
        assert randomizedQueue.size() == 5;
    }

    @Test
    public void testSample() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("First");
        randomizedQueue.enqueue("Second");
        randomizedQueue.enqueue("Third");
        randomizedQueue.enqueue("Fourth");
        randomizedQueue.enqueue("Fifth");
        assert randomizedQueue.size() == 5;

        HashSet<String> availableList = new HashSet<>();
        availableList.add("First");
        availableList.add("Second");
        availableList.add("Third");
        availableList.add("Fourth");
        availableList.add("Fifth");

        for (int i = 0; i < 5; i++) {
            String str = randomizedQueue.sample();
            System.out.println("Sample String " + str);
            assert availableList.contains(randomizedQueue.sample());
        }

    }

    @Test
    public void testDeque() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("First");
        randomizedQueue.enqueue("Second");
        randomizedQueue.enqueue("Third");
        randomizedQueue.enqueue("Fourth");
        randomizedQueue.enqueue("Fifth");
        assert randomizedQueue.size() == 5;

        HashSet<String> availableList = new HashSet<>();
        availableList.add("First");
        availableList.add("Second");
        availableList.add("Third");
        availableList.add("Fourth");
        availableList.add("Fifth");

        System.out.println(randomizedQueue);
        for (int i = 0; i < 5; i++ ) {
            String str = randomizedQueue.dequeue();
            assert availableList.size() == 5 - i;
            System.out.println("Deque String " + str);
            System.out.println(randomizedQueue);
            assert availableList.contains(str);

            availableList.remove(str);
        }

    }

    @Test
    public void testIterator() {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("First");
        randomizedQueue.enqueue("Second");
        randomizedQueue.enqueue("Third");
        randomizedQueue.enqueue("Fourth");
        randomizedQueue.enqueue("Fifth");
        assert randomizedQueue.size() == 5;

        for (String str : randomizedQueue)
            System.out.println(str);

        for (String str : randomizedQueue)
            System.out.println(str);

    }
}
