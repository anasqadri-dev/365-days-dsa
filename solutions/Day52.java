public class Day52 {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int width = j - i;
                int h = Math.min(height[i], height[j]);
                int area = width * h;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}