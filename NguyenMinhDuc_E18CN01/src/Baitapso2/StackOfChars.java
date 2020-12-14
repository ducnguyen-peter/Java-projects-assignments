package Baitapso2;


public class StackOfChars {
    private char[] elements;
    private int size;
    public StackOfChars()
    {
        this.size = 0;
        this.elements = new char[16];
    }
    public StackOfChars(int capacity)
    {
        this.size = 0;
        this.elements = new char[capacity];
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public boolean isFull()
    {
        return size==elements.length;
    }
    public char peak()
    {
        return elements[size-1];
    }
    public void push(char value)
    {
        if(size<elements.length)
        {
            elements[size++] = value;
        }
        else if(size==elements.length)
        {
            char[] tmp = new char[++size];
            System.arraycopy(elements,0, tmp, 0, size-1);
            tmp[size-1] = value;
            elements = tmp;
        }
    }
    public char pop()
    {
        if(this.isEmpty()) return '\0';
        char val = elements[size-1];
        elements[size--] = 0;
        return val;
    }
    public int getSize()
    {
        return this.size;
    }
}