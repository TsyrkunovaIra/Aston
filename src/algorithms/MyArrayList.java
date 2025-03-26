package src.algorithms;

import java.io.Serializable;
import java.util.*;

public class MyArrayList<T>  implements Iterable<T>, Serializable {
    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_CAPACITY = 10;
    transient Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.elements = new Object[initialCapacity];
        } else {
            throw new IllegalStateException("Начальная емкость (initialCapacity) не может быть меньше или равен нулю");
        }
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Object[] capacityGrowth(int minCapacity ) {
        int capacity = elements.length;
        if (capacity > 0) {
            Object[] newCapacity = new Object[(elements.length * 2)];
            System.arraycopy(elements, 0, newCapacity, 0, elements.length);
            return newCapacity;
        }else{
            return elements = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }}

    private Object[] capacityGrowth() {
        return capacityGrowth(size + 1);
    }

    public boolean add(T object){
        if (size == elements.length){
            elements = capacityGrowth();
        }
        elements[size] = object;
        size++;
        return true;
    }

    public boolean addAll(MyArrayList otherList) {
        if (otherList == null || otherList.size == 0) {
            return false;
        }

        int newSize = this.size + otherList.size;

        if (newSize > this.elements.length) {
            this.elements = capacityGrowth(newSize);
        }

        if (otherList.elements != null) {
            System.arraycopy(otherList.elements, 0, this.elements, this.size, otherList.size);
            this.size = newSize;
            return true;
        } else {
            return false;
        }
    }

    public void addAll(List<Object> list) {
        for (Object obj : list) {
            this.add((T) obj);
        }
    }

    private int checkingIndex(int index){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("Элемент не найден!!! " + arrayLimit(index));
        }
        return index;
    }

    private String arrayLimit (int index){
        return "Количество элементов в массиве: " + size +"общий размер массива: "+ elements.length;
    }

    public void add(int index, Object object){
        checkingIndex(index);
        final int i;
        Object[] elements;
        if ((i = size) == (elements = this.elements).length)
            elements = capacityGrowth();
        System.arraycopy(elements, index, elements, index+1, i-index); // увеличиваем массив, сдвигая его с помощью копирования
        elements[index] = object;
        size = i + 1;
    }

    public T get (int index){
        checkingIndex(index);
        return (T) elements[index];
    }

    public T remove (int index){
        checkingIndex(index);
        Object[] objects = elements;
        elements = new Object[objects.length-1];
        T object = (T) objects[index];
        System.arraycopy(objects,0,elements,0,index);
        System.arraycopy(objects,index +1, elements, index,objects.length);
        size--;
        return object;
    }

    public void clear(){
        Object[] objects = elements;
        for (int s = size, i =size = 0; i < s; i++)
            objects[i]= null;
    }

    public T set(int index, T element) {
        checkingIndex(index);
        T oldElement = (T) elements[index];
        elements[index] = element;
        return oldElement;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                return (T) elements[index++];
            }
        };
    }
}