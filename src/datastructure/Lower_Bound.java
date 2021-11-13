package datastructure;

import java.util.function.Predicate;

public class Lower_Bound<E> {
    public int lower_bound(E[] arr, Predicate<E> predicate) {
        for (int i = 0; i < arr.length; i++) {
            if (predicate.test(arr[i]))
                return i;
        }
        return -1;
    }
}
