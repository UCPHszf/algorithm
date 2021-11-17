package datastructure;

import java.util.Collection;
import java.util.function.Predicate;

public class Lower_Bound<E> {
    public E lower_bound(Collection<E> collection, E e, Predicate<E> predicate) {
        for (E item : collection) {
            if (predicate.test(item))
                return item;
        }
        return null;
    }
}
