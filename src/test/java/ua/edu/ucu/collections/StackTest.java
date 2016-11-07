package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testSomeMethod() {
        Stack st = new Stack();
        st.add(1);
        st.add(2);
        st.add(3);
        Stack actualResult = st;
        assertEquals(" 1 --> 2 --> 3", actualResult.toString());
    }


    @Test
    public void testSomeMethod2() {
        Stack st = new Stack();
        st.add(1);
        st.add(2);
        st.add(3);
        Object actualResult = st.peek();
        assertEquals(1, actualResult);
    }

    @Test
    public void testSomeMethod3() {
        Stack st = new Stack();
        st.add(1);
        st.add(2);
        st.add(3);
        Object actualResult = st.pop();
        assertEquals(1, actualResult);
    }

}
