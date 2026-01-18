// Day 18
// LC 1365 – How Many Numbers Are Smaller Than the Current Number
// Difficulty: Easy
// Topic: Arrays

public class Day18 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int count[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[i] > nums[j]) {
                    count[i] = count[i] + 1;
                }
            }
        }
        return count;
    }
}