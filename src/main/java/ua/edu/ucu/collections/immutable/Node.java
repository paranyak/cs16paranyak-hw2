package ua.edu.ucu.collections.immutable;

import java.util.Objects;

/**
 * Created by cs.ucu.edu.ua on 11/2/2016.
 */
public class Node {
    private Object data;
    private Node next;

    public Node(Object d1) {
        this.data = d1;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node clone(){
        return new Node(data);
    }



}
