package com.home.project.service;

import java.util.ArrayList;
import java.util.Comparator;

public class MyBinarySearch {
    public static <T> int binarySearch(MyArrayList<T> values, T valueToFind, Comparator<? super T> comparator) {
        return binary(values, valueToFind, 0, values.size() - 1, comparator);
    }

    private static <T> int binary(MyArrayList<T> values, T valueToFind, int l, int r, Comparator<? super T> comparator) {
        while (l <= r) {
            int mid = (l + r) / 2;
            int comparisonResult = comparator.compare(values.get(mid), valueToFind);

            if (comparisonResult == 0) {
                return mid;
            }
            if (comparisonResult < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

}