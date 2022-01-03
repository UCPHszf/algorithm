package greedy;

public class MaximumNumberofWeeksforWhichYouCanWork1953 {
    public long numberOfWeeks(int[] milestones) {
        long max = 0;
        long sum = 0;
        for (int i = 0; i < milestones.length; i++) {
            max = Math.max(max, milestones[i]);
            sum += milestones[i];
        }
        return max > sum - max ? (sum - max) * 2 + 1 : sum;
    }
}
