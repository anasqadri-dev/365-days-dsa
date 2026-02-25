class Day56 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x2 - x1 > k)
                    break;
                int value = y1 + y2 + (x2 - x1);
                if (value > max)
                    max = value;
            }
        }
        return max;
    }
}