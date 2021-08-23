package design;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class DataStreamasDisjointIntervals352 {
    final double INF = 1e18;

    class Pair<E, V> {
        E lowerBound;
        V upperBound;

        public Pair(E lowerBound, V upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        public E getLowerBound() {
            return lowerBound;
        }

        public void setLowerBound(E lowerBound) {
            this.lowerBound = lowerBound;
        }

        public V getUpperBound() {
            return upperBound;
        }

        public void setUpperBound(V upperBound) {
            this.upperBound = upperBound;
        }
    }

    Set<Pair<Long, Long>> s;

    /**
     * Initialize your data structure here.
     */
    public DataStreamasDisjointIntervals352() {
        s = new TreeSet<>();

    }

    public void addNum(int val) {
        Optional<Pair<Long, Long>> op = s.stream().filter(p -> p.lowerBound > val)

        if (op.isPresent()) {
            Pair<Long, Long> pair = op.get();

        } else {

        }
    }

    public int[][] getIntervals() {

    }
}
