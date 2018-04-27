package org.pg4200.sol01;

public class MyArrayIntegerContainer {

    private Integer[] data;

    private int size = 0;

    public MyArrayIntegerContainer(){
        this(10);
    }

    public MyArrayIntegerContainer(int maxSize){
        data = new Integer[maxSize];
    }

    public Integer get(int index) {
        if(index < 0 || index >= size){
            //some input validation
            return null;
        }
        return data[index];
    }

    public void add(Integer value) {
        data[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

}
