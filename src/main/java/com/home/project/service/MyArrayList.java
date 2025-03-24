package com.home.project.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList {
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
    private int size() {
        return size;
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

    public boolean add(Object object){
        if (size == elements.length){
            elements = capacityGrowth();
        }
        elements[size] = object;
        size++;
        return true;
    }

    private int checkingIndex(int index){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("Элемент не найден!!! " + arrayLimit(index));
        }
        return index;
    }

    private String arrayLimit (int index){
        return "Количество элементов в массвие: " + size +"общий размер массива: "+ elements.length;
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

    public Object get (int index){
        checkingIndex(index);
        return elements[index];
    }

    public Object remove (int index){
        checkingIndex(index);
        Object[] objects = elements;
        elements = new Object[objects.length-1];
        Object object = objects[index];
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

}


