import java.util.ArrayList;
//разделено для большей инкапсуляции
public class BinarySearch{
    public static <T extends Comparable<T>> int binarySearch(ArrayList<T> values, T valueToFind) {
        return binary(values, valueToFind, 0, values.size()-1);
    }

    private static<T extends Comparable<T>> int binary(ArrayList<T> values, T valueToFind, int l, int r)
    {
        while (l<=r) {
            int mid = (l + r) / 2;
            if (values.get(mid).compareTo(valueToFind) ==0) { //если объекты равны
                return mid;
            }
            if (values.get(mid).compareTo(valueToFind) <0) { //если искомый больше опорного
                l = mid+1;
            } else if (values.get(mid).compareTo(valueToFind) >0) { //если искомый меньше опорного
                r = mid-1;
            }

        }
        return -1;

    }
}