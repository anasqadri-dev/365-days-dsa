class Day79 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int[] merged = new int[size1 + size2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < size1 && j < size2) {
            if (nums1[i] < nums2[j]) {
                merged[k] = nums1[i];
                i++;
            } else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < size1) {
            merged[k] = nums1[i];
            i++;
            k++;
        }
        while (j < size2) {
            merged[k] = nums2[j];
            j++;
            k++;
        }
        int total = size1 + size2;
        if (total % 2 == 1) {
            return merged[total / 2];
        } else {
            int mid1 = merged[total / 2];
            int mid2 = merged[(total / 2) - 1];
            return (mid1 + mid2) / 2.0;
        }
    }
}