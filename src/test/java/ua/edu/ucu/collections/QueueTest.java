package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;

import java.util.Arrays;

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
    
}
