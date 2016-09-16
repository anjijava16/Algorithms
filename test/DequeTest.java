import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Created by sunilpatil on 9/14/16.
 */
public class DequeTest {

    @Test(expected = NullPointerException.class)
    public void checkEmptyAddItem(){
        Deque<String> deque = new Deque<>();
        deque.addFirst(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void checkEmptyRemvoeFirst(){
        Deque<String> deque = new Deque<>();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void checkEmptyRemvoeLast(){
        Deque<String> deque = new Deque<>();
        deque.removeLast();
    }

    @Test
    public void testAddAndRemoveFirst(){
        Deque<String> deque = new Deque<>();
        deque.addFirst("Second");
        deque.addFirst("First");

        assert deque.size() ==2;
        assert deque.removeFirst().equals("First");
        assert deque.size() ==1;

        assert deque.removeFirst().equals("Second");
        assert deque.size() ==0;

    }

    @Test
    public void testAddFirstAndRemovelast(){
        Deque<String> deque = new Deque<>();
        deque.addFirst("Second");
        deque.addFirst("First");

        assert deque.size() ==2;
        assert deque.removeLast().equals("Second");
        assert deque.size() ==1;

        assert deque.removeLast().equals("First");
        assert deque.size() ==0;
    }

    @Test
    public void testAddRemoveLast(){
        Deque<String> deque = new Deque<>();
        deque.addLast("Second");
        deque.addLast("First");

        assert deque.size() ==2;
        assert deque.removeLast().equals("First");
        assert deque.size() ==1;

        assert deque.removeLast().equals("Second");
        assert deque.size() ==0;
    }

    @Test
    public void testAddFrontRemoveBottom(){
        Deque<String> deque = new Deque<>();
        deque.addFirst("Second");
        deque.addFirst("First");

        assert deque.size() ==2;
        assert deque.removeLast().equals("Second");
        assert deque.size() ==1;

        assert deque.removeLast().equals("First");
        assert deque.size() ==0;
    }

    @Test
    public void testAddRemoveMix(){
        Deque<String> deque = new Deque<>();
        deque.addFirst("Second");


        assert deque.size() ==1;
        assert deque.removeLast().equals("Second");
        assert deque.size() ==0;
        deque.addFirst("First");
        assert deque.size() ==1;

        assert deque.removeLast().equals("First");
        assert deque.size() ==0;

        deque.addFirst("First");
        deque.addLast("Last");
        deque.addFirst("Second");
        deque.addLast("ButtonLast");
        deque.addFirst("Third");

        assert deque.size() == 5;

        deque.removeLast();
        deque.removeLast();
        deque.removeFirst();
        deque.removeLast();
        deque.removeFirst();
        assert deque.size() == 0;

    }

    @Test
    public void testDequeIterator(){
        Deque<String> deque = new Deque<>();
        deque.addFirst("First");
        deque.addFirst("Second");
        deque.addFirst("Third");

        int count = 0;
        for(String str: deque){
            System.out.println(str);
            count++;
        }
        assert count == 3;
    }

    @Test
    public void testDequeIterator2(){
        Deque<String> deque = new Deque<>();
        deque.addLast("Third");
        deque.addFirst("Second");
        deque.addLast("Fourth");

        deque.addFirst("First");
        deque.addLast("Fifth");

        System.out.println(deque);
        int count = 0;
        for(String str: deque){
            System.out.println(str);
            count++;
        }
        assert count == 5;
        assert deque.size() ==5;
        System.out.println("deque.removeFirst() "+ deque.removeFirst()) ;
        System.out.println("deque.removeLast() "+ deque.removeLast()) ;
        System.out.println(deque);


        System.out.println("After removing 2 elements " + deque.size());
        count = 0;
        for(String str: deque){
            System.out.println(str);
            count++;
        }
        assert count == 3;
    }
}
