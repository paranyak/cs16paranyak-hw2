package ua.edu.ucu.collections;

import org.junit.Test;


import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testSomeMethod() {
        Queue myQ = new Queue();
        myQ.enqueue(1);
        myQ.enqueue(2);
        myQ.enqueue(3);
        Queue actualResult = myQ;
        assertEquals(" 1 --> 2 --> 3", actualResult.toString());
    }

    @Test
    public void testSomeMethod1() {
        Queue myQ = new Queue();
        myQ.enqueue(1);
        myQ.enqueue(2);
        myQ.enqueue(3);
        Object actualResult = myQ.peek();
        assertEquals(1, actualResult);
    }

    @Test
    public void testSomeMethod2() {
        Queue myQ = new Queue();
        myQ.enqueue(1);
        myQ.enqueue(2);
        myQ.enqueue(3);
        Object actualResult = myQ.dequeue();
        assertEquals(1, actualResult);
    }


}
