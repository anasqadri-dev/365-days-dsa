public class Day51 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int result = nums[0];
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            result = Math.max(result, product);
            if (product == 0) {
                product = 1;
            }
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            result = Math.max(result, product);
            if (product == 0) {
                product = 1;
            }
        }
        return result;
    }
}