package arr;

public class SingleNumberII137 {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int x : nums) {
            one = (one ^ x) & ~two;
            two = (two ^ x) & ~one;
        }
        return one;
    }
}
