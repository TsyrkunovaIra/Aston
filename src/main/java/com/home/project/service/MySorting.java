package com.home.project.service;

import java.util.ArrayList;
import java.util.Comparator;

public class MySorting {
    public static <T> void quickSort(MyArrayList<T> arr, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pi = partition(arr, low, high, comparator);
            quickSort(arr, low, pi - 1, comparator);
            quickSort(arr, pi + 1, high, comparator);
        }
    }
    private static <T> int partition(MyArrayList<T> arr, int low, int high, Comparator<T> comparator) {
        T pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(arr.get(j), pivot) <= 0) {
                i++;
                T temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }


        T temp = arr.get(i + 1); //обмен значениями
        arr.set(i+1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }
}