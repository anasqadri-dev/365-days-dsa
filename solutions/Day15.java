class Day15 {
    public int[] shuffle(int[] nums, int n) {
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        int arr3[] = new int[2 * n];

        for (int i = 0; i < n; i++) {
            arr1[i] = nums[i];
            arr2[i] = nums[i + n];
        }
        for (int i = 0; i < n; i++) {
            arr3[2 * i] = arr1[i];
            arr3[2 * i + 1] = arr2[i];
        }
        return arr3;
    }
}