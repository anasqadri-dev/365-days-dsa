class Day100 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];
        List<Integer> window = new ArrayList<>();
        for(int i = 0; i < k; i++)
            window.add(nums[i]);
        Collections.sort(window);
        int index = 0;
        for(int i = k; i <= n; i++){
            if(k % 2 == 1)
                result[index] = window.get(k/2);
            else
                result[index] = ((double)window.get(k/2) + window.get(k/2 - 1)) / 2;
            index++;
            if(i == n) break;
            window.remove(Integer.valueOf(nums[i - k]));
            window.add(nums[i]);
            Collections.sort(window);
        }
        return result;
    }
}