package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;
import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testMethodAdd() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(1);
        m = m.add(2);
        m = m.add(3);
        ImmutableList actualResult = m;
        assertEquals(" 1,2,3", actualResult.toString());
    }

    @Test(expected = InputMismatchException.class)
    public void testMethodAddIndex2() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(2, 9);
    }

    @Test
    public void testMethodAddIndex() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(1);
        ImmutableList second = m.add(2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        ImmutableList actualResult = second;
        assertEquals(" 1,2,4,3", actualResult.toString());
    }
    @Test
    public void testMethodAddIndex3() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        ImmutableList actualResult = second;
        assertEquals(" 1,2,4,5,3", actualResult.toString());
    }

    @Test
    public void testMethodAddAll() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        Integer [] c = {6, 7, 8};
        second = second.addAll(c);
        ImmutableList actualResult = second;
        assertEquals(" 1,2,4,5,3,6,7,8", actualResult.toString());
    }

    @Test
    public void testMethodAddAllStart() {
        ImmutableList second = new ImmutableArrayList();

        Integer [] c = {6, 7, 8};
        second = second.addAll(c);
        ImmutableList actualResult = second;
        assertEquals(" 6,7,8", actualResult.toString());
    }

    @Test
    public void testMethodAddAllIndex() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        Integer [] c = {6, 7, 8};
        second = second.addAll(1,c);
        ImmutableList actualResult = second;
        assertEquals(" 1,6,7,8,2,4,5,3", actualResult.toString());
    }
    @Test(expected = InputMismatchException.class)
    public void testMethodAddAllE() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        Integer [] c = {6, 7, 8};
        second = second.addAll(10,c);

    }

    @Test
    public void testMethodGet() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        Integer [] c = {6, 7, 8};
        second = second.addAll(c);
        Object actualResult = second.get(0);
        assertEquals(1, actualResult);
    }

    @Test(expected = InputMismatchException.class)
    public void testMethodGetE() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second.get(10);
    }
    @Test
    public void testMethodRemove() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        ImmutableList actualResult = second.remove(2);
        assertEquals(" 1,2,5,3", actualResult.toString());
    }

    @Test(expected = InputMismatchException.class)
    public void testMethodRemoveE() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        second.remove(12);
    }

    @Test
    public void testMethodSet() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        ImmutableList actualResult = second.set(2,8);
        assertEquals(" 1,2,8,5,3", actualResult.toString());
    }

    @Test(expected = InputMismatchException.class)
    public void testMethodSetE() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        second.set(13,7777);
    }

    @Test
    public void testMethodIndexOf() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        Object actualResult = second.indexOf(4);
        assertEquals(2, actualResult);
    }

    @Test
    public void testMethodIndexOfE() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        Object actualResult = second.indexOf(14);
        assertEquals(-1, actualResult);
    }

    @Test
    public void testMethodSize() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        int actualResult = second.size();
        assertEquals(5, actualResult);
    }

    @Test
    public void testMethodClear() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        ImmutableList actualResult = second.clear();
        assertEquals("is empty", actualResult.toString());
    }

    @Test
    public void testMethodEmpty() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        second = second.clear();
        boolean actualResult = second.isEmpty();
        assertEquals(true, actualResult);
    }

    @Test
    public void testMethodToArray() {
        ImmutableList m = new ImmutableArrayList();
        m = m.add(0, 1);
        ImmutableList second = m.add(1, 2);
        second = second.add(2, 3);
        second = second.add(2, 4);
        second = second.add(3, 5);
        Object [] actualResult = second.toArray();
        Object [] expected = {1, 2, 4, 5, 3};
        assertEquals(Arrays.toString(expected), Arrays.toString(actualResult));
    }
}
