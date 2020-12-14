package Baitapso2;

import javax.lang.model.type.NullType;
import java.util.*;

public class StackOfIntegers {
    private int[] elements;
    private int size;
    public StackOfIntegers()
    {
        this.size = 0;
        this.elements = new int[16];
    }
    public StackOfIntegers(int capacity)
    {
        this.size = 0;
        this.elements = new int[capacity];
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public boolean isFull()
    {
        return size==elements.length;
    }
    public int peak()
    {
        if(this.isEmpty()) return '\0';
        return elements[size-1];
    }
    public void push(int value)
    {
        if(size<elements.length)
        {
            elements[size++] = value;
        }
        else if(size==elements.length)
        {
            int[] tmp = new int[++size];
            System.arraycopy(elements,0, tmp, 0, size-1);
            tmp[size-1] = value;
            elements = tmp;
        }
    }
    public int pop()
    {
        if(size==0) return '\0';
        int val = elements[size-1];
        elements[size-1] = 0;
        size--;
        return val;
    }
    public int getSize()
    {
        return this.size;
    }
}
