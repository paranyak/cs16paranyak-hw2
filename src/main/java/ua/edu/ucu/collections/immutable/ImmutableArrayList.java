package ua.edu.ucu.collections.immutable;


import java.util.InputMismatchException;
import java.util.Objects;

public class ImmutableArrayList implements ImmutableList{
    Object[] myList;
    public ImmutableArrayList(){
        this.myList = new Object[0];
    }
    public ImmutableArrayList(Object[] m) {
        this.myList = m;
    }
        @Override
    public ImmutableList add(Object e) {
            int sizeOfFirstArray = myList.length;
            Object [] arrayNew = new Object[sizeOfFirstArray + 1];
            System.arraycopy(myList, 0, arrayNew, 0, sizeOfFirstArray);
            arrayNew[sizeOfFirstArray] = e;
        return new ImmutableArrayList(arrayNew);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index < 0 || index > myList.length){
            throw new InputMismatchException("Index out of range");
        }
        int sizeOfFirstArray = myList.length;
        Object [] arrayNew1 = new Object[sizeOfFirstArray + 1];
        System.arraycopy(myList, 0, arrayNew1, 0, index);
        arrayNew1[index] = e;
        System.arraycopy(myList, index, arrayNew1, index+1, sizeOfFirstArray - index);
        return new ImmutableArrayList(arrayNew1);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        int sizeOfFirstArray = myList.length;
        Object [] arrayNew = new Object[sizeOfFirstArray +c.length];
        System.arraycopy(myList, 0, arrayNew, 0, sizeOfFirstArray);
        for(int i = 0; i < c.length; i++){
            arrayNew[sizeOfFirstArray + i] = c[i];
        }
        return new ImmutableArrayList(arrayNew);    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > myList.length){
            throw new InputMismatchException("Index out of range");
        }
        int sizeOfFirstArray = myList.length;
        Object [] arrayNew1 = new Object[sizeOfFirstArray + c.length];
        System.arraycopy(myList, 0, arrayNew1, 0, index);
        for(int i = 0; i < c.length; i++){
            arrayNew1[index+i] = c[i];
        }
        System.arraycopy(myList, index, arrayNew1, index+c.length, sizeOfFirstArray - index);
        return new ImmutableArrayList(arrayNew1);    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > myList.length){
            throw new InputMismatchException("Index out of range");
        }
        return myList[index];

    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index > myList.length){
            throw new InputMismatchException("Index out of range");
        }
        int sizeOfFirstArray = myList.length;
        Object [] arrayNew1 = new Object[sizeOfFirstArray - 1];
        System.arraycopy(myList, 0, arrayNew1, 0, index);
        System.arraycopy(myList, index+1, arrayNew1, index, sizeOfFirstArray - index-1);
        return new ImmutableArrayList(arrayNew1);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 || index > myList.length){
            throw new InputMismatchException("Index out of range");
        }
        Object [] arrayNew1 = new Object[myList.length];
        System.arraycopy(myList, 0, arrayNew1, 0, myList.length);
        arrayNew1[index] = e;
        return new ImmutableArrayList(arrayNew1);
    }

    @Override
    public int indexOf(Object e) {
        for(int i = 0; i < myList.length; i++){
            if(myList[i] == e){
                return i;
            }
        }return -1;
    }

    @Override
    public int size() {
        return myList.length;
    }

    @Override
    public ImmutableList clear() {
        Object [] arrayN = new Object[0];
        return new ImmutableArrayList(arrayN);
    }

    @Override
    public boolean isEmpty() {
        if(myList.length == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object[] toArray() {
        return myList;
    }

    public String toString(){
        String presentation = " ";

        if(myList.length == 0){
            presentation = "is empty";
        }else{
            for(int i = 0; i < myList.length-1; i ++){
                presentation += myList[i];
                presentation += ",";
            }
            presentation += myList[myList.length-1];
        }

        return presentation;
    }

}
