class Day64 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (existsInArray(nums1[i], nums2) && !existsInArray(nums1[i], temp, index)) {
                temp[index] = nums1[i];
                index++;
            }
        }
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }
        return result;
    }
    public boolean existsInArray(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) return true;
        }
        return false;
    }
    public boolean existsInArray(int num, int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == num) return true;
        }
        return false;
    }
}