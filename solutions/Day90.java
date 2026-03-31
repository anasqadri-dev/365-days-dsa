public class Day90 {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 0;
        for (int q : quantities)
            right = Math.max(right, q);
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(n, quantities, mid)) {
                ans = mid;
                right = mid - 1; 
            } else
                left = mid + 1;
        }
        return ans;
    }
    private boolean canDistribute(int n, int[] quantities, int x) {
        int stores = 0;
        for (int q : quantities)
            stores += (q + x - 1) / x;
        return stores <= n;
    }
}