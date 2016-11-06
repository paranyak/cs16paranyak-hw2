package ua.edu.ucu.collections.immutable;


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
        int sizeOfFirstArray = myList.length;
        Object [] arrayNew1 = new Object[sizeOfFirstArray + 1];
        System.arraycopy(myList, 0, arrayNew1, 0, index+1);
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
       return myList[index];
    }

    @Override
    public ImmutableList remove(int index) {
        int sizeOfFirstArray = myList.length;
        Object [] arrayNew1 = new Object[sizeOfFirstArray - 1];
        System.arraycopy(myList, 0, arrayNew1, 0, index);
        System.arraycopy(myList, index+1, arrayNew1, index, sizeOfFirstArray - index-1);
        return new ImmutableArrayList(arrayNew1);
    }

    @Override
    public ImmutableList set(int index, Object e) {
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
        for(int i = 0; i < myList.length; i ++){
            presentation += myList[i];
            presentation += " ";
        }
        return presentation;
    }
    public static void main(String [] args){
        ImmutableList a = new ImmutableArrayList();
        a = a.add(1);
        a = a.add(2);
        a = a.add(3);
        a = a.add(4);
        a = a.add(5);
        a = a.add(6);
        a = a.add(7);
        a = a.add(8);
        a = a.add(9);
        a = a.add(10);
        System.out.println("a: "+ a);

        ImmutableList a_1 = a.add(11);
        System.out.println("a_1(add to a 11): "+a_1);

        ImmutableList a_2 = a.add(4, 100);
        System.out.println("a_2(add to a on 4 index 100): "+ a_2);

        Integer [] c = {11, 12, 13};
        ImmutableList b = a.addAll(c);
        System.out.println("b: "+ b);

        Integer [] c1 = {15, 16, 17};
        ImmutableList b1 = a.addAll(0, c1);
        System.out.println("b1: "+ b1);

        System.out.println(b1.get(4));

        ImmutableList c_1 = a.remove(1);
        System.out.println("c_1:  "+c_1);

        ImmutableList d = a.set(5, 100);
        System.out.println("d: " + d);
    }
}
