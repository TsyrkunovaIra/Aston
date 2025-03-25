package com.home.project.service;

import java.util.*;

public class MyArrayList implements List<Object> {
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

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Object> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
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

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(MyArrayList otherList) {
        if (otherList == null || otherList.size == 0) {
            return false;
        }

        int newSize = this.size + otherList.size;
        if (newSize > elements.length) {
            elements = capacityGrowth(newSize);
        }
        System.arraycopy(otherList.elements, 0, this.elements, this.size, otherList.size);
        this.size = newSize;
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

    @Override
    public Object set(int index, Object element) {
        return null;
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

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Object> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Object> listIterator(int index) {
        return null;
    }

    @Override
    public List<Object> subList(int fromIndex, int toIndex) {
        return null;
    }

    public void clear(){
        Object[] objects = elements;
        for (int s = size, i =size = 0; i < s; i++)
            objects[i]= null;
    }

}