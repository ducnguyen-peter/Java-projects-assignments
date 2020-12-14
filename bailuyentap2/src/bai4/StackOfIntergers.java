package bai4;

public class StackOfIntergers {
    private int[] elements;
    private int size;

    public StackOfIntergers() {
        elements = new int[16];
        size = 0;
    }

    public StackOfIntergers(int capacity) {
        elements = new int[capacity];
        size = 0;
    }

    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }

    public boolean isFull(){
        if (size == elements.length) return true;
        else return false;
    }

    public int peak(){
        return elements[size-1];
    }

    public void push(int value){
        elements[size] = value;
        size++;
    }

    public int pop(){
        size--;
        return elements[size];
    }

    public int getSize(){
        return size;
    }
}
