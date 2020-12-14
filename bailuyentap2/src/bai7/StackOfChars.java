package bai7;

public class StackOfChars {
    private char[] elements;
    private int size;

    public StackOfChars() {
        elements = new char[16];
        size = 0;
    }

    public StackOfChars(int capacity) {
        elements = new char[capacity];
        size = 0;
    }

    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }
    public boolean isFull(){
        if(size == elements.length) return true;
        return false;
    }

    public char peak(){
        return elements[size-1];
    }

    public void push(char ch){
        elements[size] = ch;
        size++;
    }

    public char pop(){
        size--;
        return elements[size];
    }

    public int getSize(){
        return size;
    }

}
