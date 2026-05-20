class Day139 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] stack = new int[n];
        int top = -1;
        int[][] map = new int[n][2];
        int mapSize = 0;
        for (int i = 0; i < n; i++) {
            int current = nums2[i];
            while (top != -1 && current > stack[top]) {
                int value = stack[top];
                top--;
                map[mapSize][0] = value;
                map[mapSize][1] = current;
                mapSize++;
            }
            top++;
            stack[top] = current;
        }
        while (top != -1) {
            int value = stack[top];
            top--;
            map[mapSize][0] = value;
            map[mapSize][1] = -1;
            mapSize++;
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[j][0] == nums1[i]) {
                    ans[i] = map[j][1];
                    break;
                }
            }
        }
        return ans;
    }
}