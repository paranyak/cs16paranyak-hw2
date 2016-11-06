package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.InputMismatchException;


public class ImmutableLinkedListTest {
    
    @Test
    public void testMethodAdd() {
        ImmutableList m = new ImmutableLinkedList();
        m = m.add(1);
        m = m.add(2);
        m = m.add(3);
        ImmutableList actualResult = m;
        assertEquals(" 1 --> 2 --> 3", actualResult.toString());
    }

    @Test
    public void testMethodAdd2() {
        ImmutableList m = new ImmutableLinkedList();
        m = m.add(1);
        m = m.add(2);
        m = m.add(3);
        ImmutableList second = m.add(4);
        second = second.add(5);
        ImmutableList actualResult = second;
        assertEquals(" 1 --> 2 --> 3 --> 4 --> 5", actualResult.toString());
    }

   /* @Test
    public void testMethodAddIndex() {
        ImmutableList m = new ImmutableLinkedList();
        m = m.add(0, 1);
        m = m.add(1, 2);
        ImmutableList second = m.add(2, 4);
        second = second.add(2, 3);
        ImmutableList actualResult = second;
        assertEquals(" 1 --> 2 --> 3 --> 4", actualResult.toString());
    }*/

    @Test(expected = InputMismatchException.class)
    public void testMethodAddIndex2() {
        ImmutableList m = new ImmutableLinkedList();
        m = m.add(2, 9);
    }
/*
    @Test
    public void testMethodAddAll() {
        ImmutableList m = new ImmutableLinkedList();
        m = m.add(0, 1);

        m = m.add(1, 2);
        m = m.add(2, 4);
        m = m.add(2, 3);
        Integer [] arr = {5, 6, 7};

        ImmutableList actualResult = m.addAll(arr);;
        assertEquals(" 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7", actualResult.toString());
    }*/

    @Test
    public void testMethodAddAllIndex() {
        ImmutableList m = new ImmutableLinkedList();
        m = m.add(0, 1);
        m = m.add(1, 2);
        m = m.add(2, 4);
        m = m.add(2, 3);
        Integer [] arr = {5, 6, 7};
        ImmutableList actualResult = m.addAll(1, arr);

        assertEquals(" 1 --> 5 --> 6 --> 7 --> 2 --> 3 --> 4 --> null", actualResult.toString());
    }



    @Test
    public void testMethodGet() {
        ImmutableList m = new ImmutableLinkedList();
        ImmutableList second = m.add(4);
        second = second.add(5);
        Object actualResult = second.get(0);
        assertEquals( 4 , actualResult);
    }

    @Test(expected = InputMismatchException.class)
    public void testMethodGetE() {
        ImmutableList m = new ImmutableLinkedList();
        ImmutableList second = m.add(4);
        second = second.add(5);
        second.get(10);
    }

    @Test(expected = InputMismatchException.class)
    public void testMethodRemoveE() {
        ImmutableList m = new ImmutableLinkedList();
        ImmutableList second = m.add(4);
        second = second.add(5);
        second.remove(10);
    }

    @Test
    public void testMethodRemove() {
        ImmutableList m = new ImmutableLinkedList();
        ImmutableList second = m.add(4);
        second = second.add(5);
        second = second.add(8);
        second = second.add(6);
        Object actualResult = second.remove(2);
        assertEquals(" 4 --> 5 --> 6", actualResult.toString());
    }

    @Test
    public void testMethodRemoveFromStart() {
        ImmutableList m = new ImmutableLinkedList();
        ImmutableList second = m.add(4);
        second = second.add(5);
        second = second.add(8);
        second = second.add(6);
        Object actualResult = second.remove(0);
        assertEquals(" 5 --> 8 --> 6", actualResult.toString());
    }
    @Test
    public void testMethodSet() {
        ImmutableList m = new ImmutableLinkedList();
        ImmutableList second = m.add(10);
        second = second.add(20);
        second = second.add(89);
        second = second.add(40);
        Object actualResult = second.set(2, 30);
        assertEquals(" 10 --> 20 --> 30 --> 40", actualResult.toString());
    }

    @Test(expected = InputMismatchException.class)
    public void testMethodSetE() {
        ImmutableList m = new ImmutableLinkedList();
        ImmutableList second = m.add(4);
        second = second.add(5);
        second.set(10, 8);
    }

    @Test
    public void testMethodIndexOf() {
        ImmutableList m = new ImmutableLinkedList();
        ImmutableList second = m.add(10);
        second = second.add(20);
        second = second.add(89);
        second = second.add(40);
        Object actualResult = second.indexOf(89);
        assertEquals(2, actualResult);
    }
    @Test
    public void testMethodIndexOfE() {
        ImmutableList m = new ImmutableLinkedList();
        ImmutableList second = m.add(4);
        second = second.add(5);
        Object a = second.indexOf(100);
        assertEquals(-1, a);

    }
    @Test
    public void testMethodSize() {
        ImmutableList m = new ImmutableLinkedList();
        ImmutableList second = m.add(10);
        second = second.add(20);
        second = second.add(89);
        second = second.add(40);
        Object actualResult = second.size();
        assertEquals(4, actualResult);
    }

    @Test
    public void testMethodClear() {
        ImmutableList m = new ImmutableLinkedList();
        ImmutableList second = m.add(10);
        second = second.add(20);
        second = second.add(89);
        second = second.add(40);
        ImmutableList m_1 = second.clear();
        Object actualResult = m_1.clear();
        assertEquals("is empty", actualResult.toString());
    }

    @Test
    public  void testMethodEmpty(){
        ImmutableList m = new ImmutableLinkedList();
        m = m.add(2);
        boolean ac = m.isEmpty();
        assertEquals(false, ac);
    }

    @Test
    public  void testMethodEmpty2(){
        ImmutableList m = new ImmutableLinkedList();
        boolean ac = m.isEmpty();
        assertEquals(true, ac);
    }

    @Test
    public  void testMethodToArray(){
        ImmutableList m = new ImmutableLinkedList();
        m = m.add(2);
        m = m.add(3);
        Object [] ac = m.toArray();
        Object [] ex = {2, 3};
        assertEquals(Arrays.toString(ex), Arrays.toString(ac));

    }
}
