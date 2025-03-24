package src.algorithms;

import java.util.ArrayList;

public class MySorting {
    public static <T extends Comparable<T>> void quickSort(ArrayList<T> arr, int low, int high)
    {
        if(low < high) {
            int pi = partition(arr, low, high); //опорный элемент
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private static<T extends Comparable<T>> int partition(ArrayList<T> arr, int low, int high) {
        T pivot = arr.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr.get(j).compareTo(pivot) <= 0) {
                i++;
                T temp = arr.get(i); //обмен значениями
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
