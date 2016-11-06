package ua.edu.ucu.collections.immutable;

import java.util.InputMismatchException;
import java.util.Objects;

public class ImmutableLinkedList implements ImmutableList{

    public Node startN;
    public int sizeOfList = 0;


    public ImmutableLinkedList(){
        startN = new Node(null);

    }
    public ImmutableLinkedList(Node first){
        startN = first;
        Node curNode = startN.getNext();
        while(curNode != null){
            sizeOfList++;
            curNode = curNode.getNext();
        }
    }

    @Override
    public ImmutableList add(Object e) {
        Node newCurrent;
        if(startN.getData() == null){
            newCurrent = startN.clone();
            newCurrent.setData(e);
            sizeOfList ++;
        }else{
            newCurrent = startN.clone();
            Node tmp = newCurrent;
            Node current = startN ;
            Node element = new Node(e);
            while(current.getNext() != null){
                Node n = current.getNext().clone();
                tmp.setNext(n);
                tmp = n;
                current = current.getNext();
            }
            tmp.setNext(element);
            sizeOfList ++;
        }

        return new ImmutableLinkedList(newCurrent);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index < 0 || index > sizeOfList || isEmpty()){
            throw new InputMismatchException("Index out of range");
        }
        Node newCurrent;
        if(index == 0){
            newCurrent = new Node(e);
            Node tmp = newCurrent;
            Node current_tmp = startN;
            while(current_tmp != null){
                Node n = current_tmp.clone();
                tmp.setNext(n);
                tmp = n;
                current_tmp = current_tmp.getNext();
            }
        }else{
            newCurrent = startN.clone();
            Node tmp = newCurrent;
            Node current = startN ;
            Node element = new Node(e);
            for(int i = 0; i < index-1; i++){
                Node n = current.getNext().clone();
                tmp.setNext(n);
                tmp = n;
                current = current.getNext();
            }
            Node current_tmp = current.getNext();
            tmp.setNext(element);
            tmp = element;

            while(current_tmp!= null){
                Node n = current_tmp.clone();
                tmp.setNext(n);
                tmp = n;
                current_tmp = current_tmp.getNext();
            }
        }

        return new ImmutableLinkedList(newCurrent);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Node newCurrent;
        if(startN.getData() == null){
            newCurrent = new Node(c[0]);
            Node tmp = newCurrent;
            Node current = startN;
            for(int i = 1; i < c.length; i ++){
                newCurrent.setData(c[0]);
                Node element = new Node(c[i]);
                while(current.getNext() != null){
                    Node n = current.getNext().clone();
                    tmp.setNext(n);
                    tmp = n;
                    current = current.getNext();
                }
                tmp.setNext(element);
                tmp = element;
            }
            sizeOfList = c.length;
        }else {
            newCurrent = startN.clone();
            Node tmp = newCurrent;
            Node current = startN;
            for (int i = 0; i < c.length; i++) {
                Node element = new Node(c[i]);
                while(current.getNext() != null){
                    Node n = current.getNext().clone();
                    tmp.setNext(n);
                    tmp = n;
                    current = current.getNext();
                }
                tmp.setNext(element);
                tmp = element;
                sizeOfList ++;

            }
        }

        return new ImmutableLinkedList(newCurrent);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > sizeOfList || isEmpty()){
            throw new InputMismatchException("Index out of range");
        }

        return null;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > sizeOfList || isEmpty()){
            throw new InputMismatchException("Index out of range");
        }
        Node tmp = startN;

        for(int i = 0; i < index; i++){
            tmp = tmp.getNext();
        }
        return tmp.getData();
    }

    @Override
    public ImmutableList remove(int index) {
        return null;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 || index > sizeOfList || isEmpty()){
            throw new InputMismatchException("Index out of range");
        }
        Node newCurrent;
        if(index == 0){
            newCurrent = new Node(e);
            Node tmp = newCurrent;
            Node current_tmp = startN;
            while(current_tmp.getNext() != null){
                Node n = current_tmp.getNext().clone();
                tmp.setNext(n);
                tmp = n;
                current_tmp = current_tmp.getNext();
            }
        }else{
            newCurrent = startN.clone();
            Node tmp = newCurrent;
            Node current = startN ;
            Node element = new Node(e);
            for(int i = 0; i < index-1; i++){
                Node n = current.getNext().clone();
                tmp.setNext(n);
                tmp = n;
                current = current.getNext();
            }
            Node current_tmp = current.getNext();
            tmp.setNext(element);
            tmp = element;

            while(current_tmp.getNext() != null){
                Node n = current_tmp.getNext().clone();
                tmp.setNext(n);
                tmp = n;
                current_tmp = current_tmp.getNext();
            }
        }

        return new ImmutableLinkedList(newCurrent);
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ImmutableList clear() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    public String toString(){
        String presentation = " ";
        if (startN.getData() != null){
            presentation += startN.getData();
            Node start = startN;
            while(start.getNext() != null){
                presentation += "- ";
                start = start.getNext();
                presentation += start.getData();
            }
        }else{
            presentation = "is empty";
            return presentation;
        }
        return presentation;
    }


    public static void main(String[] args){
      //  Node a = new Node(1);
        ImmutableList m = new ImmutableLinkedList();
        System.out.println("m: "+ m);
        m = m.add(1);

        ImmutableList m_1 = m.add(2);
        m_1 = m_1.add(3);
        m_1 = m_1.add(4);
        m_1 = m_1.add(5);
        m_1 = m_1.add(6);
        m_1 = m_1.add(8);
        m_1 = m_1.add(9);
        m_1 = m_1.add(10);
        System.out.println("m: " + m);
        System.out.println("m_1(add to m): " +m_1);
        ImmutableList m_2 = m_1.set(0, 7);
        System.out.println("m: " +m);
        System.out.println("m_2(set to m on 0 index 7): " +m_2);

        ImmutableList m_3 = m_1;
        System.out.println("m_3(= m_1): " +m_3);
        m_3=  m_3.add(0, 12);
        System.out.println("m_3(add to m_3 on 0 index 12): " +m_3);

        ImmutableList m_4 = m_1.add(4, 100);
        System.out.println("m_4(add to m_1 on 4 index 100): " +m_4);

        Integer[] c = {100, 295, 300, 127};
        ImmutableList m_5 = m_1.addAll(c);
        System.out.println("m_5(add to m_1 list of numbers): " +m_5);

        ImmutableList m_6 = new ImmutableLinkedList();
        Integer[] c_0 = {100, 200, 300, 400};
        m_6 = m_6.addAll(c_0);
        System.out.println("m_6(add to empty list of numbers): " +m_6);

        System.out.println("m_1(element on 2 index): " +m_1.get(2));
        System.out.println("m_5(element on 10 index): " + m_5.get(10));

    }
}
