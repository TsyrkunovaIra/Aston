import java.util.ArrayList;

public class BinarySearch<T extends Comparable<T>>{
    public int binarySearch(ArrayList<T> values, T valueToFind) {
        return binary(values, valueToFind, 0, values.size()-1);
    }

    private int binary(ArrayList<T> values, T valueToFind, int l, int r)
    {
        int index = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (values.get(mid).compareTo(valueToFind) <0) {
                l = mid + 1;
            } else if (values.get(mid).compareTo(valueToFind) >0) {
                r = mid - 1;
            } else if (values.get(mid).compareTo(valueToFind) ==0) {
                index = mid;
                break;
            }
        }
        return index;
    }
}