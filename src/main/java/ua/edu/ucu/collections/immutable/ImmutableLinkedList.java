package ua.edu.ucu.collections.immutable;

import java.util.InputMismatchException;


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
        }

        return new ImmutableLinkedList(newCurrent);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        sizeOfList = size();
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

            while(current_tmp != null){
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
            }
        }

        return new ImmutableLinkedList(newCurrent);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Node newCurrent;
        if(index == 0){
            newCurrent = new Node(c[0]);
            Node tmp = newCurrent;
            for(int i = 1; i < c.length; i ++){
                Node element = new Node(c[i]);
                tmp.setNext(element);
                tmp = element;
            }

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
            for(int i = 0; i < index-1; i++){
                Node n = current.getNext().clone();
                tmp.setNext(n);
                tmp = n;
                current = current.getNext();
            }
            for(int i = 0; i < c.length; i ++){
                Node element = new Node(c[i]);
                tmp.setNext(element);
                tmp = element;
            }

            Node current_tmp;
            if(current.getNext().getData() == null){
                current_tmp = current;
            }else{
                current_tmp = current.getNext();
            }
            while(current_tmp != null){
                Node n = current_tmp.clone();
                tmp.setNext(n);
                tmp = n;
                current_tmp = current_tmp.getNext();
            }
        }

        return new ImmutableLinkedList(newCurrent);
    }

    @Override
    public Object get(int index) {
        sizeOfList = size();
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
        sizeOfList = size();
        if (index < 0 || index > sizeOfList || isEmpty()){
            throw new InputMismatchException("Index out of range");
        }
        Node newCurrent;
        if(index == 0){
            newCurrent = startN.getNext();
            Node tmp = newCurrent;
            Node current_tmp = newCurrent.getNext();
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
            for(int i = 0; i < index-1; i++){
                Node n = current.getNext().clone();
                tmp.setNext(n);
                tmp = n;
                current = current.getNext();
            }
            Node current_tmp = current.getNext();
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
    public ImmutableList set(int index, Object e) {
        sizeOfList = size();
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
        sizeOfList = size();
        Node curNode = startN;
        for(int i = 0; i < sizeOfList; i++){
            if(curNode.getData() == e){
                return i;
            }else{
                curNode = curNode.getNext();
            }
        }return -1;
    }

    @Override
    public int size() {
        int sizeOfL = 0;
        Node curNode = startN;
        while (curNode != null) {
            sizeOfL++;
            curNode = curNode.getNext();
        }
        return sizeOfL;
    }

    @Override
    public ImmutableList clear() {

        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        sizeOfList = size();
        if(sizeOfList == 1 && startN.getData() == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object[] toArray() {
        sizeOfList = size();
        Object [] newArray = new Object[sizeOfList];
        Node current = startN;
        for(int i = 0; i < sizeOfList; i ++){
            newArray[i] = current.getData();
            current = current.getNext();
        }
        return newArray;
    }

    public String toString(){
        String presentation = " ";
        if (startN.getData() != null){
            presentation += startN.getData();
            Node start = startN;
            while(start.getNext()!= null){
                presentation += " --> ";
                start = start.getNext();
                presentation += start.getData();
            }
        }else{
            presentation = "is empty";
            return presentation;
        }
        return presentation;
    }


}
