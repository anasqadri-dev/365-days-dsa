public class Day17 {
    public int numIdenticalPairs(int[] nums) {
        int no_of_goodPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    no_of_goodPairs++;
                }
            }
        }
        return no_of_goodPairs;
    }
}