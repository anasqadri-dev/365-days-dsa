public class Day39 {
    public int maximumProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int product = nums[i] * nums[j] * nums[k];
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }
        return maxProduct;
    }
}