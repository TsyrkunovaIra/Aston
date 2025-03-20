import java.util.ArrayList;

public class BinarySearch<T extends Comparable<T>>{
    public int binarySearch(ArrayList<T> values, T valueToFind) {
        return binary(values, valueToFind, 0, values.size()-1);
    }

    private int binary(ArrayList<T> values, T valueToFind, int l, int r)
    {
        if (l == r) {
            return (values.get(l) == valueToFind) ? l : -1;
        }
        int m = l + (r - l) / 2;

        if (valueToFind.compareTo(values.get(m)) <=0) {
            return binary(values, valueToFind, m + 1, r);
        } else if (values.get(m).compareTo(valueToFind) >= 0) {
            return binary(values, valueToFind, l, m - 1);
        }
        return m;
    }
}